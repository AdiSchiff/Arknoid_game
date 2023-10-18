/*ass6:
Name: Adi Schiff
ID: 212730675
*/

/**
 * BallRemover is in charge of removing balls from the game if they reach
 * the bottom of the frame (missing the paddle), as well as keeping count
 * of the number of balls that remain.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * @param game           the current game.
     * @param remainingBalls the number of balls that's still at the game.
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }

    /**
     * Function: removing the ball that hit the bottom of the frame.
     *
     * @param beingHit This method is called whenever the beingHit object is hit.
     * @param hitter   The hitter parameter is the Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(game);
        this.remainingBalls.decrease(1);
    }
}
