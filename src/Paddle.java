/*ass6:
Name: Adi Schiff
ID: 212730675
*/

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Class of a paddle.
 */

public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private java.awt.Color color;
    private Rectangle paddle;
    private int speed;
    static final double EPSILON = 1E-6;

    /**
     * Function: paddle constructor.
     *
     * @param gui    Gui.
     * @param paddle Rectangle.
     * @param color  of the paddle.
     * @param speed the paddle's speed.
     */
    public Paddle(biuoop.GUI gui, Rectangle paddle, Color color, int speed) {
        this.color = color;
        this.paddle = paddle;
        this.keyboard = gui.getKeyboardSensor();
        this.speed = speed;
    }

    /**
     * Function: moves the paddle to the left (if the left arrow was pressed).
     */
    public void moveLeft() {
        if (this.paddle.getUpperLeft().getX() >= 15 + speed) {
            this.paddle.getUpperLeft().setX(this.paddle.getUpperLeft().getX() - speed);
        } else {
            this.paddle.getUpperLeft().setX(15);
        }
    }

    /**
     * Function: moves the paddle to the right (if the right arrow was pressed).
     */
    public void moveRight() {
        if (this.paddle.getUpperLeft().getX() + this.paddle.getWidth() <= 785 - speed) {
            this.paddle.getUpperLeft().setX(this.paddle.getUpperLeft().getX() + speed);
        } else {
            this.paddle.getUpperLeft().setX(785 - this.paddle.getWidth());
        }
    }

    /**
     * @param d DrawSurface that the paddle will be drawn on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) this.paddle.getUpperLeft().getX(), (int) this.paddle.getUpperLeft().getY(),
                (int) this.paddle.getWidth(), (int) this.paddle.getHeight());
    }

    /**
     * checks if the arrows on the keyboard were pressed.
     */
    public void timePassed() {
        if (keyboard.isPressed(this.keyboard.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(this.keyboard.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * @return the paddle.
     */
    public Rectangle getCollisionRectangle() {
        return this.paddle;
    }


    /**
     * @param collisionPoint  of the ball and the paddle.
     * @param currentVelocity of the ball.
     * @return the velocity after colliding with the paddle.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        //if the ball hits the side of the paddle
        if (collisionPoint.getX() == this.paddle.getUpperLeft().getX()
                || collisionPoint.getX() == this.paddle.getUpperLeft().getX() + this.paddle.getWidth()) {
            currentVelocity.setDx(currentVelocity.getDx() * (-1));
        }
        //if the ball is stuck inside the paddle
        if (hitter.getX() > this.paddle.getUpperLeft().getX()
                && hitter.getX() < this.paddle.getWidth() + this.paddle.getUpperLeft().getX()
                && hitter.getY() > this.paddle.getUpperLeft().getY()
                && hitter.getY() < this.paddle.getUpperLeft().getY() + this.paddle.getHeight()) {
            hitter.getCenter().setY(this.paddle.getUpperLeft().getY() - hitter.getSize());
        }
        double speed = Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2));
        if ((collisionPoint.getY() - this.paddle.getUpperLeft().getY()) < EPSILON) {
            if (collisionPoint.distance(this.paddle.getUpperLeft()) <= this.paddle.getWidth() / 5) {
                return Velocity.fromAngleAndSpeed(300, speed);
            } else if (collisionPoint.distance(this.paddle.getUpperLeft()) <= 2 * this.paddle.getWidth() / 5) {
                return Velocity.fromAngleAndSpeed(330, speed);
            } else if (collisionPoint.distance(this.paddle.getUpperLeft()) <= 3 * this.paddle.getWidth() / 5) {
                currentVelocity.setDy(currentVelocity.getDy() * (-1));
                return currentVelocity;
            } else if (collisionPoint.distance(this.paddle.getUpperLeft()) <= 4 * this.paddle.getWidth() / 5) {
                return Velocity.fromAngleAndSpeed(30, speed);
            }
            return Velocity.fromAngleAndSpeed(60, speed);
        }
        return currentVelocity;
    }

    /**
     * Add this paddle to the game.
     *
     * @param g Game.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

}
