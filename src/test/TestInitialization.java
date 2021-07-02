package test;

import de.tum.in.ase.eist.igt.Controller.Dimension2D;
import de.tum.in.ase.eist.igt.Controller.GameBoard;
import de.tum.in.ase.eist.igt.Model.Debris;
import de.tum.in.ase.eist.igt.Model.GameObject;
import de.tum.in.ase.eist.igt.Model.Planet;
import de.tum.in.ase.eist.igt.Model.SpaceCraft;
import de.tum.in.ase.eist.igt.View.GameBoardUI;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.stream.Collectors;

public class TestInitialization {


    /**
     * Test the initialization of the game board (controller), dont test any javafx related calls, rather verify that
     *  all objects are initialized properly.
     * */
    @Test
    public void testGameInitialization(){

        // initialization of game board
        Dimension2D testDimension2D = GameBoardUI.getPreferredSize();
        GameBoard testGameBoard = new GameBoard(testDimension2D);
        testGameBoard.startGame();

        // test if the game logic is running
        Assertions.assertTrue(testGameBoard.isRunning());

        // check that the game objects list is not empty
        Assertions.assertFalse(testGameBoard.getGameObjects().isEmpty());

        // check that the player spacecraft is initialized
        Assertions.assertNotNull(testGameBoard.getPlayerSpaceCraft());

        // check number of planets
        Assertions.assertEquals(2, testGameBoard.getGameObjects().stream()
                .filter(gameObject -> {
                    return gameObject.getClass() == Planet.class;
                }).collect(Collectors.toSet()).size());

        // test number of debris
        Assertions.assertEquals(GameBoard.NUMBER_OF_DEBRIS, testGameBoard.getGameObjects().stream()
                .filter(gameObject -> {
                    return gameObject.getClass() == Debris.class;
                }).collect(Collectors.toSet()).size());

        // test if debris is moving by counting all stationary debris
        Assertions.assertEquals(0, testGameBoard.getGameObjects().stream().filter(gameObject -> {return gameObject.getClass() == Debris.class;})
                .filter(gameObject -> {return ((Debris) gameObject).getSpeed() <= 0;}).collect(Collectors.toSet()).size());

        // test if spacecraft is standing still at the beginning
        Assertions.assertEquals(0, testGameBoard.getPlayerSpaceCraft().getSpeed());
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

    @Test
    public void testStopGame() {
        GameBoard testGameBoard = new GameBoard(GameBoardUI.getPreferredSize());
        testGameBoard.stopGame();
        Assertions.assertFalse(testGameBoard.isRunning());
    }
}
