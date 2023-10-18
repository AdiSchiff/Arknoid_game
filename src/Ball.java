/*ass6:
Name: Adi Schiff
ID: 212730675
*/

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.Random;

/**
 * class Ball.
 */
public class Ball implements Sprite {
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment ge;

    /**
     * Function: set the values of a ball.
     *
     * @param center point of the ball
     * @param r      the radius of the ball
     * @param color  of the ball
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.ge = new GameEnvironment();
        setVelocity(0, 0);
    }

    /**
     * Function: set the values of a ball.
     *
     * @param x     value of the ball's center point
     * @param y     value of the ball's center point
     * @param r     the ball's radius
     * @param color the color of the ball
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        setVelocity(0, 0);
    }

    /**
     * @param ge new value for the ball's GameEnvironment.
     */
    public void setGameEnvironment(GameEnvironment ge) {
        this.ge = ge;
    }

    /**
     * @param g game to add the ball to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * @param g game to remove the ball from.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }

    /**
     * @return the ball's gameEnvironment.
     */
    public GameEnvironment getGe() {
        return this.ge;
    }

    /**
     * @return the x value of the center point of the ball
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * @return the y value of the center point of the ball
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * @return the center point of the ball.
     */
    public Point getCenter() {
        return this.center;
    }

    /**
     * @return the size of the ball meaning it's radius
     */
    public int getSize() {
        return this.r;
    }

    /**
     * @return the color of the ball
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * @param color to replace the current one.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return random color
     */
    public Color randColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        return new Color(r, g, b);
    }

    /**
     * Function: set the ball's size (=radius).
     *
     * @param r new radius value
     */
    public void setSize(int r) {
        this.r = r;
    }

    /**
     * Function: draw the ball on the surface.
     *
     * @param surface that the ball will be drawn on
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
        surface.setColor(Color.BLACK);
        surface.drawCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
    }

    /**
     * Function: executing the moveOneStep method.
     */
    @Override
    public void timePassed() {
        moveOneStep();
    }

    /**
     * Function: set the velocity of a ball.
     *
     * @param v ball's velocity
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * Function: set the velocity of a ball.
     *
     * @param dx value of the velocity
     * @param dy value of the velocity
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * @return the velocity of the ball
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * Function: changing the ball's velocity or center if it reached one of the limits.
     */
    public void moveOneStep() {
        Point end = this.velocity.applyToPoint(this.center);
        Line trajectory = new Line(this.center, end);
        CollisionInfo cInfo = this.ge.getClosestCollision(trajectory);
        //if the ball will not collide set the ball to it's next position.
        if (cInfo == null) {
            this.center = this.getVelocity().applyToPoint(this.center);
        } else { //if the ball will collide set the velocity
            if (this.velocity.getDx() > 0) { //moving right
                this.center.setX(cInfo.collisionPoint().getX() - 1);
            } else { //moving left
                this.center.setX(cInfo.collisionPoint().getX() + 1);
            }
            if (this.velocity.getDy() > 0) { //moving down
                this.center.setY(cInfo.collisionPoint().getY() - 1);
            } else { //moving up
                this.center.setY(cInfo.collisionPoint().getY() + 1);
            }
            setVelocity(cInfo.collisionObject().hit(this, cInfo.collisionPoint(), this.velocity));
        }
    }
}
