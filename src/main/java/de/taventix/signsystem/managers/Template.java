package de.taventix.signsystem.managers;

public class Template {

    enum Templates {
        LOBBYSERVER,
        TEAMSERVER,
        BASICGAMESERVER,
        TOURNAMENTSERVER,
        SIMPLESERVER;
    }

    public Template(Templates template) {
        switch (template) {
            case TEAMSERVER:
                createTeamServer();
                break;
            case SIMPLESERVER:
                createSimpleServer();
                break;
            case BASICGAMESERVER:
                createBasicGameServer();
                break;
            case LOBBYSERVER:
                createLobbyServer();
                break;
            case TOURNAMENTSERVER:
                createTournamentServer();
                break;
            default:
                break;
        }
    }

    public void createLobbyServer() {

    }

    public void createTournamentServer() {

    }

    public void createTeamServer() {

    }

    public void createBasicGameServer() {

    }

    public void createSimpleServer() {

    }

}
