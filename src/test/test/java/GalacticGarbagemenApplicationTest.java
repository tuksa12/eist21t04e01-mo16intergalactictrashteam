package test.java;

import de.tum.in.ase.eist.igt.Controller.Point2D;
import de.tum.in.ase.eist.igt.GalacticGarbagemenApplication;
import de.tum.in.ase.eist.igt.Model.GameObject;
import de.tum.in.ase.eist.igt.Model.MovableObject;
import de.tum.in.ase.eist.igt.Model.StationaryObject;
import javafx.stage.Stage;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class GalacticGarbagemenApplicationTest extends TestCase {

    private GalacticGarbagemenApplication app;



    @Before
    public void setUp() throws Exception {
        super.setUp();
        app = new GalacticGarbagemenApplication();
        app.start(new Stage());
    }

    @Test
    public void stationaryObjectTest() {
        for(GameObject object : app.getGameBoardUI().getGameBoard().getGameObjects()) {
            if(object instanceof StationaryObject) {
                Point2D start = object.getPosition();
                object.setPosition(object.getPosition().getX() + 1, object.getPosition().getY());
                assertEquals(start.getX(), object.getPosition().getX());
            }
        }
    }

    @Test
    public void movableObjectTest() {
        for(GameObject object : app.getGameBoardUI().getGameBoard().getGameObjects()) {
            if(object instanceof MovableObject) {
                Point2D start = object.getPosition();
                object.setPosition(object.getPosition().getX() + 1, object.getPosition().getY());
                assertFalse(start.getX() == object.getPosition().getX());
            }
        }
    }

    @Test
    public void testObjectOutOfBounds() {

    }

    @Test
    public void spaceCraftAccelerate() {
        int expectedEndSpeed = app.getGameBoardUI().getGameBoard().getPlayerSpaceCraft().getSpeed() + app.getGameBoardUI().getGameBoard().getPlayerSpaceCraft().getAcceleration();
        app.getGameBoardUI().getGameBoard().getPlayerSpaceCraft().accelerate();
        int actualEndSpeed = app.getGameBoardUI().getGameBoard().getPlayerSpaceCraft().getSpeed();
        assertEquals(expectedEndSpeed, actualEndSpeed);
    }

    @Test
    public void spaceCraftDecelerate() {
        int expectedEndSpeed = Math.max(0, app.getGameBoardUI().getGameBoard().getPlayerSpaceCraft().getSpeed() - app.getGameBoardUI().getGameBoard().getPlayerSpaceCraft().getAcceleration());
        app.getGameBoardUI().getGameBoard().getPlayerSpaceCraft().decelerate();
        int actualEndSpeed = app.getGameBoardUI().getGameBoard().getPlayerSpaceCraft().getSpeed();
        assertEquals(expectedEndSpeed, actualEndSpeed);
    }

    @Test
    public void mockShot() {

    }
}