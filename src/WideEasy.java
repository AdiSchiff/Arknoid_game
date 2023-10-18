/*ass6:
Name: Adi Schiff
ID: 212730675
*/

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * level 2.
 */
public class WideEasy implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        //the left 5 velocities.
        double x = 0.1;
        for (int i = 0; i < this.numberOfBalls() / 2; i++) {
            Velocity velocity = new Velocity(-1 * (i + 0.5), -5 + i * x);
            velocities.add(velocity);
            x += 0.1;
        }
        x = 0.1;
        //the right 5 velocities.
        for (int i = 0; i < this.numberOfBalls() / 2; i++) {
            Velocity velocity = new Velocity(i + 0.5, -5 + i * x);
            velocities.add(velocity);
            x += 0.1;

        }
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 600;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        Sprite background = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                java.awt.Color color = new Color(215, 211, 153);
                d.setColor(color);
                for (int i = 0; i < 60; i++) {
                    d.drawLine(120, 120, i * i / 5, 200);
                }
                d.fillCircle(120, 120, 60);
                color = new Color(245, 236, 74);
                d.setColor(color);
                d.fillCircle(120, 120, 50);
                d.setColor(Color.YELLOW);
                d.fillCircle(120, 120, 40);

            }

            @Override
            public void timePassed() {
            }
        };
        return background;
    }

    /**
     * @return random color
     */
    public Color randColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        return new Color(r, g, b);
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        double x = 15;
        java.awt.Color color = new Color(239, 82, 82);
        for (int i = 0; i < this.numberOfBlocksToRemove(); i++) {
            Rectangle rect = new Rectangle(new Point(x, 200), (double) 770 / 15, 20);
            x += (double) 770 / 15;
            if (i == 0 || i == 2 || i == 4 || i == 6 || i == 9 || i == 11 || i == 13) {
                color = new Color(239 - i * 15, 82 + i * 10, 82 + i * 10);
            }
            Block b = new Block(rect, color);
            blocks.add(b);
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }
}
