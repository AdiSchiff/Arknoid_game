/*ass6:
Name: Adi Schiff
ID: 212730675
*/

/**
 * interface HitNotifier.
 */
public interface HitNotifier {

    /**
     * Function: Add hl as a listener to hit events.
     *
     * @param hl a HitListener.
     */
    void addHitListener(HitListener hl);

    /**
     * Function: Remove hl from the list of listeners to hit events.
     *
     * @param hl a HitListener.
     */
    void removeHitListener(HitListener hl);
}
