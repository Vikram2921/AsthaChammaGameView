package com.nobodyknows.asthachammaview.interfaces;

public interface AshtaChammaListener {
    public void onMyPlayerAliasSelected();
    public void onResetComplete();
    public void onPlayerWin(int playerNumber);
    public void onPlayerCut(int playerNumber,String playerAliasCode);
}
