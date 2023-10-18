/*ass6:
Name: Adi Schiff
ID: 212730675
*/

import biuoop.DrawSurface;

import java.awt.Color;


/**
 * ScoreIndicator is in charge of presenting the player's score during the game.
 */
public class ScoreIndicator implements Sprite {
    private Counter currentScore;

    /**
     * @param score the value of th current score.
     */
    public ScoreIndicator(Counter score) {
        this.currentScore = score;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(300, 14, "score:" + this.currentScore.getValue(), 15);
    }

    @Override
    public void timePassed() {

    }
}
