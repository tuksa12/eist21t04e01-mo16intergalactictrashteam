package de.tum.in.ase.eist.igt.Controller;

import de.tum.in.ase.eist.igt.GalacticGarbagemenApplication;
import de.tum.in.ase.eist.igt.Model.SpaceCraft;
import de.tum.in.ase.eist.igt.View.GameBoardUI;
import javafx.scene.input.KeyEvent;


/**
 * For some reason our KeyboardInput was not detected when using this class like MouseSteering. Therefore we hot-fixed
 *  it by implementing the keyboard controls in the {@link GalacticGarbagemenApplication} directly.
 * */
public class KeyboardInput {

    private final SpaceCraft spaceCraft;
    private final int ANGLE_ON_TURN = 3;

    public KeyboardInput(GameBoardUI gameBoardUI, SpaceCraft userSpaceCraft) {
        this.spaceCraft = userSpaceCraft;
        gameBoardUI.addEventHandler(KeyEvent.KEY_PRESSED, this::keyPressed);
    }

    /**
     * Handles keyboard input and manipulates the space craft accordingly with acceleration / deceleration and tilting
     *  operations.
     *
     * @implNote Hot fixed in {@link GalacticGarbagemenApplication}.start() as this method did not recognized the input.
     *
     * TODO: add shooting functionality
     * */
    protected void keyPressed(KeyEvent keyInput) {

        switch (keyInput.getCode()) {
            case W, UP -> {
                spaceCraft.accelerate();
                System.out.println("Up pressed"); // debug
            }
            case S, DOWN -> {
                spaceCraft.decelerate();
                System.out.println("Down pressed"); // debug
            }
            case A, LEFT -> {
                spaceCraft.setDirection(ANGLE_ON_TURN);
                System.out.println("Left pressed"); // debug
            }
            case D, RIGHT -> {
                spaceCraft.setDirection(-ANGLE_ON_TURN);
                System.out.println("Right pressed"); // debug
            }
        }

        System.out.println(keyInput.getCharacter()); // debug
    }

}
