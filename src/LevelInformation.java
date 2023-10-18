/*ass6:
Name: Adi Schiff
ID: 212730675
*/

import java.util.List;

/**
 * LevelInformation interface.
 */
public interface LevelInformation {

    /**
     * @return the number of balls.
     */
    int numberOfBalls();

    /**
     * @return The initial velocity of each ball.
     * Note that initialBallVelocities().size() == numberOfBalls()
     */
    List<Velocity> initialBallVelocities();

    /**
     * @return the paddle's speed.
     */
    int paddleSpeed();

    /**
     * @return the paddle's width.
     */
    int paddleWidth();

    /**
     * @return the level name that will be displayed at the top of the screen.
     */
    String levelName();

    /**
     * @return a sprite with the background of the level.
     */
    Sprite getBackground();

    /**
     * @return The Blocks that make up this level, each block contains its size, color and location.
     */
    List<Block> blocks();

    /**
     * @return the number of blocks that should be removed before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     */
    int numberOfBlocksToRemove();
}
