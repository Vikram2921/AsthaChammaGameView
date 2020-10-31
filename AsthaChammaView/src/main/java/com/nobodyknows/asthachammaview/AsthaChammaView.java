package com.nobodyknows.asthachammaview;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import com.google.android.flexbox.FlexboxLayout;
import com.nobodyknows.asthachammaview.DTO.Player;
import com.nobodyknows.asthachammaview.interfaces.AshtaChammaListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AsthaChammaView extends LinearLayout {

    private Player player1,player2,player3,player4;
    private CardView cardView;
    private static final String PLAYER1ALIAS1 = "player1alias1";
    private static final String PLAYER1ALIAS2 = "player1alias2";
    private static final String PLAYER1ALIAS3 = "player1alias3";
    private static final String PLAYER1ALIAS4 = "player1alias4";
    private static final String PLAYER2ALIAS1 = "player2alias1";
    private static final String PLAYER2ALIAS2 = "player2alias2";
    private static final String PLAYER2ALIAS3 = "player2alias3";
    private static final String PLAYER2ALIAS4 = "player2alias4";
    private static final String PLAYER3ALIAS1 = "player3alias1";
    private static final String PLAYER3ALIAS2 = "player3alias2";
    private static final String PLAYER3ALIAS3 = "player3alias3";
    private static final String PLAYER3ALIAS4 = "player3alias4";
    private static final String PLAYER4ALIAS1 = "player4alias1";
    private static final String PLAYER4ALIAS2 = "player4alias2";
    private static final String PLAYER4ALIAS3 = "player4alias3";
    private static final String PLAYER4ALIAS4 = "player4alias4";
    private Context context;
    private LinearLayout root,selectView;
    private ArrayList<Integer> rollDiceCache = new ArrayList<>();
    private RelativeLayout board,myPlayerInfo;
    private int player1AliasColor = getResources().getColor(R.color.alias1);
    private int player2AliasColor = getResources().getColor(R.color.alias2);
    private int player3AliasColor = getResources().getColor(R.color.alias3);
    private int player4AliasColor = getResources().getColor(R.color.alias4);
    private LayoutInflater layoutInflater;
    private AshtaChammaListener ashtaChammaListener;
    private ArrayList<String> blackorwhite = new ArrayList<>(Arrays.asList("B","F"));
    private FlexboxLayout box11,box12,box13,box14,box15;
    private FlexboxLayout box21,box22,box23,box24,box25;
    private FlexboxLayout box31,box32,box33,box34,box35;
    private FlexboxLayout box41,box42,box43,box44,box45;
    private FlexboxLayout box51,box52,box53,box54,box55;
    private ArrayList<String> player1moves = new ArrayList<>(Arrays.asList("1_3","1_4","1_5","2_5","3_5","4_5","5_5","5_4","5_3","5_2","5_1","4_1","3_1","2_1","1_1","1_2","2_2","3_2","4_2","4_3","4_4","3_4","2_4","2_3","3_3"));
    private ArrayList<String> player2moves = new ArrayList<>(Arrays.asList("3_5","4_5","5_5","5_4","5_3","5_2","5_1","4_1","3_1","2_1","1_1","1_2","1_3","1_4","1_5","2_5","2_4","2_3","2_2","3_2","4_2","4_3","4_4","3_4","3_3"));
    private ArrayList<String> player3moves = new ArrayList<>(Arrays.asList("5_3","5_2","5_1","4_1","3_1","2_1","1_1","1_2","1_3","1_4","1_5","2_5","3_5","4_5","5_5","5_4","4_4","3_4","2_4","2_3","2_2","3_2","4_2","4_3","3_3"));
    private ArrayList<String> player4moves = new ArrayList<>(Arrays.asList("3_1","2_1","1_1","1_2","1_3","1_4","1_5","2_5","3_5","4_5","5_5","5_4","5_3","5_2","5_1","4_1","4_2","4_3","4_4","3_4","2_4","2_3","2_2","3_2","3_3"));
    private Map<String,String> positionMap = new HashMap<>();
    private View player1alias1,player1alias2,player1alias3,player1alias4;
    private View player2alias1,player2alias2,player2alias3,player2alias4;
    private View player3alias1,player3alias2,player3alias3,player3alias4;
    private View player4alias1,player4alias2,player4alias3,player4alias4;
    private Boolean moveWithAnimation = false;
    private RelativeLayout player1info,player2info,player3info,player4info;
    private ImageView player1shell1,player1shell2,player1shell3,player1shell4;
    private ImageView player2shell1,player2shell2,player2shell3,player2shell4;
    private ImageView player3shell1,player3shell2,player3shell3,player3shell4;
    private ImageView player4shell1,player4shell2,player4shell3,player4shell4;
    private int myPlayerNumber = 1;

    public AshtaChammaListener getAshtaChammaListener() {
        return ashtaChammaListener;
    }

    private FlexboxLayout getPlayer1Box() {
        return box13;
    }

    private FlexboxLayout getPlayer2Box() {
        return box35;
    }

    private FlexboxLayout getPlayer3Box() {
        return box53;
    }

    private FlexboxLayout getPlayer4Box() {
        return box31;
    }

    public Boolean getMoveWithAnimation() {
        return moveWithAnimation;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer3() {
        return player3;
    }

    public void setPlayer3(Player player3) {
        this.player3 = player3;
    }

    public Player getPlayer4() {
        return player4;
    }

    public void setPlayer4(Player player4) {
        this.player4 = player4;
    }

    public int getMyPlayerNumber() {
        return myPlayerNumber;
    }

    public void setMyPlayerNumber(int myPlayerNumber) {
        disableAndEnableAliasForPlayer(1,false);
        disableAndEnableAliasForPlayer(2,false);
        disableAndEnableAliasForPlayer(3,false);
        disableAndEnableAliasForPlayer(4,false);
        this.myPlayerNumber = myPlayerNumber;
        rollDiceCache.clear();
        if(myPlayerNumber == 1) {
            myPlayerInfo = player1info;
            player1info.setEnabled(true);
            player2info.setEnabled(false);
            player3info.setEnabled(false);
            player4info.setEnabled(false);
        } else if(myPlayerNumber == 2) {
            myPlayerInfo = player2info;
            player1info.setEnabled(false);
            player2info.setEnabled(true);
            player3info.setEnabled(false);
            player4info.setEnabled(false);
        }  else if(myPlayerNumber == 3) {
            myPlayerInfo = player3info;
            player1info.setEnabled(false);
            player2info.setEnabled(false);
            player3info.setEnabled(true);
            player4info.setEnabled(false);
        }  else if(myPlayerNumber == 4) {
            myPlayerInfo = player4info;
            player1info.setEnabled(false);
            player2info.setEnabled(false);
            player3info.setEnabled(false);
            player4info.setEnabled(true);
        }
    }

    public void updateCurrentPlayerTurn(int playerNumber) {
        rollDiceCache.clear();
        if(playerNumber == myPlayerNumber) {
            myPlayerInfo.setEnabled(true);
            disableAndEnableAliasForPlayer(myPlayerNumber,true);
        } else {
            myPlayerInfo.setEnabled(false);
        }
    }

    private void setMoveWithAnimation(Boolean moveWithAnimation) {
        this.moveWithAnimation = moveWithAnimation;
    }

    public void setAshtaChammaListener(AshtaChammaListener ashtaChammaListener) {
        this.ashtaChammaListener = ashtaChammaListener;
    }

    public AsthaChammaView(Context context) {
        super(context);
        this.context = context;
        init(null,0);
    }

    public AsthaChammaView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(attrs,defStyleAttr);
    }

    public AsthaChammaView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(attrs,0);
    }

    private ArrayList<String> getAllPlayerAliasesInPos(String pos) {
        ArrayList<String> positionAliasList = new ArrayList<>();
        for(int i=1;i<=4;i++) {
            for(int j=1;j<=4;j++) {
                if(positionMap.get("player"+i+"alias"+j).equals(pos)){
                    positionAliasList.add("player"+i+"alias"+j);
                }
            }
        }
        return positionAliasList;
    }

    private Boolean checkForWinner(ArrayList<String> positionList, List<String> aliasList) {
        Boolean isWinner = true;
        for(String alias:aliasList) {
            if(positionList.contains(alias)) {
                isWinner = true;
            } else {
                isWinner = false;
                break;
            }
        }
        return isWinner;
    }

    private List<String> getPlayerAliasListByPlayerNumber(int playerNumber) {
        if(playerNumber == 1) {
            return Arrays.asList(PLAYER1ALIAS1,PLAYER1ALIAS2,PLAYER1ALIAS3,PLAYER1ALIAS4);
        } else if(playerNumber == 2) {
            return Arrays.asList(PLAYER2ALIAS1,PLAYER2ALIAS2,PLAYER2ALIAS3,PLAYER2ALIAS4);
        } else if(playerNumber == 3) {
            return Arrays.asList(PLAYER3ALIAS1,PLAYER3ALIAS2,PLAYER3ALIAS3,PLAYER3ALIAS4);
        } else {
            return Arrays.asList(PLAYER4ALIAS1,PLAYER4ALIAS2,PLAYER4ALIAS3,PLAYER4ALIAS4);
        }
    }

    private void checkForResult(String newPos, int playerNumber, String playerAliasNumber) {
        if(newPos.equals("3_3")) {
            Boolean isWinner = false;
            if(playerNumber == 1) {
                isWinner = checkForWinner(getAllPlayerAliasesInPos("3_3"),getPlayerAliasListByPlayerNumber(playerNumber));
            } else if(playerNumber == 2) {
                isWinner = checkForWinner(getAllPlayerAliasesInPos("3_3"),getPlayerAliasListByPlayerNumber(playerNumber));
            }  else if(playerNumber == 3) {
                isWinner = checkForWinner(getAllPlayerAliasesInPos("3_3"),getPlayerAliasListByPlayerNumber(playerNumber));
            }  else if(playerNumber == 4) {
                isWinner = checkForWinner(getAllPlayerAliasesInPos("3_3"),getPlayerAliasListByPlayerNumber(playerNumber));
            }
            if(isWinner) {
                ashtaChammaListener.onPlayerWin(playerNumber);
            }
        } else {
            if(!newPos.equals("1_3") && !newPos.equals("5_3") && !newPos.equals("3_5") && !newPos.equals("3_1")) {
                ArrayList<String> positionAlias = getAllPlayerAliasesInPos(newPos);
                if(positionAlias.size() == 1) {
                    List<String> myAlias = getPlayerAliasListByPlayerNumber(playerNumber);
                    if(!myAlias.contains(positionAlias.get(0))) {
                        String opPlayerALias = positionAlias.get(0);
                        if(playerNumber == 1) {
                            if(getPlayerAliasListByPlayerNumber(2).contains(opPlayerALias)) {
                                cutAndUpdate(opPlayerALias,2,newPos);
                            } else if(getPlayerAliasListByPlayerNumber(3).contains(opPlayerALias)) {
                                cutAndUpdate(opPlayerALias,3,newPos);
                            }  else if(getPlayerAliasListByPlayerNumber(4).contains(opPlayerALias)) {
                                cutAndUpdate(opPlayerALias,4,newPos);
                            }
                        } else if(playerNumber == 2) {
                            if(getPlayerAliasListByPlayerNumber(1).contains(opPlayerALias)) {
                                cutAndUpdate(opPlayerALias,1,newPos);
                            } else if(getPlayerAliasListByPlayerNumber(3).contains(opPlayerALias)) {
                                cutAndUpdate(opPlayerALias,3,newPos);
                            }  else if(getPlayerAliasListByPlayerNumber(4).contains(opPlayerALias)) {
                                cutAndUpdate(opPlayerALias,4,newPos);
                            }
                        } else if(playerNumber == 3) {
                            if(getPlayerAliasListByPlayerNumber(1).contains(opPlayerALias)) {
                                cutAndUpdate(opPlayerALias,1,newPos);
                            } else if(getPlayerAliasListByPlayerNumber(2).contains(opPlayerALias)) {
                                cutAndUpdate(opPlayerALias,2,newPos);
                            }  else if(getPlayerAliasListByPlayerNumber(4).contains(opPlayerALias)) {
                                cutAndUpdate(opPlayerALias,4,newPos);
                            }
                        } else if(playerNumber == 4) {
                            if(getPlayerAliasListByPlayerNumber(1).contains(opPlayerALias)) {
                                cutAndUpdate(opPlayerALias,1,newPos);
                            } else if(getPlayerAliasListByPlayerNumber(3).contains(opPlayerALias)) {
                                cutAndUpdate(opPlayerALias,3,newPos);
                            }  else if(getPlayerAliasListByPlayerNumber(2).contains(opPlayerALias)) {
                                cutAndUpdate(opPlayerALias,2,newPos);
                            }
                        }
                    }
                }
            }
        }
    }

    private void cutAndUpdate(String opPlayerALias,int playerNumber,String oldPos) {
        if(playerNumber == 1) {
            removeParentAndAddIn(getAliasView(opPlayerALias),getNextBox("1_3"),opPlayerALias,"1_3",oldPos,playerNumber,false);
        } else if(playerNumber == 2) {
            removeParentAndAddIn(getAliasView(opPlayerALias),getNextBox("3_5"),opPlayerALias,"3_5",oldPos,playerNumber,false);
        } else if(playerNumber == 3) {
            removeParentAndAddIn(getAliasView(opPlayerALias),getNextBox("5_3"),opPlayerALias,"5_3",oldPos,playerNumber,false);
        } else {
            removeParentAndAddIn(getAliasView(opPlayerALias),getNextBox("3_1"),opPlayerALias,"3_1",oldPos,playerNumber,false);
        }
    }

    private void init(AttributeSet attrs, int defStyle) {
        layoutInflater= (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AsthaChammaView);
        try {

        } catch (Exception e){

        } finally {
            typedArray.recycle();
        }
        root = (LinearLayout) layoutInflater.inflate(R.layout.astha_chamme_view,this,true);
        selectView = root.findViewById(R.id.selectView);
        cardView = root.findViewById(R.id.cardview);
        board = root.findViewById(R.id.board);
        initBoxes();
        initInfos();
        createAlias();
        resetView();
        setMyPlayerNumber(1);
    }

    private void initInfos() {
        player1info = root.findViewById(R.id.player1info);
        player2info = root.findViewById(R.id.player2info);
        player3info = root.findViewById(R.id.player3info);
        player4info = root.findViewById(R.id.player4info);

        player1shell1 = root.findViewById(R.id.player1shell1);
        player1shell2 = root.findViewById(R.id.player1shell2);
        player1shell3 = root.findViewById(R.id.player1shell3);
        player1shell4 = root.findViewById(R.id.player1shell4);

        player2shell1 = root.findViewById(R.id.player2shell1);
        player2shell2 = root.findViewById(R.id.player2shell2);
        player2shell3 = root.findViewById(R.id.player2shell3);
        player2shell4 = root.findViewById(R.id.player2shell4);

        player3shell1 = root.findViewById(R.id.player3shell1);
        player3shell2 = root.findViewById(R.id.player3shell2);
        player3shell3 = root.findViewById(R.id.player3shell3);
        player3shell4 = root.findViewById(R.id.player3shell4);

        player4shell1 = root.findViewById(R.id.player4shell1);
        player4shell2 = root.findViewById(R.id.player4shell2);
        player4shell3 = root.findViewById(R.id.player4shell3);
        player4shell4 = root.findViewById(R.id.player4shell4);

        player1info.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(1,player1shell1,player1shell2,player1shell3,player1shell4);
            }
        });
        player2info.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(2,player2shell1,player2shell2,player2shell3,player2shell4);
            }
        });
        player3info.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(3,player3shell1,player3shell2,player3shell3,player3shell4);
            }
        });
        player4info.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(4,player4shell1,player4shell2,player4shell3,player4shell4);
            }
        });

    }

    private void rollDice(int playerNumber,ImageView shell1,ImageView shell2,ImageView shell3,ImageView shell4) {
        String dice1 = randomCode();
        String dice2 = randomCode();
        String dice3 = randomCode();
        String dice4 = randomCode();
        updateDiceImage(shell1,dice1);
        updateDiceImage(shell2,dice2);
        updateDiceImage(shell3,dice3);
        updateDiceImage(shell4,dice4);
        int codeValue = getCodeValue(dice1,dice2,dice3,dice4);
        rollDiceCache.add(codeValue);
        if(codeValue != 4 && codeValue != 8) {
            List<String> myAliases = getPlayerAliasListByPlayerNumber(playerNumber);
            if(!rollDiceCache.contains(1)) {

            } else {
                ashtaChammaListener.onShellRoll(playerNumber,rollDiceCache);
                disableAndEnableAliasForPlayer(playerNumber,true);
                if(playerNumber == 1) {
                    player1info.setEnabled(false);
                } else if(playerNumber == 2) {
                    player2info.setEnabled(false);
                }  else if(playerNumber == 3) {
                    player3info.setEnabled(false);
                }  else if(playerNumber == 4) {
                    player4info.setEnabled(false);
                }
            }
        } else {
            if(rollDiceCache.size()>=3) {
                if(rollDiceCache.get(rollDiceCache.size()-3) == 4 && rollDiceCache.get(rollDiceCache.size()-2) == 4 && rollDiceCache.get(rollDiceCache.size()-1) == 4) {
                    rollDiceCache.clear();
                    ashtaChammaListener.onShellRoll(playerNumber,rollDiceCache);
                }
                if(rollDiceCache.get(rollDiceCache.size()-3) == 8 && rollDiceCache.get(rollDiceCache.size()-2) == 8 && rollDiceCache.get(rollDiceCache.size()-1) == 8) {
                    rollDiceCache.clear();
                    ashtaChammaListener.onShellRoll(playerNumber,rollDiceCache);
                }
            }
        }
    }

    private int getCodeValue(String code1,String code2,String code3,String code4) {
        int code = 0;
        if(code1.equals("B") && code2.equals("B") && code3.equals("B") && code4.equals("B")) {
            code = 8;
        } else {
            if(code1.equals("F")) {
                code++;
            }
            if(code2.equals("F")) {
                code++;
            }
            if(code3.equals("F")) {
                code++;
            }
            if(code4.equals("F")) {
                code++;
            }
        }
        return code;
    }

    private String randomCode() {
        Random random = new Random();
        return  blackorwhite.get(random.nextInt(2));
    }

    private void updateDiceImage(ImageView imageView,String code) {
        if(code.equals("F")) {
            setImage(R.drawable.front_shell,imageView);
        } else {
            setImage(R.drawable.back_shell,imageView);
        }
    }

    private void setImage(int image, ImageView imageView) {
        setImageDrawableWithAnimation(imageView, ContextCompat.getDrawable(getContext(), image));
    }
    public void setImageDrawableWithAnimation(ImageView imageView, Drawable drawable) {
        ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(getContext(), R.animator.fliping);
        anim.setTarget(imageView);
        anim.setDuration(300);
        anim.start();
        imageView.setImageDrawable(drawable);
    }

    private void createAlias() {
        player1alias1 = getAlias(1,1,PLAYER1ALIAS1);
        player1alias2 = getAlias(1,2,PLAYER1ALIAS2);
        player1alias3 = getAlias(1,3,PLAYER1ALIAS3);
        player1alias4 = getAlias(1,4,PLAYER1ALIAS4);

        player2alias1 = getAlias(2,1,PLAYER2ALIAS1);
        player2alias2 = getAlias(2,2,PLAYER2ALIAS2);
        player2alias3 = getAlias(2,3,PLAYER2ALIAS3);
        player2alias4 = getAlias(2,4,PLAYER2ALIAS4);

        player3alias1 = getAlias(3,1,PLAYER3ALIAS1);
        player3alias2 = getAlias(3,2,PLAYER3ALIAS2);
        player3alias3 = getAlias(3,3,PLAYER3ALIAS3);
        player3alias4 = getAlias(3,4,PLAYER3ALIAS4);

        player4alias1 = getAlias(4,1,PLAYER4ALIAS1);
        player4alias2 = getAlias(4,2,PLAYER4ALIAS2);
        player4alias3 = getAlias(4,3,PLAYER4ALIAS3);
        player4alias4 = getAlias(4,4,PLAYER4ALIAS4);
    }

    private void disableAndEnableAliasForPlayer(int playerNumber,Boolean value) {
        if(playerNumber == 1) {
            player1alias1.setEnabled(value);
            player1alias2.setEnabled(value);
            player1alias3.setEnabled(value);
            player1alias4.setEnabled(value);
        } else if(playerNumber == 2) {
            player2alias1.setEnabled(value);
            player2alias2.setEnabled(value);
            player2alias3.setEnabled(value);
            player2alias4.setEnabled(value);
        }  else if(playerNumber == 3) {
            player3alias1.setEnabled(value);
            player3alias2.setEnabled(value);
            player3alias3.setEnabled(value);
            player3alias4.setEnabled(value);
        } else if(playerNumber == 4) {
            player4alias1.setEnabled(value);
            player4alias2.setEnabled(value);
            player4alias3.setEnabled(value);
            player4alias4.setEnabled(value);
        }
    }

    private View getAlias(int playerNumber,int aliasNumber,String aliasName) {
        View view =  layoutInflater.inflate(R.layout.playeraliasview,null);
        ImageView imageView = view.findViewById(R.id.aliasImage);
        if(playerNumber == 1) {
            imageView.setImageResource(R.drawable.alias_blue);
        } else if(playerNumber == 2) {
            imageView.setImageResource(R.drawable.alias_green);
        } else if(playerNumber == 3) {
            imageView.setImageResource(R.drawable.alias_yellow);
        } else if(playerNumber == 4) {
            imageView.setImageResource(R.drawable.alias_red);
        }
        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"sadasd",Toast.LENGTH_SHORT).show();
                if(rollDiceCache.size() > 0) {
                    showSelectView(view,playerNumber,aliasNumber,aliasName);
                } else {
                    cardView.setVisibility(GONE);
                }
            }
        });
        return view;
    }

    private void showSelectView(View alias, int playerNumber, int aliasNumber, String aliasName) {
        cardView.setVisibility(VISIBLE);
        selectView.removeAllViews();
        for(Integer integer:rollDiceCache) {
            View view = layoutInflater.inflate(R.layout.selectbuttonview,null);
            Button button = view.findViewById(R.id.button);
            button.setText(integer+"");
            button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            selectView.addView(view);
        }
    }

    private void initBoxes() {
        box11 = root.findViewById(R.id.box11);
        box12 = root.findViewById(R.id.box12);
        box13 = root.findViewById(R.id.box13);
        box14 = root.findViewById(R.id.box14);
        box15 = root.findViewById(R.id.box15);
        box21 = root.findViewById(R.id.box21);
        box22 = root.findViewById(R.id.box22);
        box23 = root.findViewById(R.id.box23);
        box24 = root.findViewById(R.id.box24);
        box25 = root.findViewById(R.id.box25);
        box31 = root.findViewById(R.id.box31);
        box32 = root.findViewById(R.id.box32);
        box33 = root.findViewById(R.id.box33);
        box34 = root.findViewById(R.id.box34);
        box35 = root.findViewById(R.id.box35);
        box41 = root.findViewById(R.id.box41);
        box42 = root.findViewById(R.id.box42);
        box43 = root.findViewById(R.id.box43);
        box44 = root.findViewById(R.id.box44);
        box45 = root.findViewById(R.id.box45);
        box51 = root.findViewById(R.id.box51);
        box52 = root.findViewById(R.id.box52);
        box53 = root.findViewById(R.id.box53);
        box54 = root.findViewById(R.id.box54);
        box55 = root.findViewById(R.id.box55);
    }

    private void generatePositionMap() {
        positionMap = new HashMap<>();
        positionMap.put(PLAYER1ALIAS1,"1_3");
        positionMap.put(PLAYER1ALIAS2,"1_3");
        positionMap.put(PLAYER1ALIAS3,"1_3");
        positionMap.put(PLAYER1ALIAS4,"1_3");
        
        positionMap.put(PLAYER2ALIAS1,"3_5");
        positionMap.put(PLAYER2ALIAS2,"3_5");
        positionMap.put(PLAYER2ALIAS3,"3_5");
        positionMap.put(PLAYER2ALIAS4,"3_5");

        positionMap.put(PLAYER3ALIAS1,"5_3");
        positionMap.put(PLAYER3ALIAS2,"5_3");
        positionMap.put(PLAYER3ALIAS3,"5_3");
        positionMap.put(PLAYER3ALIAS4,"5_3");

        positionMap.put(PLAYER4ALIAS1,"3_1");
        positionMap.put(PLAYER4ALIAS2,"3_1");
        positionMap.put(PLAYER4ALIAS3,"3_1");
        positionMap.put(PLAYER4ALIAS4,"3_1");
    }

    private View getAliasView(String playerAliasNumber) {
        if(playerAliasNumber.equals(PLAYER1ALIAS1)) {
            return player1alias1;
        } else if(playerAliasNumber.equals(PLAYER1ALIAS2)) {
            return player1alias2;
        } else if(playerAliasNumber.equals(PLAYER1ALIAS3)) {
            return player1alias3;
        } else if(playerAliasNumber.equals(PLAYER1ALIAS4)) {
            return player1alias4;
        } else if(playerAliasNumber.equals(PLAYER2ALIAS1)) {
            return player2alias1;
        } else if(playerAliasNumber.equals(PLAYER2ALIAS2)) {
            return player2alias2;
        } else if(playerAliasNumber.equals(PLAYER2ALIAS3)) {
            return player2alias3;
        } else if(playerAliasNumber.equals(PLAYER2ALIAS4)) {
            return player2alias4;
        } else if(playerAliasNumber.equals(PLAYER3ALIAS1)) {
            return player3alias1;
        } else if(playerAliasNumber.equals(PLAYER3ALIAS2)) {
            return player3alias2;
        } else if(playerAliasNumber.equals(PLAYER3ALIAS3)) {
            return player3alias3;
        } else if(playerAliasNumber.equals(PLAYER3ALIAS4)) {
            return player3alias4;
        } else if(playerAliasNumber.equals(PLAYER4ALIAS1)) {
            return player4alias1;
        } else if(playerAliasNumber.equals(PLAYER4ALIAS2)) {
            return player4alias2;
        } else if(playerAliasNumber.equals(PLAYER4ALIAS3)) {
            return player4alias3;
        } else if(playerAliasNumber.equals(PLAYER4ALIAS4)) {
            return player4alias4;
        }
        return null;
    }

    private FlexboxLayout getFlexBoxByXY(int x,int y) {
        if(x == 1) {
            if(y == 1) {
                return box11;
            } else if(y == 2) {
                return box12;
            } else if(y == 3) {
                return box13;
            } else if(y == 4) {
                return box14;
            } else {
                return box15;
            }
        } else if(x == 2) {
            if(y == 1) {
                return box21;
            } else if(y == 2) {
                return box22;
            } else if(y == 3) {
                return box23;
            } else if(y == 4) {
                return box24;
            } else {
                return box25;
            }
        } else if(x == 3) {
            if(y == 1) {
                return box31;
            } else if(y == 2) {
                return box32;
            } else if(y == 3) {
                return box33;
            } else if(y == 4) {
                return box34;
            } else {
                return box35;
            }
        } else if(x == 4) {
            if(y == 1) {
                return box41;
            } else if(y == 2) {
                return box42;
            } else if(y == 3) {
                return box43;
            } else if(y == 4) {
                return box44;
            } else {
                return box45;
            }
        } else  {
            if(y == 1) {
                return box51;
            } else if(y == 2) {
                return box52;
            } else if(y == 3) {
                return box53;
            } else if(y == 4) {
                return box54;
            } else {
                return box55;
            }
        }
    }

    private FlexboxLayout getNextBox(String pos) {
        String[] splits = pos.split("_");
        return getFlexBoxByXY(Integer.parseInt(splits[0]),Integer.parseInt(splits[1]));
    }

    private ArrayList<String> getPlayerMovesList(int playerNumber) {
        if(playerNumber == 1) {
            return player1moves;
        } else if(playerNumber == 2) {
            return  player2moves;
        }  else if(playerNumber == 3) {
            return player3moves;
        }  else {
            return player4moves;
        }
    }

    private String getPosition(Integer playerNumber,int move,String currentPosition) {
        ArrayList<String> moves = getPlayerMovesList(playerNumber);
        Integer index = moves.indexOf(currentPosition);
        index += move;
        if(index < moves.size()) {
            return moves.get(index);
        }
        return currentPosition;
    }

    private void move(String playerAliasNumber,String homeID,int move,int playerNumber) {
        String pos = "";
        String currentPos=positionMap.get(playerAliasNumber);
        if(!currentPos.equals("3_3")) {
            if(currentPos.equals(homeID)) {
                if(move == 1) {
                    pos = getPosition(playerNumber,move,homeID);
                    removeParentAndAddIn(getAliasView(playerAliasNumber),getNextBox(pos),playerAliasNumber,pos,currentPos,playerNumber,true);
                }
            } else {
                pos = getPosition(playerNumber,move,currentPos);
                removeParentAndAddIn(getAliasView(playerAliasNumber),getNextBox(pos),playerAliasNumber,pos,currentPos,playerNumber,true);
            }
        }
    }

    private void removeParentAndAddIn(View view,FlexboxLayout flexboxLayout,String playerAliasNumber,String newPos,String oldPos,int playerNumber,Boolean checkResult) {
        if(!moveWithAnimation) {
            ((ViewGroup)view.getParent()).removeView(view);
            flexboxLayout.addView(view);
        } else {
//            Animation animation;
//            ArrayList<String> moves = getPlayerMovesList(playerNumber);
//            Integer oldindex = moves.indexOf(oldPos);
//            Integer newindex = moves.indexOf(oldPos);
//            for(int i=oldindex;i<=newindex;i++) {
//                ((ViewGroup)view.getParent()).removeView(view);
//                getNextBox(moves.get(i)).addView(view);
//                animation = AnimationUtils.loadAnimation(context, R.anim.slide_up);
//                view.startAnimation(animation);
//            }
//            positionMap.put(playerAliasNumber,newPos);
        }
        if(checkResult) {
            checkForResult(newPos,playerNumber,playerAliasNumber);
        } else {
            ashtaChammaListener.onPlayerCut(playerNumber,playerAliasNumber);
        }
        positionMap.put(playerAliasNumber,newPos);
    }

    public void movePlayer1(int playerAliasNumber,int diceValue) {
        if(playerAliasNumber == 1) {
            move(PLAYER1ALIAS1,"1_3",diceValue,1);
        } else if(playerAliasNumber == 2) {
            move(PLAYER1ALIAS2,"1_3",diceValue,1);
        } else if(playerAliasNumber == 3) {
            move(PLAYER1ALIAS3,"1_3",diceValue,1);
        } else if(playerAliasNumber == 4) {
            move(PLAYER1ALIAS4,"1_3",diceValue,1);
        }
    }

    public void movePlayer2(int playerAliasNumber,int diceValue) {
        if(playerAliasNumber == 1) {
            move(PLAYER2ALIAS1,"3_5",diceValue,2);
        } else if(playerAliasNumber == 2) {
            move(PLAYER2ALIAS2,"3_5",diceValue,2);
        } else if(playerAliasNumber == 3) {
            move(PLAYER2ALIAS3,"3_5",diceValue,2);
        } else if(playerAliasNumber == 4) {
            move(PLAYER2ALIAS4,"3_5",diceValue,2);
        }
    }

    public void movePlayer3(int playerAliasNumber,int diceValue) {
        if(playerAliasNumber == 1) {
            move(PLAYER3ALIAS1,"5_3",diceValue,3);
        } else if(playerAliasNumber == 2) {
            move(PLAYER3ALIAS2,"5_3",diceValue,3);
        } else if(playerAliasNumber == 3) {
            move(PLAYER3ALIAS3,"5_3",diceValue,3);
        } else if(playerAliasNumber == 4) {
            move(PLAYER3ALIAS4,"5_3",diceValue,3);
        }
    }

    public void movePlayer4(int playerAliasNumber,int diceValue) {
        if(playerAliasNumber == 1) {
            move(PLAYER4ALIAS1,"3_1",diceValue,4);
        } else if(playerAliasNumber == 2) {
            move(PLAYER4ALIAS2,"3_1",diceValue,4);
        } else if(playerAliasNumber == 3) {
            move(PLAYER4ALIAS3,"3_1",diceValue,4);
        } else if(playerAliasNumber == 4) {
            move(PLAYER4ALIAS4,"3_1",diceValue,4);
        }
    }

    public void resetView() {
        generatePositionMap();
        resetPlayerAliasPositons();
    }

    private void resetPlayerAliasPositons() {
        getPlayer1Box().addView(player1alias1);
        getPlayer1Box().addView(player1alias2);
        getPlayer1Box().addView(player1alias3);
        getPlayer1Box().addView(player1alias4);

        getPlayer2Box().addView(player2alias1);
        getPlayer2Box().addView(player2alias2);
        getPlayer2Box().addView(player2alias3);
        getPlayer2Box().addView(player2alias4);

        getPlayer3Box().addView(player3alias1);
        getPlayer3Box().addView(player3alias2);
        getPlayer3Box().addView(player3alias3);
        getPlayer3Box().addView(player3alias4);

        getPlayer4Box().addView(player4alias1);
        getPlayer4Box().addView(player4alias2);
        getPlayer4Box().addView(player4alias3);
        getPlayer4Box().addView(player4alias4);


    }

    public void updateBoard(int myPlayerNumber) {
        if(myPlayerNumber == 1) {
            rotateView(180);
        } else if(myPlayerNumber == 2) {
            rotateView(90);
        }  else if(myPlayerNumber == 3) {
            rotateView(0);
        }  else if(myPlayerNumber == 4) {
            rotateView(270);
        }
    }

    private void rotateView(int rotation) {
        board.setRotation(rotation);
    }
}
