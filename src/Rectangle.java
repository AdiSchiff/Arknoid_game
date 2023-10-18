/*ass6:
Name: Adi Schiff
ID: 212730675
*/

import java.util.ArrayList;
import java.util.List;

/**
 * class Rectangle.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * Function: Create a new rectangle with location and width/height.
     *
     * @param upperLeft point
     * @param width     of the rectangle
     * @param height    of the rectangle
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * Function: check if a line is intersecting with the rectangle and return a list of intersection points.
     *
     * @param line to check if intersecting with the rectangle
     * @return a (possibly empty) List of intersection points
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        Line[] rectLineArr = rectLines();
        List<Point> intersectionList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if (line.intersectionWith(rectLineArr[i]) != null) {
                intersectionList.add(line.intersectionWith(rectLineArr[i]));
            }
        }
        return intersectionList;
    }

    /**
     * @return array of the rectangles lines.
     */
    public Line[] rectLines() {
        //create the rectangle's vertexes
        Point upperRight = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY());
        Point bottomLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
        Point bottomRight = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height);
        //create the rectangle's lines
        Line up = new Line(this.upperLeft, upperRight);
        Line right = new Line(upperRight, bottomRight);
        Line bottom = new Line(bottomLeft, bottomRight);
        Line left = new Line(this.upperLeft, bottomLeft);
        return new Line[]{up, right, bottom, left};
    }

    /**
     * @return the width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * @return the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * @param upperLeft new value for the rectangle's upperLeft point.
     */
    public void setUpperLeft(Point upperLeft) {
        this.upperLeft = upperLeft;
    }
}