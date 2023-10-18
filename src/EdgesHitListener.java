/*ass6:
Name: Adi Schiff
ID: 212730675
*/

/**
 * EdgesHitListener is in charge of detecting if a hit has been made
 * with one of the frame's edges.
 */
public class EdgesHitListener implements HitListener {
    private GameLevel game;

    /**
     * @param game the current game.
     */
    public EdgesHitListener(GameLevel game) {
        this.game = game;
    }

    /**
     * @param beingHit the border that has been hit.
     * @param hitter   the ball that hit the border.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
    }
}
