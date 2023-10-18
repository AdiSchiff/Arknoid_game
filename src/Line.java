/*ass6:
Name: Adi Schiff
ID: 212730675
*/

import java.util.ArrayList;

/**
 * class of Line.
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * Function: set the values of a line.
     *
     * @param start point the line starts from
     * @param end   point the line ends at
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Function: set the values of a line.
     *
     * @param x1 the x value of the first point
     * @param y1 the y value of the first point
     * @param x2 the x value of the second point
     * @param y2 the y value of the second point
     */
    public Line(double x1, double y1, double x2, double y2) {
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        this.start = p1;
        this.end = p2;
    }

    /**
     * @return the length of the line
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * @return the middle point of the line
     */
    public Point middle() {
        return new Point((this.start.getX() + this.end.getX()) / 2, (this.start.getY() + this.end.getY()) / 2);
    }

    /**
     * @return the start point of the line
     */
    public Point start() {
        return this.start;
    }

    /**
     * @return the end point of the line
     */
    public Point end() {
        return this.end;
    }

    /**
     * @param other line
     * @return true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        double maxX1 = this.start.getX();
        double minX1 = this.end.getX();
        if (maxX1 < minX1) {
            //finds the max x of the first line
            maxX1 = minX1;
            minX1 = this.start.getX();
        }
        double maxY1 = this.start.getY();
        double minY1 = this.end.getY();
        if (maxY1 < minY1) {
            //finds the max y of the first line
            maxY1 = minY1;
            minY1 = this.start.getY();
        }
        double maxX2 = other.start.getX();
        double minX2 = other.end.getX();
        if (maxX2 < minX2) {
            //finds the max x of the second line
            maxX2 = minX2;
            minX2 = other.start.getX();
        }
        double maxY2 = other.start.getY();
        double minY2 = other.end.getY();
        if (maxY2 < minY2) {
            //finds the max y of the second line
            maxY2 = minY2;
            minY2 = other.start.getY();
        }
        if (minX1 > maxX2 || minY1 > maxY2 || minX2 > maxX1 || minY2 > maxY1) {
            //checks if the lines are in the same Square
            return false;
        }
        if (maxX1 == minX1 && maxX2 == minX2) {
            //if the lines are parallel
            if (maxX2 == maxX1) {
                //if the lines have the same x
                return maxY1 >= minY2 || minY1 <= maxY2;
            } else {
                return false;
            }
        }
        if (maxX1 == minX1) {
            //if the first line perpendicular to the x-axis
            double incline = other.whatIncline();
            double dot = other.findDot(incline);
            double y = incline * maxX1 + dot;
            return (y <= maxY1 && y >= minY1);
        }
        if (maxX2 == minX2) {
            //if the second line perpendicular to the x-axis
            double incline = this.whatIncline();
            double dot = this.findDot(incline);
            double y = incline * maxX1 + dot;
            return (y <= maxY2 && y >= minY2);
        }
        double incline1 = this.whatIncline();
        double incline2 = other.whatIncline();
        double b1 = this.findDot(incline1);
        double b2 = other.findDot(incline2);
        if (incline1 != incline2) {
            double x = findIntersection(incline1, b1, incline2, b2);
            return (x <= maxX1 && x >= minX1 && x <= maxX2 && x >= minX2);
        }
        // incline1 == incline2
        if (b1 != b2) { //the functions are parallel
            return false;
        }
        return (maxX1 >= minX2 && maxX1 <= maxX2) || (minX1 >= minX2 && minX1 <= maxX2);
    }

    /**
     * @param incline1 of line 1
     * @param b1       of line 1
     * @param incline2 of line 2
     * @param b2       of line 2
     * @return the x value of the intersection point
     */
    public double findIntersection(double incline1, double b1, double incline2, double b2) {
        return (b2 - b1) / (incline1 - incline2);
    }

    /**
     * @param incline of the line
     * @return the b parameter of the function
     */
    public double findDot(double incline) {
        return this.start.getY() - (this.start.getX() * incline);
    }

    /**
     * @return incline of the line
     */
    public double whatIncline() {
        return (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
    }

    /**
     * @param other line
     * @return the intersection point if the lines intersect, and null otherwise.
     */
    public Point intersectionWith(Line other) {
        if (!isIntersecting(other)) {
            return null;
        }
        double maxX1 = this.start.getX();
        double minX1 = this.end.getX();
        if (maxX1 < minX1) {
            //finds the max x of the first line
            maxX1 = minX1;
            minX1 = this.start.getX();
        }
        double maxY1 = this.start.getY();
        double minY1 = this.end.getY();
        if (maxY1 < minY1) {
            //finds the max y of the first line
            maxY1 = minY1;
            minY1 = this.start.getY();
        }
        double maxX2 = other.start.getX();
        double minX2 = other.end.getX();
        if (maxX2 < minX2) {
            //finds the max x of the second line
            maxX2 = minX2;
            minX2 = other.start.getX();
        }
        double maxY2 = other.start.getY();
        double minY2 = other.end.getY();
        if (maxY2 < minY2) {
            //finds the max y of the second line
            maxY2 = minY2;
            minY2 = other.start.getY();
        }
        if (maxX1 == minX1 && maxX2 == minX2) {
            //if the lines are parallel
            if (maxX2 == maxX1) {
                //if the lines have the same x
                if (maxY1 == minY2) {
                    return new Point(maxX1, maxY1);
                }
                if (minY1 == maxY2) {
                    return new Point(maxX1, maxY2);
                }
            } else {
                return null;
            }
        }
        if (maxX1 == minX1) {
            //if the first line perpendicular to the x-axis
            double incline = other.whatIncline();
            double dot = other.findDot(incline);
            double y = incline * maxX1 + dot;
            if (y <= maxY1 && y >= minY1) {
                return new Point(maxX1, y);
            }
            return null;
        }
        if (maxX2 == minX2) {
            //if the second line perpendicular to the x-axis
            double incline = this.whatIncline();
            double dot = this.findDot(incline);
            double y = incline * maxX1 + dot;
            if (y < maxY2 && y > minY2) {
                return new Point(maxX2, y);
            }
            return null;
        }
        double incline1 = this.whatIncline();
        double incline2 = other.whatIncline();
        double b1 = this.findDot(incline1);
        double b2 = other.findDot(incline2);

        if (incline1 != incline2) {
            double x = findIntersection(incline1, b1, incline2, b2);
            return new Point(x, incline1 * x + b1);
        }
        // incline1 == incline2
        if (b1 != b2) { //the functions are parallel
            return null;
        }
        if (minX1 == maxX2) { //the lines create a strait line and intersect id one point
            return new Point(minX1, incline1 * minX1 + b1);
        }
        if (minX2 == maxX1) { //the lines create a strait line and intersect id one point
            return new Point(minX2, incline2 * minX2 + b2);
        }
        return null;
    }

    /**
     * @param other line
     * @return true if the lines are equal, false otherwise
     */
    public boolean equals(Line other) {
        if (this.start.equals(other.start) && this.end.equals(other.end)) {
            return true;
        }
        return this.start.equals(other.end) && this.end.equals(other.start);
    }

    /**
     * Function: If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the start of the line.
     *
     * @param rect a rectangle the line intersect with.
     * @return a point according to the function description.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        Line[] rectLineArr = rect.rectLines();
        Line line = new Line(this.start, this.end);
        ArrayList<Point> intersections = (ArrayList<Point>) rect.intersectionPoints(line);
        if (!intersections.isEmpty()) {
            //if the line and the rectangle have a countable intersection points
            Point minDistance = intersections.get(0);
            for (int i = 1; i < intersections.size(); i++) {
                if (this.start.distance(intersections.get(i)) < this.start.distance(minDistance)) {
                    minDistance = intersections.get(i);
                }
            }
            return minDistance;
        }
        double thisIncline = this.whatIncline();
        double b1 = this.findDot(thisIncline);
        for (Line value : rectLineArr) {
            if (isIntersecting(value)) {
                double incline2 = value.whatIncline();
                double b2 = value.findDot(incline2);
                //if the lines merge
                if (thisIncline == incline2 && b1 == b2) {
                    //what point is closer to the line's starting point
                    if (this.start.distance(value.start) < this.start.distance(value.end)) {
                        //if the line start outside the rectangle
                        if (this.start.distance(value.end) > value.length()) {
                            return value.start;
                        }
                        return this.start;
                    } else { //if the line start outside the rectangle
                        if (this.start.distance(value.start) > value.length()) {
                            return value.end;
                        }
                        return this.start;
                    }
                }
            }
        }
        return null;
    }


}