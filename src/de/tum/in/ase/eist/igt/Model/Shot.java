package de.tum.in.ase.eist.igt.Model;

public class Shot extends MovableObject {

    private static final String SHOT_IMAGE_FILE = "Lazer.png";

    private static final int SHOT_HEIGHT = 25;
    private static final int SHOT_WIDTH = 25;
    private static final int INITIAL_SPEED = 50;
    private static final int ACCELERATION = 0;

    public Shot(double startX, double startY, int direction) {
        super(startX, startY, 0, SHOT_WIDTH, SHOT_HEIGHT, SHOT_IMAGE_FILE, INITIAL_SPEED, ACCELERATION, direction);
    }

    public boolean increaseSpeed() {
        return false;
    }
}

