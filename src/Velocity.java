/*ass6:
Name: Adi Schiff
ID: 212730675
*/

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * Function: set the values of a velocity.
     *
     * @param dx value of the x-axes
     * @param dy value of the y-axes
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * @return the dx value
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * @return the dy value
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * Function: set the dx value of the velocity.
     *
     * @param dx new dx value for the velocity
     */
    public void setDx(double dx) {
        this.dx = dx;
    }

    /**
     * Function: set the dy value of the velocity.
     *
     * @param dy new dy value for the velocity
     */
    public void setDy(double dy) {
        this.dy = dy;
    }

    /**
     * @param p point
     * @return Take a point with position (x,y) and return a new point with position (x+dx, y+dy)
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

    /**
     * @param angle of the movement direction
     * @param speed of the ball's movement
     * @return the velocity of the ball
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = Math.sin(Math.toRadians(angle)) * speed;
        double dy = -Math.cos(Math.toRadians(angle)) * speed;
        return new Velocity(dx, dy);
    }
}