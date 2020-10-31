package com.nobodyknows.asthachammagameview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.nobodyknows.asthachammaview.AsthaChammaView;
import com.nobodyknows.asthachammaview.interfaces.AshtaChammaListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AshtaChammaListener {

    AsthaChammaView asthaChammaView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        asthaChammaView = findViewById(R.id.gameview);
        asthaChammaView.setAshtaChammaListener(this);
        asthaChammaView.updateBoard(1);
    }

    @Override
    public void onMyPlayerAliasSelected() {

    }

    @Override
    public void onResetComplete() {

    }

    @Override
    public void onPlayerWin(int playerNumber) {

    }

    @Override
    public void onPlayerCut(int playerNumber, String playerAliasCode) {

    }

    @Override
    public void onShellRoll(int playerNumber, ArrayList<Integer> values) {
        Toast.makeText(getApplicationContext(),"Shell Roll By Player "+playerNumber+" And Value : "+values,Toast.LENGTH_LONG).show();
    }
}