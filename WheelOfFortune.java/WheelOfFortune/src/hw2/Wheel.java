package hw2;

import java.util.Random;
/**
 * This class encapsulates information about the state of the wheel for a wheel of
 * fortune game. The state of the wheel is represented by its counterclockwise rotation
 * in degrees. The wheel represented by this class has 24 segments each covering 15
 * degrees of rotation. The value associated with each segment is fixed and is given by
 * an internal ARRAY of values (WHEEL_SEGMENTS).
 *
 * @author Jon Beltzhoover
 */
public class Wheel {
    /**
     * Represents "bankrupt" on the wheel.
     */
    private static final int BANKRUPT = -1;
    /**
     * Represents "free play" on the wheel.
     */
    private static final int FREE_PLAY = 0;
    /**
     * Represents "lose a turn" on the wheel.
     */
    private static final int LOSE_A_TURN = 1;
    /**
     * Random object used to randomly spin the wheel.
     */
    private Random rand;
    /**
     * Variable that holds the current degree of rotation of the wheel.
     */
    private int rotation;
    /**
     * Holds each value possible on the wheel.
     */
    private static final int[] SEGMENT_VALUES = new int[]{5000, BANKRUPT, 300, 500, 450, 500, 800, LOSE_A_TURN, 700, FREE_PLAY, 650, BANKRUPT, 900, 500, 350, 600, 500, 400, 550, 800, 300, 700, 900, 500};


    /**
     * Creates the game wheel, which will hold an initial rotation of 359 degrees.
     */
    public Wheel() {
        this.rotation = 359;
        rand = new Random(1000);
    }


    /**
     * Returns the wheel's current rotation
     *
     * @return - rotation
     */
    public int getRotation() {
        return rotation;
    }

    /**
     * Returns the current segment of the wheel.
     *
     * @return - value at index
     */
    public int getSegmentValue() {
        int indexValue = (360 - rotation) / 15;

        return SEGMENT_VALUES[indexValue];
    }

    /**
     * Randomly spins the wheel.
     */
    public void spin() {
        int degreesSpun = rand.nextInt(360);
        int degreesOverMax;

        rotation = rotation + degreesSpun;
        degreesOverMax = rotation - 360;

        if (rotation > 360) {
            rotation = 0;
            rotation = rotation + degreesOverMax;
        }
    }

    /**
     * THIS METHOD IS PURELY FOR TESTING.
     *
     * @param degreesSpun - the degrees spun on the wheel.
     */
    public void testSpin(int degreesSpun) {
        rotation = rotation - degreesSpun;

        if (rotation < 0) {
            int holdNegativeDegrees = rotation;
            rotation = 360;

            rotation = rotation + holdNegativeDegrees;
        }
    }


}
