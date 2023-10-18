/*ass6:
Name: Adi Schiff
ID: 212730675
*/

import biuoop.DrawSurface;

/**
 * interface Animation.
 */
public interface Animation {
    /**
     * @param d the DrawSurface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * @return true when the animation should stop.
     */
    boolean shouldStop();
}
