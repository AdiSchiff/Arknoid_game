/*ass6:
Name: Adi Schiff
ID: 212730675
*/

/**
 * interface HitListener.
 */
public interface HitListener {

    /**
     * @param beingHit This method is called whenever the beingHit object is hit.
     * @param hitter   The hitter parameter is the Ball that's doing the hitting.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
