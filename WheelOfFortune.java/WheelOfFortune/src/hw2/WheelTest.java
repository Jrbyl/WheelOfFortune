package hw2;

public class WheelTest {

    public static void main(String[] args) {

        Wheel test = new Wheel();

        System.out.println("");

        System.out.println("0: FREE_PLAY, -1: BANKRUPT, 1: LOSE_A_TURN. Any other value is the dollar amount spun.");

        System.out.println("");

        System.out.println(test.getRotation());
        System.out.println("Expected: 359");

        System.out.println("");

        System.out.println(test.getSegmentValue());
        System.out.println("Expected: 5000");

        System.out.println("");

        test.testSpin(120);

        System.out.println(test.getRotation());
        System.out.println("Expected: 239");

        System.out.println("");

        System.out.println(test.getSegmentValue());
        System.out.println("Expected: 700");

        System.out.println("");

        test.testSpin(182);

        System.out.println(test.getRotation());
        System.out.println("Expected: 57");

        System.out.println("");

        System.out.println(test.getSegmentValue());
        System.out.println("Expected: 300");

        System.out.println("");

        test.testSpin(89);

        System.out.println(test.getRotation());
        System.out.println("Expected: 328");

        System.out.println("");

        System.out.println(test.getSegmentValue());
        System.out.println("Expected: 300");

        System.out.println("");

        test.testSpin(143);

        System.out.println(test.getRotation());
        System.out.println("Expected: 185");

        System.out.println("");

        System.out.println(test.getSegmentValue());
        System.out.println("Expected: -1 (BANKRUPT)");

        System.out.println("");

        test.testSpin(295);

        System.out.println(test.getRotation());
        System.out.println("Expected: 250");

        System.out.println("");

        System.out.println(test.getSegmentValue());
        System.out.println("Expected: 1 (LOSE_A_TURN)");

        System.out.println("");

    }
}
