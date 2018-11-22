package de.taventix.signsystem.interfaces;

public abstract interface ServerInfo {

    public abstract int getOnlinePlayers();

    public abstract int getMaxPlayers();

    public abstract boolean isOnline();

    public abstract String getMotd();

    public abstract long getPing();

}
