package de.taventix.signsystem.interfaces;

public abstract interface SignDesign {

    public abstract void setOnline(ServerInfo paramServerInfo, DynamicSign paramDynamicSign, String paramString);

    public abstract void setOnlineP(ServerInfo paramServerInfo, DynamicSign paramDynamicSign, String paramString);

    public abstract void setOffline(DynamicSign paramDynamicSign);

    public abstract void setWartung(DynamicSign paramDynamicSign);

    public abstract String[] getClickPacket();

}
