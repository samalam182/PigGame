package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by laum18 on 10/12/2016.
 */
public class PigGameState extends GameState{

    private int curPlayer;
    private int playerZeroScore;
    private int playerOneScore;
    private int curTotal;
    private int curVal;

    public PigGameState() {
        super();
        curPlayer = 0;
        playerZeroScore = 0;
        playerOneScore = 0;
        curTotal = 0;
        curVal = 0;
    }

    public PigGameState (PigGameState p) {
        super();
        curPlayer = p.getCurPlayer();
        playerZeroScore = p.getPlayerZeroScore();
        playerOneScore = p.getPlayerOneScore();
        curTotal = p.getCurTotal();
        curVal = p.getCurVal();
    }

    public int getCurPlayer(){
        return curPlayer;
    }

    public int getPlayerZeroScore() {
        return playerZeroScore;
    }

    public int getPlayerOneScore() {
        return playerOneScore;
    }

    public int getCurTotal() {
        return curTotal;
    }

    public int getCurVal() {
        return curVal;
    }

    public void setCurPlayer() {
        curPlayer = 1 - curPlayer;
    }

    public void setPlayerZeroScore(int s) {
        playerZeroScore = s;
    }

    public void setPlayerOneScore(int s) {
        playerOneScore = s;
    }

    public void setCurTotal(int t){
        curTotal = t;
    }

    public void setCurVal(int die) {
        curVal = die;
    }
}
