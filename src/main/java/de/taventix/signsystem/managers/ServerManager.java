package de.taventix.signsystem.managers;

import java.util.ArrayList;

public class ServerManager {

    private int port;
    private String hostname;
    private Template.Templates template;
    private Category category;
    private String servername;
    private ArrayList<ServerManager> runningServers = new ArrayList<ServerManager>();
    private ArrayList<ServerManager> lobbyServers = new ArrayList<ServerManager>();
    private ArrayList<Integer> usedPorts = new ArrayList<Integer>();
    private ArrayList<String> currentServernames = new ArrayList<String>();

    public ServerManager(Template.Templates template, String hostname, String servername, Category category, int port) {
        template = this.template;
        hostname = this.hostname;
        category = this.category;
        port = this.port;
        servername = this.servername;
    }

    public int getPort() {
        return port;
    }

    public String getHostname() {
        return hostname;
    }

    public Template.Templates getTemplate() {
        return template;
    }

    public Category getCategory() {
        return category;
    }

    public String getServername() {
        return servername;
    }

    public ArrayList<ServerManager> getRunningServers() {
        return runningServers;
    }

    public ArrayList<ServerManager> getLobbyServers() {
        return lobbyServers;
    }

    public ArrayList<Integer> getUsedPorts() {
        return usedPorts;
    }

    public ArrayList<String> getCurrentServernames() {
        return currentServernames;
    }
}
