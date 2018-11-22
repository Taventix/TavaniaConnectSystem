package de.taventix.signsystem.interfaces;

public abstract interface SignDesign {

    void setOnline(ServerInfo info, String server);

    void setOnlineP(ServerInfo info, String server);

    void setOffline();

    void setWartung();

    String[] getClickPacket();

}
