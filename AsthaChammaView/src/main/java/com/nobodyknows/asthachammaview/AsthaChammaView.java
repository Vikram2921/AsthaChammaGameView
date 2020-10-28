package com.nobodyknows.asthachammaview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.android.flexbox.FlexboxLayout;
import com.nobodyknows.asthachammaview.interfaces.AshtaChammaListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AsthaChammaView extends LinearLayout {

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
    private LinearLayout root,board;
    private LayoutInflater layoutInflater;
    private AshtaChammaListener ashtaChammaListener;
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

    private void init(AttributeSet attrs, int defStyle) {
        layoutInflater= (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AsthaChammaView);
        try {

        } catch (Exception e){

        } finally {
            typedArray.recycle();
        }
        root = (LinearLayout) layoutInflater.inflate(R.layout.astha_chamme_view,this,true);
        board = root.findViewById(R.id.board);
        initBoxes();
        createAlias();
        resetView();
    }

    private void createAlias() {
        player1alias1 = getAlias(1,1);
        player1alias2 = getAlias(1,2);
        player1alias3 = getAlias(1,3);
        player1alias4 = getAlias(1,4);

        player2alias1 = getAlias(2,1);
        player2alias2 = getAlias(2,2);
        player2alias3 = getAlias(2,3);
        player2alias4 = getAlias(2,4);

        player3alias1 = getAlias(3,1);
        player3alias2 = getAlias(3,2);
        player3alias3 = getAlias(3,3);
        player3alias4 = getAlias(3,4);

        player4alias1 = getAlias(4,1);
        player4alias2 = getAlias(4,2);
        player4alias3 = getAlias(4,3);
        player4alias4 = getAlias(4,4);
    }

    private View getAlias(int playerNumber,int number) {
        View view =  layoutInflater.inflate(R.layout.playeraliasview,null);
        TextView textView = view.findViewById(R.id.aliasnumber);
        textView.setText(number+"");
        if(playerNumber == 1) {
            view.setBackgroundResource(R.drawable.alias1);
        } else if(playerNumber == 2) {
            view.setBackgroundResource(R.drawable.alias2);
        } else if(playerNumber == 3) {
            view.setBackgroundResource(R.drawable.alias3);
        } else if(playerNumber == 4) {
            view.setBackgroundResource(R.drawable.alias4);
        }
        return view;
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
        if(positionMap.get(playerAliasNumber).equals(homeID)) {
            if(move == 1) {
                pos = getPosition(playerNumber,move,homeID);
                removeParentAndAddIn(getAliasView(playerAliasNumber),getNextBox(pos),playerAliasNumber,pos,positionMap.get(playerAliasNumber),playerNumber);
            }
        } else {
            pos = getPosition(playerNumber,move,positionMap.get(playerAliasNumber));
            removeParentAndAddIn(getAliasView(playerAliasNumber),getNextBox(pos),playerAliasNumber,pos,positionMap.get(playerAliasNumber),playerNumber);
        }
    }

    private void removeParentAndAddIn(View view,FlexboxLayout flexboxLayout,String playerAliasNumber,String newPos,String oldPos,int playerNumber) {
        if(!moveWithAnimation) {
            ((ViewGroup)view.getParent()).removeView(view);
            flexboxLayout.addView(view);
            positionMap.put(playerAliasNumber,newPos);
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
