/*ass6:
Name: Adi Schiff
ID: 212730675
*/

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * level 4.
 */
public class FinalFour implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        Velocity velocity1 = new Velocity(-3, -4);
        velocities.add(velocity1);
        Velocity velocity2 = new Velocity(3, -4);
        velocities.add(velocity2);
        Velocity velocity3 = new Velocity(0, -5);
        velocities.add(velocity3);
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        Sprite background = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                java.awt.Color color = new Color(152, 234, 255);
                d.setColor(color);
                d.fillRectangle(15, 30, 770, 570);
                color = new Color(239, 82, 82);
                d.setColor(color);
                d.fillCircle(400, 600, 350);
                color = new Color(236, 146, 82);
                d.setColor(color);
                d.fillCircle(400, 600, 335);
                color = new Color(255, 231, 70);
                d.setColor(color);
                d.fillCircle(400, 600, 320);
                color = new Color(93, 218, 100);
                d.setColor(color);
                d.fillCircle(400, 600, 305);
                color = new Color(95, 192, 215);
                d.setColor(color);
                d.fillCircle(400, 600, 290);
                color = new Color(54, 146, 218);
                d.setColor(color);
                d.fillCircle(400, 600, 275);
                color = new Color(173, 121, 222, 255);
                d.setColor(color);
                d.fillCircle(400, 600, 260);
                color = new Color(152, 234, 255);
                d.setColor(color);
                d.fillCircle(400, 600, 245);
                color = new Color(205, 208, 210);
                d.setColor(color);
                //left cloud
                d.fillCircle(50, 600, 40);
                d.fillCircle(155, 600, 45);
                d.fillCircle(100, 570, 30);
                //right cloud
                d.fillCircle(750, 600, 40);
                d.fillCircle(640, 600, 45);
                d.fillCircle(700, 570, 35);
            }

            @Override
            public void timePassed() {

            }
        };
        return background;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        java.awt.Color color;
        for (int i = 0; i < 7; i++) {
            double x = 15, y = 100 + (25 * i);
            color = new Color(234 - i * 10, 182 + i * 10, 209 + i - 10);
            for (int j = 0; j < 15; j++) {
                Rectangle rect = new Rectangle(new Point(x, y), (double) 770 / 15, 25);
                Block b = new Block(rect, color);
                blocks.add(b);
                x += (double) 770 / 15;
            }
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 105;
    }
}
