package com.halushko.kinocat.core.commands;

@SuppressWarnings("unused")
public interface Constants {
    interface Queues {
        interface Telegram {
            String TELEGRAM_INPUT_FILE = "TELEGRAM_INPUT_FILE_QUEUE";
            String TELEGRAM_OUTPUT_TEXT = "TELEGRAM_OUTPUT_TEXT_QUEUE";
            String TELEGRAM_INPUT_TEXT = "TELEGRAM_INPUT_TEXT_QUEUE";
        }

        interface Torrent {
            String TORRENTS_LIST = "EXECUTE_TORRENT_COMMAND_LIST";
            String FILES_LIST = "EXECUTE_TORRENT_COMMAND_LIST_FILES";
            String TORRENT_INFO = "EXECUTE_TORRENT_COMMAND_INFO";
            String TORRENT_COMMANDS = "EXECUTE_TORRENT_COMMAND_SHOW_COMMANDS";
            String RESUME_TORRENT = "EXECUTE_TORRENT_COMMAND_RESUME_TORRENT";
            String PAUSE_TORRENT = "EXECUTE_TORRENT_COMMAND_PAUSE_TORRENT";
            String RESUME_ALL = "EXECUTE_TORRENT_COMMAND_RESUME_ALL_TORRENTS";
            String PAUSE_ALL = "EXECUTE_TORRENT_COMMAND_PAUSE_ALL_TORRENTS";
            String DELETE = "EXECUTE_TORRENT_COMMAND_DELETE";
            String DELETE_ONLY_TORRENT = "EXECUTE_TORRENT_COMMAND_DELETE_ONLY_TORRENT";
            String DELETE_WITH_FILES = "EXECUTE_TORRENT_COMMAND_DELETE_WITH_FILES";

        }

        interface MediaServer {
            String EXECUTE_MINIDLNA_COMMAND = "EXECUTE_MINIDLNA_COMMAND_QUEUE";
        }
    }

    interface Commands {
        interface Torrent {
            String LIST_TORRENTS = "/list";
            String LIST_TORRENT_COMMANDS = "/more_";
            String RESUME = "/resume_";
            String PAUSE = "/pause_";
            String RESUME_ALL = "/resume_all";
            String PAUSE_ALL = "/pause_all";
            String TORRENT_INFO = "/full_info_";
            String REMOVE_WITH_FILES = "/approve_with_files_";
            String REMOVE_JUST_TORRENT = "/approve_just_torrent_";
            String LIST_FILES = "/files_";
            String REMOVE_COMMAND = "/remove_";

        }

        interface Text {
            String SEND_TEXT_TO_USER = "#$SEND_TEXT_TO_USER$#";
            String SEPARATOR = "#$SEPARATOR$#";
            String REMOVE_WARN_TEXT_FUNC = "askRemoveTorrent";
        }
    }
}
