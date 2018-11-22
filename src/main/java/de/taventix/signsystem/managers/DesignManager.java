package de.taventix.signsystem.managers;

import de.taventix.signsystem.interfaces.ServerInfo;
import de.taventix.signsystem.interfaces.SignDesign;

public class DesignManager implements SignDesign {
    @Override
    public void setOnline(ServerInfo info, String server) {

    }

    @Override
    public void setOnlineP(ServerInfo info, String server) {

    }

    @Override
    public void setOffline() {

    }

    @Override
    public void setWartung() {

    }

    @Override
    public String[] getClickPacket() {
        return new String[0];
    }
}
