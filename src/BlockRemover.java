/*ass6:
Name: Adi Schiff
ID: 212730675
*/

/**
 * BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * @param game          the current game.
     * @param removedBlocks the number of blocks that's still at the game.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * Function: removing the blocks that have been hit and their listener.
     *
     * @param beingHit This method is called whenever the beingHit object is hit.
     * @param hitter   The hitter parameter is the Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(game);
        beingHit.removeHitListener(this);
        this.remainingBlocks.decrease(1);
    }
}
