package test.java;

import de.tum.in.ase.eist.igt.Controller.Dimension2D;
import de.tum.in.ase.eist.igt.Controller.GameBoard;
import de.tum.in.ase.eist.igt.GalacticGarbagemen;
import de.tum.in.ase.eist.igt.GalacticGarbagemenApplication;
import de.tum.in.ase.eist.igt.Model.Debris;
import de.tum.in.ase.eist.igt.Model.GameObject;
import de.tum.in.ase.eist.igt.Model.Planet;
import de.tum.in.ase.eist.igt.Model.SpaceCraft;
import de.tum.in.ase.eist.igt.View.GameBoardUI;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestInitialization {


    /**
     * Test the initialization of the game board (controller), dont test any javafx related calls, rather verify that
     *  all objects are initialized properly.
     * */
    @Test
    public void testGameInitialization() {

        // initialization of game board
        Dimension2D testDimension2D = GameBoardUI.getPreferredSize();
        GameBoard testGameBoard = new GameBoard(testDimension2D);
        testGameBoard.startGame();
        Assertions.assertTrue(testGameBoard.isRunning());

        // TODO: test number of object, initial speed in allowed bounds

    }

    @Test
    public void testPlanetInitialization() {
        Planet testPlanet = new Planet(1,1,10,10,10,"earth.png");
        Assertions.assertNotNull(testPlanet);
    }

    @Test
    public void testSpaceCraftInitialization() {
        SpaceCraft testSpaceCraft = new SpaceCraft();
        Assertions.assertNotNull(testSpaceCraft);
    }

    @Test
    public void testDebrisInitialization() {
        Debris testDebris = new Debris(1,1,10,1,1);
        Assertions.assertNotNull(testDebris);
    }

}
