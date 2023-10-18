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
public class DirectHit implements LevelInformation {

    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        Velocity velocity = new Velocity(0, -5);
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(velocity);
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
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        Sprite background = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(Color.BLACK);
                d.fillRectangle(15, 30, 770, 570);
                d.setColor(Color.WHITE);
                d.fillOval(300, 45, 200, 150);
                d.setColor(Color.red);
                d.drawOval(300, 45, 200, 150);
                d.drawOval(330, 65, 140, 110);
                d.drawOval(360, 85, 80, 70);
                d.drawLine(300, 120, 500, 120);
                d.drawLine(400, 45, 400, 195);
            }

            @Override
            public void timePassed() {
            }
        };
        return background;
    }

    @Override
    public List<Block> blocks() {
        Rectangle rect = new Rectangle(new Point(380, 100), 40, 40);
        Block b = new Block(rect, Color.red);
        List<Block> blocks = new ArrayList<>();
        blocks.add(b);
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
