package de.taventix.signsystem.interfaces;

public abstract interface ServerInfo {

    int getOnlinePlayers();

    int getMaxPlayers();

    boolean isOnline();

    String getMotd();

    long getPing();


}
