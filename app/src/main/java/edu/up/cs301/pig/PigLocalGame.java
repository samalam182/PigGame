package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import java.util.Random;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    PigGameState pig;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        //TODO  You will implement this constructor
        pig = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this method
        if (pig.getCurPlayer() == playerIdx) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method
        if (action instanceof PigHoldAction) {
            int player = pig.getCurPlayer();
            if (player == 0) {
                int tempScore = pig.getPlayerZeroScore();
                tempScore += pig.getCurTotal();
                pig.setPlayerZeroScore(tempScore);
                pig.setCurTotal(0);
                pig.setCurPlayer();
                return true;
            } else if (player == 1) {
                int tempScore = pig.getPlayerOneScore();
                tempScore += pig.getCurTotal();
                pig.setPlayerOneScore(tempScore);
                pig.setCurTotal(0);
                pig.setCurPlayer();
                return true;
            }
        } else if (action instanceof PigRollAction) {
            int rand = (int) (Math.random() * 6 + 1);
            Log.i("RandVal", ""+rand);
            if (rand != 1) {
                int tempTotal = pig.getCurTotal();
                pig.setCurVal(rand);
                tempTotal += rand;
                pig.setCurTotal(tempTotal);
            } else if (rand == 1) {
                pig.setCurVal(rand);
                pig.setCurTotal(0);
                pig.setCurPlayer();
            }
            return true;
        }

        return false;


    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        PigGameState temp = new PigGameState(pig);
        p.sendInfo(temp);

    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return a message that tells who has won the game, or null if the
     * game is not over
     */
    @Override
    protected String checkIfGameOver() {
        String winMessage;
        if (pig.getPlayerZeroScore() >= 50) {
            winMessage = "Player " + playerNames[pig.getCurPlayer()] + " has won with "
                    + pig.getPlayerZeroScore() + " points!";
            return winMessage;
        } else if (pig.getPlayerOneScore() >= 50) {
            winMessage = "Player " + playerNames[pig.getCurPlayer()] + " has won with "
                    + pig.getPlayerOneScore() + " points!";
            return winMessage;
        } else {
            //TODO  You will implement this method
            return null;

        }
    }
}// class PigLocalGame
