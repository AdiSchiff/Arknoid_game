/*ass6:
Name: Adi Schiff
ID: 212730675
*/

import biuoop.DrawSurface;

/**
 * present the status and the score at the end of the game.
 */
public class EndScreen implements Animation {
    private boolean flag;
    private int score;

    /**
     * @param flag  true if the player won and false if he lost.
     * @param score the current score we want to print.
     */
    public EndScreen(boolean flag, int score) {
        this.flag = flag;
        this.score = score;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (flag) {
            d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + this.score, 32);
        } else {
            d.drawText(10, d.getHeight() / 2, "Game Over. Your score is " + this.score, 32);
        }
    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}

