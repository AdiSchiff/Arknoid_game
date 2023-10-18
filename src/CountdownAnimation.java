/*ass6:
Name: Adi Schiff
ID: 212730675
*/

import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;


/**
 * The CountdownAnimation will display the given gameScreen,for numOfSeconds seconds,
 * and on top of them it will show a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) seconds, before it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private Sleeper sleeper;

    /**
     * @param numOfSeconds the countdown will appear on the screen.
     * @param countFrom    the number we start the countdown from.
     * @param gameScreen   the game's sprites.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.sleeper = new Sleeper();
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.PINK);
        d.drawText(400, 300, countFrom + "...", 30);
        this.sleeper.sleepFor((long) this.numOfSeconds * 1000 / 3);
        countFrom--;
    }

    @Override
    public boolean shouldStop() {
        return !(countFrom >= 0);
    }
}
