#!/bin/bash

stop_broker() {
    /usr/bin/docker-compose -f /home/dima/media/docker-compose-broker.yml down
}

stop_media() {
    /usr/bin/docker-compose -f /home/dima/media/docker-compose-media.yml down
}

stop_bot() {
    /usr/bin/docker-compose -f /home/dima/media/docker-compose-bot.yml down
}

stop_torrent() {
    /usr/bin/docker-compose -f /home/dima/media/docker-compose-torrent.yml down
}

stop_torrent_hdd() {
    /usr/bin/docker-compose -f /home/dima/media/docker-compose-torrent-hdd.yml down
}

stop_torrent_low() {
    /usr/bin/docker-compose -f /home/dima/media/docker-compose-torrent-low.yml down
}

keys_specified=false

while (( "$#" )); do
    case "$1" in
        -r) stop_broker; keys_specified=true ;;
        -m) stop_media; keys_specified=true ;;
        -b) stop_bot; keys_specified=true ;;
        -tt) stop_torrent; keys_specified=true ;;
        -th) stop_torrent_hdd; keys_specified=true ;;
        -tl) stop_torrent_low; keys_specified=true ;;
        -t) stop_torrent; stop_torrent_hdd; stop_torrent_low; keys_specified=true ;;
        -h) echo "Tool for kino-cat docker-containers stop:" ;
            echo "            -h   print help" ;
            echo "            -r   stop broker" :
            echo "            -m   stop media" ;
            echo "            -b   stop bot" ;
            echo "            -t   stop all torrent clients";
            echo "            -tt  stop main torrent client";
            echo "            -th  stop HDD torrent client";
            echo "            -tl  stop Low torrent client"; keys_specified=true ;;
        *) echo "Unexpected key: $1" >&2; exit 1 ;;
    esac
    shift
done

if ! $keys_specified; then
    stop_broker
    stop_media
    stop_bot
    stop_torrent
    stop_torrent_hdd
    stop_torrent_low
fi

echo "Services has been stoped"
