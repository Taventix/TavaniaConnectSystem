package de.taventix.signsystem.managers;

public class ServerManager {

    private int port;
    private String hostname;
    private Template template;
    private Category category;
    private String servername;

    public ServerManager(Template template, String hostname, String servername, Category category, int port) {
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

    public Template getTemplate() {
        return template;
    }

    public Category getCategory() {
        return category;
    }

    public String getServername() {
        return servername;
    }
}
