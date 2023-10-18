/*ass6:
Name: Adi Schiff
ID: 212730675
*/

/**
 * class of Point.
 */
public class Point {
    private double x;
    private double y;
    private static final double EPSILON = Math.pow(10, -10);

    /**
     * Function: set the values of a point.
     *
     * @param x value of the point
     * @param y value of the point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @param other point to measure distance with
     * @return the distance of this point to the other point
     */
    public double distance(Point other) {
        return Math.sqrt((this.x - other.getX()) * (this.x - other.getX())
                + (this.y - other.getY()) * (this.y - other.getY()));
    }

    /**
     * @param other point to compare
     * @return true is the points are equal, false otherwise
     */
    public boolean equals(Point other) {
        return ((Math.abs(this.x - other.getX()) < EPSILON) && (Math.abs(this.y - other.getY()) < EPSILON));
    }

    /**
     * @return the x value of the point
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return the y value of the point
     */
    public double getY() {
        return this.y;
    }

    /**
     * Function: set the x value of the point.
     *
     * @param x new x value for the point
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Function: set the y value of the point.
     *
     * @param y new y value for the point
     */
    public void setY(double y) {
        this.y = y;
    }
}