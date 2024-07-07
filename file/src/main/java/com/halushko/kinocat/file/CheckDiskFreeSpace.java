package com.halushko.kinocat.file;

import com.halushko.kinocat.core.Queues;
import com.halushko.kinocat.core.handlers.input.CliCommandExecutor;
import com.halushko.kinocat.core.rabbit.SmartJson;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.List;

@Slf4j
public class CheckDiskFreeSpace extends CliCommandExecutor {
    @Override
    protected String getResultString(List<String> lines, SmartJson rabbitMessage) {
        log.debug(String.format("[CheckDiskFreeSpace] df -h result:\n[%s]", String.join("\n", lines)));
        log.debug(String.format("[CheckDiskFreeSpace] names:\n[%s]", String.join("\n", Constants.DEVICES.keySet())));
        log.debug(String.format("[CheckDiskFreeSpace] devices:\n[%s]", String.join("\n", Constants.DEVICES.keySet())));

        StringBuilder sb = new StringBuilder("Вільного місця у сховищі:");
        for (val device : Constants.DEVICES.entrySet()) {
            boolean storageIsFound = false;
            for (String line : lines) {
                if (line.matches(device.getValue() + ".*")) {
                    sb.append("\n").append(device.getKey());
                    sb.append(": ").append(getSize(line));

                    log.debug(String.format("[CheckDiskFreeSpace] Folder [%s] is present in line [%s]", device.getKey(), line));
                    storageIsFound = true;
                    break;
                }
                log.debug(String.format("[CheckDiskFreeSpace] Folder [%s] is NOT present in line [%s]", device.getKey(), line));
            }
            if (!storageIsFound) {
                sb.append("\n").append(device.getKey()).append(": не вказано Filesystem у налаштуваннях");
            }
        }

        return sb.toString();
    }

    private static String getSize(String line) {
        String size = line;
        size = size.replaceAll("^\\S+\\s+\\S+\\s+\\S+\\s+", "");
        size = size.replaceAll("\\S+\\s+\\S+\\s*$", "");
        return size;
    }

    @Override
    protected String getQueue() {
        return Queues.File.SHOW_FREE_SPACE;
    }

    @Override
    protected String[] getScript(SmartJson rabbitMessage) {
        return new String[]{
                "/bin/df",
                "-h"
        };
    }
}
