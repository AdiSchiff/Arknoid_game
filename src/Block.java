/*ass6:
Name: Adi Schiff
ID: 212730675
*/

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Block.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle shape;
    private java.awt.Color color;
    private ArrayList<HitListener> hitListenerList;
    static final double EPSILON = 1E-6;


    /**
     * Function: set the values of a block.
     *
     * @param rect  the block's shape.
     * @param color the block's color.
     */
    public Block(Rectangle rect, java.awt.Color color) {
        this.shape = rect;
        this.color = color;
    }

    /**
     * @return the block's color.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * @param surface that the block will be drawn on
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) this.shape.getUpperLeft().getX(), (int) this.shape.getUpperLeft().getY(),
                (int) this.shape.getWidth(), (int) this.shape.getHeight());
        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) this.shape.getUpperLeft().getX(), (int) this.shape.getUpperLeft().getY(),
                (int) this.shape.getWidth(), (int) this.shape.getHeight());
    }

    /**
     * null.
     */
    @Override
    public void timePassed() {

    }

    /**
     * @return the block's shape
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.shape;
    }

    /**
     * @param collisionPoint  with the block.
     * @param currentVelocity of the ball.
     * @return a new velocity for the ball.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        if (Math.abs(collisionPoint.getX() - shape.getUpperLeft().getX()) < EPSILON
                || Math.abs(collisionPoint.getX() - (shape.getUpperLeft().getX() + shape.getWidth())) < EPSILON) {
            currentVelocity.setDx(currentVelocity.getDx() * (-1));
        }
        if (Math.abs(collisionPoint.getY() - shape.getUpperLeft().getY()) < EPSILON
                || Math.abs(collisionPoint.getY() - (shape.getUpperLeft().getY() + shape.getHeight())) < EPSILON) {
            currentVelocity.setDy(currentVelocity.getDy() * (-1));
        }
        this.notifyHit(hitter);
        return currentVelocity;
    }

    /**
     * Add the block to the game.
     *
     * @param g Game.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * Function: removing a block from the game.
     *
     * @param game the current Game.
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        if (this.hitListenerList == null) {
            hitListenerList = new ArrayList<>();
        }
        hitListenerList.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        hitListenerList.remove(hl);
    }

    /**
     * @param hitter The hitter parameter is the Ball that's doing the hitting.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListenerList);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}