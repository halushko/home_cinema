package com.halushko.kinocat.core;

@SuppressWarnings("unused")
public interface Commands {
    interface Text {
        String HELP = "/help";
    }

    interface Torrent {
        String LIST_TORRENTS = "/list";
        String LIST_TORRENT_COMMANDS = "/more_";
        String RESUME = "/resume_";
        String PAUSE = "/pause_";
        String RESUME_ALL = "/resume_all";
        String PAUSE_ALL = "/pause_all";
        String TORRENT_INFO = "/info_";
        String REMOVE_WITH_FILES = "/approve_with_files_";
        String REMOVE_JUST_TORRENT = "/approve_just_torrent_";
        String LIST_FILES = "/files_";
        String REMOVE_COMMAND = "/remove_";
        String LIST_TORRENTS_IN_DOWNLOAD_STATUS = "/downloads";
    }

    interface File {
        String SELECT_DESTINATION = "/start_";
        String SHOW_FREE_SPACE = "/space";
    }
}
