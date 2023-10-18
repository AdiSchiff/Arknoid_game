/*ass6:
Name: Adi Schiff
ID: 212730675
*/

/**
 * interface Collidable.
 */
public interface Collidable {

    /**
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * Function: Notify the object that we collided with it at collisionPoint with a given velocity.
     * The return is the new velocity expected after the hit (based on the force the object inflicted on us).
     *
     * @param hitter          The hitter parameter is the Ball that's doing the hitting.
     * @param collisionPoint  with the block.
     * @param currentVelocity of the ball.
     * @return a new velocity for the ball.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}