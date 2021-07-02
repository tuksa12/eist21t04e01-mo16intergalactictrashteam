package test;

import de.tum.in.ase.eist.igt.Controller.GameBoard;
import de.tum.in.ase.eist.igt.View.GameBoardUI;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestStartStop {

    @Test
    public void testStartGame() {
        GameBoard testGameBoard = new GameBoard(GameBoardUI.getPreferredSize());
        testGameBoard.startGame();
        Assertions.assertTrue(testGameBoard.isRunning());
    }

    @Test
    public void testStopGame() {
        GameBoard testGameBoard = new GameBoard(GameBoardUI.getPreferredSize());
        testGameBoard.stopGame();
        Assertions.assertFalse(testGameBoard.isRunning());
    }
}
