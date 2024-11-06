package com.halushko.kinocat.text;

import com.halushko.kinocat.core.Commands;
import com.halushko.kinocat.core.Queues;
import com.halushko.kinocat.text.commands.CommandProperties;
import com.halushko.kinocat.text.commands.CommandsCollection;

public interface Constants {
    CommandsCollection COMMANDS_COLLECTION = new CommandsCollection() {{
        addValue(Commands.Torrent.LIST_TORRENTS,
                Queues.Torrent.TORRENTS_LIST,
                "<сервер> відобразити всі торенти",
                CommandProperties.CONTAINS_SERVER_NUMBER,
                CommandProperties.CAN_BE_NOT_TORRENT
        );
        addValue(Commands.Torrent.LIST_TORRENT_COMMANDS,
                Queues.Torrent.TORRENT_COMMANDS,
                "<сервер> <номер торента> перелічити можливі команди для вказаного торента",
                CommandProperties.CONTAINS_SERVER_NUMBER
        );
        addValue(Commands.Torrent.LIST_FILES,
                Queues.Torrent.FILES_LIST,
                "<сервер> <номер торента> відобразити всі файли, що будуть скачані в цьому торенті",
                CommandProperties.CONTAINS_SERVER_NUMBER,
                CommandProperties.CAN_BE_NOT_TORRENT
        );
        addValue(Commands.Torrent.TORRENT_INFO,
                Queues.Torrent.TORRENT_INFO,
                "<сервер> <номер торента> відобразити інформацію по торенту",
                CommandProperties.CONTAINS_SERVER_NUMBER,
                CommandProperties.CAN_BE_NOT_TORRENT
        );
        addValue(Commands.Torrent.RESUME,
                Queues.Torrent.RESUME_TORRENT,
                "<сервер> <номер торента> почати закачувати цей торент",
                CommandProperties.CONTAINS_SERVER_NUMBER
        );
        addValue(Commands.Torrent.PAUSE,
                Queues.Torrent.PAUSE_TORRENT,
                "<сервер> <номер торента> припинити закачувати цей торент",
                CommandProperties.CONTAINS_SERVER_NUMBER
        );
        addValue(Commands.Torrent.RESUME_ALL,
                Queues.Torrent.RESUME_ALL,
                "<сервер> почати закачувати всі торенти",
                CommandProperties.CONTAINS_SERVER_NUMBER
        );
        addValue(Commands.Torrent.PAUSE_ALL,
                Queues.Torrent.PAUSE_ALL,
                "<сервер> припинити закачувати всі тореенти",
                CommandProperties.CONTAINS_SERVER_NUMBER
        );
        addValue(Commands.Torrent.REMOVE_WITH_FILES,
                Queues.Torrent.DELETE_WITH_FILES,
                "<сервер> <номер торента> видалити вказаний торент разом з файлами",
                CommandProperties.CONTAINS_SERVER_NUMBER
        );
        addValue(Commands.Torrent.REMOVE_JUST_TORRENT,
                Queues.Torrent.DELETE_ONLY_TORRENT,
                "<сервер> <номер торента> видалити вказаний торент, але залишити файли",
                CommandProperties.CONTAINS_SERVER_NUMBER
        );
        addValue(Commands.Torrent.REMOVE_COMMAND,
                Queues.Torrent.DELETE,
                "<сервер> <номер торента> почати процедуру видалення вказаного торента",
                CommandProperties.CONTAINS_SERVER_NUMBER
        );

        addValue("<текст>",
                Queues.Torrent.SEARCH_BY_NAME,
                "шукати токент за назвою",
                CommandProperties.EMPTY_INSTANCE
        );
        addValue(Commands.Torrent.LIST_TORRENTS_IN_DOWNLOAD_STATUS,
                Queues.Torrent.LIST_TORRENTS_IN_DOWNLOAD_STATUS,
                "<сервер> відобразити всі торенти що знаходяться в стані \"завантаження\"",
                CommandProperties.CONTAINS_SERVER_NUMBER
        );

        addValue(Commands.Text.HELP,
                Queues.Text.HELP,
                "вивести інформацію по всім командам"
        );

        addValue(Commands.File.SELECT_DESTINATION,
                Queues.File.MOVE_TO_FOLDER,
                "<папка> <файл> обрати в яку папку буде завантаження"
        );

        addValue(Commands.File.SHOW_FREE_SPACE,
                Queues.File.SHOW_FREE_SPACE,
                "відобразити вільне місце у сховищі"
        );
    }};
}
