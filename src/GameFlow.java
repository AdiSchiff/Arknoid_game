/*ass6:
Name: Adi Schiff
ID: 212730675
*/


import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.List;

/**
 * Game Flow class.
 */
public class GameFlow {
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private GUI gui;
    private Counter score;

    /**
     * @param ar  a given AnimationRunner.
     * @param gui a given GUI.
     * @param ks  a given keyboardSensor.
     */
    public GameFlow(AnimationRunner ar, GUI gui, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.gui = gui;
        this.score = new Counter();
    }

    /**
     * runs the game level after level.
     *
     * @param levels list of the game's levels information.
     */
    public void runLevels(List<LevelInformation> levels) {
        boolean flag = true;
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(animationRunner, gui, levelInfo, keyboardSensor, score);
            level.initialize();

            while ((level.getNumOfBlocks() > 0) && (level.getNumOfBalls() > 0)) {
                level.run();
            }
            if (level.getNumOfBalls() == 0) {
                flag = false;
                break;
            }
        }
        animationRunner.run(new KeyPressStoppableAnimation(keyboardSensor,
                KeyboardSensor.SPACE_KEY, new EndScreen(flag, this.score.getValue())));
        gui.close();
    }
}
