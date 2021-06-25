package test.java;

import de.tum.in.ase.eist.igt.Controller.Dimension2D;
import de.tum.in.ase.eist.igt.Controller.GameBoard;
import de.tum.in.ase.eist.igt.View.GameBoardUI;
import org.junit.Test;

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

        // TODO: test number of object, initial speed in allowed bounds

    }
}
