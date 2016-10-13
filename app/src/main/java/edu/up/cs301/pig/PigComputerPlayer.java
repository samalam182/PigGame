package edu.up.cs301.pig;

import android.util.Log;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {

        PigGameState p = (PigGameState)info;
        if(p.getCurPlayer() == playerNum){
            int randGuess = (int) (Math.random()*2);
            if (randGuess == 0){
                PigHoldAction hold = new PigHoldAction(this);
                game.sendAction(hold);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //Log.i("Computer Player", "Turn Over");
            }
            else if(randGuess == 1){
                PigRollAction roll = new PigRollAction(this);
                game.sendAction(roll);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        else return;
        // TODO  You will implement this method
    }//receiveInfo

}
