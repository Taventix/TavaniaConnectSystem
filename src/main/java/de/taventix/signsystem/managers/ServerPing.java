package de.taventix.signsystem.managers;

import de.taventix.signsystem.interfaces.ServerInfo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerPing {

    public static ServerInfo ping(String host, int port) {
        final long time = System.currentTimeMillis();
        try {
            Socket socket = new Socket(host, port);
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            out.write(0xFE);

            byte[] answereBytes = new byte[256];
            in.read(answereBytes);

            byte[] newBytes = new byte[128];
            int remove = 0;

            for (int i = 0; i < 128; i++) {
                if ((answereBytes[2 * i] <= 0x1f && answereBytes[2 * i] >= 0x00)) {
                    remove++;
                } else {
                    newBytes[i - remove] = answereBytes[2 * i];
                }
            }

            String answere = new String(newBytes, "Cp1252");
            answere = answere.substring(1);

            if (!(answereBytes[0] == 0xFF)) {

                String splitByte = String.valueOf((char) 0xA7);
                String[] info = answere.split(splitByte);

                final String motd = info[0];
                final int onlineplayers = new Integer(info[1].trim());
                final int maxplayers = new Integer(info[2].trim());
                final boolean online = true;
                final long ping = System.currentTimeMillis();
                ServerInfo infos = new ServerInfo() {

                    @Override
                    public boolean isOnline() {
                        return online;
                    }

                    @Override
                    public int getOnlinePlayers() {
                        return onlineplayers;
                    }

                    @Override
                    public String getMotd() {
                        return motd;
                    }

                    @Override
                    public int getMaxPlayers() {
                        return maxplayers;
                    }

                    @Override
                    public long getPing() {
                        return ping - time;
                    }

                };
                socket.close();
                return infos;
            } else {
                socket.close();
                return getOfflineInfo();
            }
        } catch (UnknownHostException ex) {
            return getOfflineInfo();
        } catch (IOException ex) {
            return getOfflineInfo();
        }
    }

    private static ServerInfo getOfflineInfo() {
        return new ServerInfo() {

            @Override
            public boolean isOnline() {
                return false;
            }

            @Override
            public int getOnlinePlayers() {
                return 0;
            }

            @Override
            public String getMotd() {
                return "OFFLINE";
            }

            @Override
            public int getMaxPlayers() {
                return 0;
            }

            @Override
            public long getPing() {
                return 0;
            }
        };
    }

}
