/*ass6:
Name: Adi Schiff
ID: 212730675
*/

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * Class of a Game.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter blocksCounter;
    private Counter ballsCounter;
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation levelInformation;

    /**
     * Function: set the values of a game.
     *
     * @param runner           the game runs according to its value.
     * @param gui              the game's GUI.
     * @param levelInformation the information of the current level.
     * @param ks               a given KeyboardSensor.
     * @param score            the current score.
     */
    public GameLevel(AnimationRunner runner, GUI gui, LevelInformation levelInformation,
                     KeyboardSensor ks, Counter score) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.gui = gui;
        this.blocksCounter = new Counter();
        this.ballsCounter = new Counter();
        this.score = score;
        this.runner = runner;
        this.keyboard = ks;
        this.levelInformation = levelInformation;
    }

    /**
     * @return the current number of blocks in the game.
     */
    public int getNumOfBlocks() {
        return blocksCounter.getValue();
    }

    /**
     * @return the current number of balls in the game.
     */
    public int getNumOfBalls() {
        return ballsCounter.getValue();
    }

    /**
     * Function: adding a new collidable to the collidables list.
     *
     * @param c a new Collidable.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * Function: removing a given collidable from the collidables list.
     *
     * @param c a collidable to remove.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * Function: adding a new sprite to the sprites list.
     *
     * @param s a new Sprite.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Function: removing a given sprite from the sprites list.
     *
     * @param s a sprite to remove.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(keyboard, KeyboardSensor.SPACE_KEY, new PauseScreen()));
        }
        if (this.blocksCounter.getValue() == 0) {
            this.score.increase(100);
            this.running = false;
        }
        if (this.ballsCounter.getValue() == 0) {
            this.running = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle) and add them to the game.
     */
    public void initialize() {
        BlockRemover blockRemover = new BlockRemover(this, this.blocksCounter);
        EdgesHitListener ehl = new EdgesHitListener(this);
        BallRemover ballRemover = new BallRemover(this, this.ballsCounter);
        ScoreTrackingListener stl = new ScoreTrackingListener(this.score);
        ScoreIndicator scoreIndicator = new ScoreIndicator(this.score);
        this.sprites.addSprite(scoreIndicator);
        String levelName = this.levelInformation.levelName();
        this.sprites.addSprite(levelInformation.getBackground());
        this.sprites.addSprite(new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(Color.BLACK);
                d.drawText(600, 14, "Level Name: " + levelName, 15);
            }

            @Override
            public void timePassed() {

            }
        });
        Ball[] balls = new Ball[levelInformation.numberOfBalls()];
        for (int i = 0; i < levelInformation.numberOfBalls(); i++) {
            balls[i] = new Ball(new Point(400, 565), 6, Color.white);
            balls[i].setVelocity(levelInformation.initialBallVelocities().get(i));
            balls[i].addToGame(this);
        }
        this.ballsCounter.increase(levelInformation.numberOfBalls());
        Block[] boundaries = new Block[4];
        Rectangle[] rectBoundaries = new Rectangle[4];
        Point upBounder = new Point(0, 15);
        Point rightBounder = new Point(785, 30);
        Point leftBounder = new Point(0, 30);
        Point undergroundBounder = new Point(0, 600);
        rectBoundaries[0] = new Rectangle(upBounder, 800, 15);
        rectBoundaries[1] = new Rectangle(rightBounder, 15, 570);
        rectBoundaries[2] = new Rectangle(leftBounder, 15, 570);
        rectBoundaries[3] = new Rectangle(undergroundBounder, 800, 15);
        for (int i = 0; i < 3; i++) {
            boundaries[i] = new Block(rectBoundaries[i], Color.GRAY);
            boundaries[i].addToGame(this);
            boundaries[i].addHitListener(ehl);
        }
        boundaries[3] = new Block(rectBoundaries[3], Color.GRAY);
        boundaries[3].addToGame(this);
        boundaries[3].addHitListener(ballRemover);
        this.blocksCounter.increase(levelInformation.numberOfBlocksToRemove());
        for (int i = 0; i < levelInformation.numberOfBlocksToRemove(); i++) {
            Block block = new Block(levelInformation.blocks().get(i).getCollisionRectangle(),
                    levelInformation.blocks().get(i).getColor());
            block.addToGame(this);
            block.addHitListener(blockRemover);
            block.addHitListener(stl);
        }
        Rectangle paddleRect = new Rectangle(new Point(400 - (double) (levelInformation.paddleWidth() / 2),
                570), levelInformation.paddleWidth(), 15);
        Paddle paddle = new Paddle(this.gui, paddleRect, Color.yellow, levelInformation.paddleSpeed());
        paddle.addToGame(this);
        for (Ball ball : balls) {
            ball.setGameEnvironment(environment);
        }
    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        this.running = true;
        this.runner.run(new CountdownAnimation(2, 3, sprites)); // countdown before turn starts.
        // use our runner to run the current animation -- which is one turn of the game.
        this.runner.run(this);
    }
}
