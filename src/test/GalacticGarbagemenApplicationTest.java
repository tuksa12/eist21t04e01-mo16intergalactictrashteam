package test;

import de.tum.in.ase.eist.igt.Controller.Point2D;
import de.tum.in.ase.eist.igt.GalacticGarbagemenApplication;
import de.tum.in.ase.eist.igt.Model.GameObject;
import de.tum.in.ase.eist.igt.Model.MovableObject;
import de.tum.in.ase.eist.igt.Model.Shot;
import de.tum.in.ase.eist.igt.Model.StationaryObject;
import javafx.stage.Stage;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.easymock.*;

import static org.easymock.EasyMock.*;

public class GalacticGarbagemenApplicationTest {

    private GalacticGarbagemenApplication app;
    @Mock
    private Shot s;



    @Before
    public void setUp() throws Exception {
        app = new GalacticGarbagemenApplication();
        app.start(new Stage());
        s  = app.getGameBoardUI().getGameBoard().getPlayerSpaceCraft().shoot();
    }

    @Test
    public void stationaryObjectTest() {
        for(GameObject object : app.getGameBoardUI().getGameBoard().getGameObjects()) {
            if(object instanceof StationaryObject) {
                Point2D start = object.getPosition();
                object.setPosition(object.getPosition().getX() + 1, object.getPosition().getY());
                Assert.assertEquals(start.getX(), object.getPosition().getX());
            }
        }
    }

    @Test
    public void movableObjectTest() {
        for(GameObject object : app.getGameBoardUI().getGameBoard().getGameObjects()) {
            if(object instanceof MovableObject) {
                Point2D start = object.getPosition();
                object.setPosition(object.getPosition().getX() + 1, object.getPosition().getY());
                Assert.assertFalse(start.getX() == object.getPosition().getX());
            }
        }
    }

    @Test
    public void testObjectOutOfBounds() {
        /*
        create a new constructor in game board that puts just 1 debris close to the edge and running towards the edge
        when it runs out of bounds, check if it erased
         */
    }

    @Test
    public void spaceCraftAccelerate() {
        int expectedEndSpeed = app.getGameBoardUI().getGameBoard().getPlayerSpaceCraft().getSpeed() + app.getGameBoardUI().getGameBoard().getPlayerSpaceCraft().getAcceleration();
        app.getGameBoardUI().getGameBoard().getPlayerSpaceCraft().accelerate();
        int actualEndSpeed = app.getGameBoardUI().getGameBoard().getPlayerSpaceCraft().getSpeed();
        Assert.assertEquals(expectedEndSpeed, actualEndSpeed);
    }

    @Test
    public void spaceCraftDecelerate() {
        int expectedEndSpeed = Math.max(0, app.getGameBoardUI().getGameBoard().getPlayerSpaceCraft().getSpeed() - app.getGameBoardUI().getGameBoard().getPlayerSpaceCraft().getAcceleration());
        app.getGameBoardUI().getGameBoard().getPlayerSpaceCraft().decelerate();
        int actualEndSpeed = app.getGameBoardUI().getGameBoard().getPlayerSpaceCraft().getSpeed();
        Assert.assertEquals(expectedEndSpeed, actualEndSpeed);
    }

    @Test
    public void mockShotTest() {
        expect(s.increaseSpeed()).andReturn(true);
        replay(s);
        boolean actual = s.increaseSpeed();
        Assert.assertTrue(actual);
    }
}