/*ass6:
Name: Adi Schiff
ID: 212730675
*/

import biuoop.DrawSurface;

/**
 * function that pauses when the note p is pressed and continue when the spase is pressed.
 */
public class PauseScreen implements Animation {

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}
