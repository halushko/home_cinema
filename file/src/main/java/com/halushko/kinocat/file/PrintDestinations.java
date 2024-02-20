package com.halushko.kinocat.file;

import com.halushko.kinocat.core.Commands;
import com.halushko.kinocat.core.JsonConstants.SmartJsonKeys;
import com.halushko.kinocat.core.Queues;
import com.halushko.kinocat.core.handlers.input.CliCommandExecutor;
import com.halushko.kinocat.core.rabbit.SmartJson;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class PrintDestinations extends CliCommandExecutor {
    @Override
    protected String getResultString(List<String> lines, SmartJson rabbitMessage) {
        String[] result = new String[4];
        result[0] = "(";
        result[2] = ") ";
        for (String line : lines) {
            if (line.matches(Constants.NAME_LINE)) {
                result[3] = line.replaceFirst(Constants.NAME_LINE, "");
            }
            if (line.matches(Constants.SIZE_LINE)) {
                result[1] = line.replaceFirst(Constants.SIZE_LINE, "");
            }
        }
        String fileName = rabbitMessage.getValue(SmartJsonKeys.FILE_ID).replaceAll("\\.torrent$", "");
        return String.format("%s%s",
                String.join("", result),
                Constants.FOLDERS.keySet().stream()
                        .map(folder ->
                                String.format("\\n%s: %s_%s_%s",
                                        getServiceLable(folder),
                                        Commands.File.SELECT_DESTINATION,
                                        getServiceLable(folder),
                                        fileName
                                )
                        )
                        .collect(Collectors.joining(""))
        );
    }

    private static String getServiceLable(String folder) {
        return folder.isEmpty() ? Constants.EMPTY_SERVICE_DEFAULT_NAME : folder;
    }

    @Override
    protected String getQueue() {
        return Queues.File.CHOOSE_THE_DESTINATION;
    }

    @Override
    protected String getScript(SmartJson rabbitMessage) {
        return String.format("transmission-show %s", rabbitMessage.getValue(SmartJsonKeys.FILE_PATH));
    }
}