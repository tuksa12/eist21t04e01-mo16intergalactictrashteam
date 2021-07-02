package test;

import de.tum.in.ase.eist.igt.Controller.KeyboardInput;
import de.tum.in.ase.eist.igt.Model.SpaceCraft;
import de.tum.in.ase.eist.igt.View.GameBoardUI;
import de.tum.in.ase.eist.igt.View.GameToolBar;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import org.easymock.Mock;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestInput {

    @Mock
    KeyEvent event;


    /*@Test
    public void testKeyInput() {
        SpaceCraft testSpaceCraft = new SpaceCraft();
        KeyboardInput keyboardInput = new KeyboardInput(new Scene(), new GameBoardUI(new GameToolBar()),testSpaceCraft);
        keyboardInput.keyPressed(event);
        Assertions.assertNotNull(event);
    }*/
}
