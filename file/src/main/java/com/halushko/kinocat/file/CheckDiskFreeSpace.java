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
        log.debug(String.format("[CheckDiskFreeSpace] [%s]", String.join(", ", lines)));
        StringBuilder sb = new StringBuilder("Вільного місця у сховищі:");

        for (String line : lines) {
            sb.append("\n").append(line);
        }

        for (val device : Constants.FOLDERS.entrySet()) {
            boolean flag = false;
            sb.append("\n").append(device.getKey());
            for (String line : lines) {
                if (line.matches(device.getKey() + ".*")) {
                    String size = line;
                    size = size.replaceAll("^\\S+\\s+\\S+\\s+\\S+\\s+", "");
                    size = size.replaceAll("\\S+\\s+\\S+\\s*$", "");

                    sb.append("\n").append(device.getKey());
                    sb.append(": ").append(size);

                    flag = true;
                    break;
                }
            }
            if (!flag) {
                sb.append("\n").append(device.getKey()).append(": не вказано Filesystem у налаштуваннях");
            }
        }

        return sb.toString();
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
