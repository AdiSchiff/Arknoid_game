/*ass6:
Name: Adi Schiff
ID: 212730675
*/

/**
 * ScoreTrackingListener is in charge of tracking the player's score during the game.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * @param scoreCounter new value for the game's score.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * @param beingHit This method is called whenever the beingHit object is hit.
     * @param hitter   The hitter parameter is the Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
}
