package com.nobodyknows.asthachammaview.interfaces;

import java.util.ArrayList;

public interface AshtaChammaListener {
    public void onMyPlayerAliasSelected();
    public void onResetComplete();
    public void onPlayerWin(int playerNumber);
    public void onPlayerCut(int playerNumber,String playerAliasCode);
    public void onShellRoll(int playerNumber, ArrayList<Integer> values);
}
