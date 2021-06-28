package de.tum.in.ase.eist.igt.Controller;

import de.tum.in.ase.eist.igt.Model.*;

import java.util.*;

public class GameBoard {

    // core functionality
    private GameOutcome gameOutcome = GameOutcome.OPEN;
    private boolean running;
    private final Dimension2D size;
    private final List<GameObject> gameObjects;
    private final Player player;
    private final Random random;

    // initialisation variables
    private static final int NUMBER_OF_DEBRIS = 5;
    // private static final int NUMBER_OF_PLANETS = 3;
    private static final long RANDOM_SEED = 42;
    private static final int MAX_DEBRIS_MASS = 500;
    private static final int MAX_DEBRIS_SPEED = 2;


    public GameBoard(Dimension2D size) {
        this.size = size;
        this.random = new Random();
        this.random.setSeed(RANDOM_SEED);
        this.gameObjects = new ArrayList<GameObject>();
        SpaceCraft playerCraft = new SpaceCraft(this.size.getWidth() / 2, this.size.getHeight() / 2);
        this.player = new Player(playerCraft);
        this.player.setup();
        createGameObjects();
    }

    /**
     * Create game objects in the model, including all planets, debris and the space craft.
     *
     * */
    private void createGameObjects() {
        // planets
        this.gameObjects.add(new Planet(442.0, 442.0, 42, 260,260,"planet.png"));
        this.gameObjects.add(new Planet(100.0, 78.0, 9000,140,140,"planet-brown.png"));

        // spacecraft
        this.gameObjects.add(this.player.getSpaceCraft());

        // generate debris of semi random size, velocity and start point
        for (int i = 0; i < NUMBER_OF_DEBRIS; i++){
            this.gameObjects.add(new Debris(random.nextInt((int) size.getWidth()), random.nextInt((int) size.getHeight()),
                    random.nextInt(MAX_DEBRIS_MASS), random.nextInt(MAX_DEBRIS_SPEED), random.nextInt(MovableObject.MAX_ANGLE)));
        }
    }

    public Dimension2D getSize() {
        return size;
    }

    public boolean isRunning() {
        return this.running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public GameOutcome getGameOutcome() {
        return gameOutcome;
    }

    public List<GameObject> getGameObjects() {
        return this.gameObjects;
    }

    public SpaceCraft getPlayerSpaceCraft() {
        return this.player.getSpaceCraft();
    }

    public void update() {
        moveGameObjects();
    }

    public void startGame(){
        this.running = true;
    }

    public void stopGame(){
        this.running = false;
    }

    private Collection<Debris> getDebris(){
        HashSet<Debris> debris = new HashSet<>();

        for (GameObject gameObject : this.gameObjects){
            if (gameObject.getClass() == Debris.class) debris.add((Debris) gameObject);
        }

        return debris;
    }


    /**
     * Move game objects and detect collisions.
     *
     * TODO: implement collision detection
     * */
    public void moveGameObjects() {
        // update the positions of the player car and the autonomous cars
        for (Debris debris : this.getDebris()) {

            // move debris
            debris.move(size);

            // remove object if it went off board, meaning it crossed the canvas boundaries
            if (!debris.isOnBoard()) this.getDebris().remove(debris);
        }

        this.player.getSpaceCraft().move(size);

        // collision detection

        // TODO: spacecraft planet
        for (GameObject gameObject : gameObjects){
            if (gameObject == getPlayerSpaceCraft()) continue;

            Collision collision = new Collision(getPlayerSpaceCraft(), gameObject);

            if (collision.isCollision()) {
                gameOutcome = collision.evaluate();
                /*Car loser = collision.evaluateLoser();
                printWinner(winner);
                loserCars.add(loser);

                loser.crunch();

                if(isWinner()){
                    gameOutcome = GameOutcome.WON;
                } else{
                    gameOutcome = GameOutcome.LOST;
                }*/

            }
        }

        // TODO: spacecraft debris

        // TODO: debris planet

        // iterate through all game objects and check for collisions
        for (Debris debris : this.getDebris()) {

            for (GameObject gameObject : gameObjects){
                Collision collision = new Collision(debris, gameObject);
                collision.evaluate();
            }
            // TODO: handle off board?
        }
    }

    public void spacecraftShoot() { gameObjects.add(getPlayerSpaceCraft().shoot()); }
}
