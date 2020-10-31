package com.nobodyknows.asthachammaview.DTO;

public class Player {
    private String playerId;
    private Integer playerNumber = 1;
    private String playerProfileUrl;
    private int defaultProfile;
    private String playerName;

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public Integer getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(Integer playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getPlayerProfileUrl() {
        return playerProfileUrl;
    }

    public void setPlayerProfileUrl(String playerProfileUrl) {
        this.playerProfileUrl = playerProfileUrl;
    }

    public int getDefaultProfile() {
        return defaultProfile;
    }

    public void setDefaultProfile(int defaultProfile) {
        this.defaultProfile = defaultProfile;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
