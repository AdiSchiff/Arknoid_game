/*ass6:
Name: Adi Schiff
ID: 212730675
*/

import java.util.ArrayList;

/**
 * collection of objects a Ball can collide with.
 */
public class GameEnvironment {
    private ArrayList<Collidable> collidable;

    /**
     * Function: set the value of a GameEnvironment.
     */
    public GameEnvironment() {
        this.collidable = new ArrayList<>();
    }

    /**
     * Function: adding a collidable to the list.
     *
     * @param c new collidable.
     */
    public void addCollidable(Collidable c) {
        this.collidable.add(c);
    }

    /**
     * Function: removing a collidable from the list.
     *
     * @param c an existing collidable.
     */
    public void removeCollidable(Collidable c) {
        this.collidable.remove(c);
    }

    /**
     * @param trajectory of the ball.
     * @return the information about the closest collision that is going to occur.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        ArrayList<Point> intersectionPoints = new ArrayList<>();
        ArrayList<Integer> intersectionIndex = new ArrayList<>();
        for (int i = 0; i < this.collidable.size(); i++) {
            if (trajectory.closestIntersectionToStartOfLine(this.collidable.get(i).getCollisionRectangle()) != null) {
                intersectionPoints.
                        add(trajectory.closestIntersectionToStartOfLine(collidable.get(i).getCollisionRectangle()));
                intersectionIndex.add(i);
            }
        }
        if (intersectionPoints.isEmpty()) {
            return null;
        }
        Point closest = intersectionPoints.get(0);
        int index = 0;
        for (int i = 1; i < intersectionPoints.size(); i++) {
            if (trajectory.start().distance(intersectionPoints.get(i)) < trajectory.start().distance(closest)) {
                closest = intersectionPoints.get(i);
                index = i;
            }
        }
        return new CollisionInfo(closest, collidable.get(intersectionIndex.get(index)));
    }
}
