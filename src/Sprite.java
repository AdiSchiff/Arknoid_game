/*ass6:
Name: Adi Schiff
ID: 212730675
*/

import biuoop.DrawSurface;

/**
 * interface Sprite.
 */
public interface Sprite {

    /**
     * Function: draw the sprite to the screen.
     *
     * @param d a DrawSurface.
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}