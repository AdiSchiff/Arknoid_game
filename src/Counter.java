/*ass6:
Name: Adi Schiff
ID: 212730675
*/

/**
 * class counter.
 */
public class Counter {
    private int count = 0;

    /**
     * @param number integer value to add to the current count.
     */
    void increase(int number) {
        this.count += number;
    }

    /**
     * @param number integer value to subtract from the current count.
     */
    void decrease(int number) {
        this.count -= number;
    }

    /**
     * @return the current count.
     */
    int getValue() {
        return this.count;
    }
}
