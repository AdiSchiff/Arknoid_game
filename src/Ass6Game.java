/*ass6:
Name: Adi Schiff
ID: 212730675
*/

import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.ArrayList;
import java.util.List;

/**
 * runs the game.
 */
public class Ass6Game {
    /**
     * @param args given to the main function as default.
     */
    public static void main(String[] args) {
        GUI gui = new GUI("title", 800, 600);
        DirectHit level1 = new DirectHit();
        WideEasy level2 = new WideEasy();
        Green3 level3 = new Green3();
        FinalFour level4 = new FinalFour();
        List<LevelInformation> levels = new ArrayList<>();
        levels.add(level1);
        levels.add(level2);
        levels.add(level3);
        levels.add(level4);
        List<LevelInformation> levelsOrder = new ArrayList<>();
        for (String arg : args) {
            if (arg.equals("1")) {
                levelsOrder.add(level1);
            } else {
                if (arg.equals("2")) {
                    levelsOrder.add(level2);
                } else {
                    if (arg.equals("3")) {
                        levelsOrder.add(level3);
                    } else {
                        if (arg.equals("4")) {
                            levelsOrder.add(level4);
                        }
                    }
                }
            }
        }
        AnimationRunner ar = new AnimationRunner(gui);
        KeyboardSensor ks = gui.getKeyboardSensor();
        GameFlow gameFlow = new GameFlow(ar, gui, ks);
        if (levelsOrder.size() == 0) {
            gameFlow.runLevels(levels);
        } else {
            gameFlow.runLevels(levelsOrder);
        }
    }
}
