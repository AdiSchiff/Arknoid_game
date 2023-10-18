/*ass6:
Name: Adi Schiff
ID: 212730675
*/

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * Class of SpriteCollection.
 */
public class SpriteCollection {
    private ArrayList<Sprite> sprites;

    /**
     * set the value of a SpriteCollection.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<>();
    }

    /**
     * @param s new sprite to add to the sprites list.
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * @param s an existing sprite to remove from the sprites list.
     */
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spritesCopy = new ArrayList<>(sprites);
        for (Sprite sprite : spritesCopy) {
            sprite.timePassed();
        }
    }

    /**
     * Function: call drawOn(d) on all sprites.
     *
     * @param d the DrawSurface.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite sprite : sprites) {
            sprite.drawOn(d);
        }
    }
}