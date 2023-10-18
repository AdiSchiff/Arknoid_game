/*ass6:
Name: Adi Schiff
ID: 212730675
*/

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * wrap an existing animation and add a "waiting-for-key" behavior to it.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * @param sensor    a given KeyboardSensor.
     * @param key       the key that was pressed.
     * @param animation a given Animation.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.animation = animation;
        this.key = key;
        this.sensor = sensor;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (!this.sensor.isPressed(key)) {
            this.isAlreadyPressed = false;
        }
        if (this.sensor.isPressed(key) && !this.isAlreadyPressed) {
            this.stop = true;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }

}
