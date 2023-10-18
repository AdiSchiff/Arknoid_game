/*ass6:
Name: Adi Schiff
ID: 212730675
*/

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * level 1.
 */
public class Green3 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        Velocity velocity1 = new Velocity(-3, -4);
        velocities.add(velocity1);
        Velocity velocity2 = new Velocity(3, -4);
        velocities.add(velocity2);
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
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        Sprite background = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                java.awt.Color color = new Color(44, 54, 115);
                d.setColor(color);
                d.fillRectangle(15, 30, 770, 570);
                color = new Color(21, 20, 20);
                d.setColor(color);
                d.fillRectangle(50, 300, 150, 300);
                color = new Color(199, 197, 197);
                d.setColor(color);
                //star 1
                d.fillCircle(70, 90, 30);
                d.fillCircle(700, 90, 2);
                d.drawLine(695, 90, 705, 90);
                d.drawLine(700, 83, 700, 97);
                //star 2
                d.fillCircle(100, 50, 2);
                d.drawLine(95, 50, 105, 50);
                d.drawLine(100, 43, 100, 57);
                //star 3
                d.fillCircle(560, 350, 2);
                d.drawLine(555, 350, 565, 350);
                d.drawLine(560, 343, 560, 357);
                //star 4
                d.fillCircle(370, 200, 2);
                d.drawLine(365, 200, 375, 200);
                d.drawLine(370, 193, 370, 207);
                //star 5
                d.fillCircle(200, 250, 2);
                d.drawLine(195, 250, 205, 250);
                d.drawLine(200, 243, 200, 257);
                color = new Color(44, 54, 115);
                d.setColor(color);
                d.fillCircle(80, 80, 30);
                color = new Color(194, 173, 89);
                d.setColor(color);
                int x, y = 310;
                for (int i = 0; i < 5; i++) {
                    x = 60;
                    for (int j = 0; j < 5; j++) {
                        d.fillRectangle(x, y, 18, 50);
                        x += 28;
                    }
                    y += 60;
                }
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
        for (int i = 0; i < 5; i++) {
            int x = 740, y = 100 + (25 * i);
            color = new Color(183 - i * 10, 177 - i * 10, 177 + i * 10);
            for (int j = 0; j < (10 - i); j++) {
                Rectangle rect = new Rectangle(new Point(x, y), 45, 25);
                Block b = new Block(rect, color);
                blocks.add(b);
                x = x - 45;
            }
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 40;
    }
}
