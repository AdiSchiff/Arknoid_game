/*ass6:
Name: Adi Schiff
ID: 212730675
*/

/**
 * Class of the collision's information.
 */
public class CollisionInfo {
    private Point pointOfCollision;
    private Collidable objectOfCollision;

    /**
     * Function: set the values of a CollisionInfo.
     *
     * @param cPoint  the point of the collision.
     * @param cObject the object of the collision.
     */
    public CollisionInfo(Point cPoint, Collidable cObject) {
        this.pointOfCollision = cPoint;
        this.objectOfCollision = cObject;
    }

    /**
     * @return the collisionPoint.
     */
    public Point collisionPoint() {
        return this.pointOfCollision;
    }

    /**
     * @return the collisionObject.
     */
    public Collidable collisionObject() {
        return this.objectOfCollision;
    }
}