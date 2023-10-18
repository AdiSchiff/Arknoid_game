/*ass6:
Name: Adi Schiff
ID: 212730675
*/


import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * AnimationRunner class.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    /**
     * AnimationRunner constructor.
     *
     * @param gui a given Gui.
     */
    public AnimationRunner(GUI gui) {
        this.sleeper = new Sleeper();
        this.framesPerSecond = 60;
        this.gui = gui;
    }

    /**
     * runs the visuality of the frames.
     *
     * @param animation the current screen we want to display.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
