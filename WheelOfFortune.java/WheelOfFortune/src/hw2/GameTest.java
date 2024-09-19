package hw2;

public class GameTest {

    public static void main(String[] args) {

        String p1 = "Jon";
        String p2 = "Lily";
        String p3 = "Mohammad";

        String[] allPlayers = {p1, p2, p3};
        HiddenText secretPhrase = new HiddenText("Java is fun");

        Game test = new Game(allPlayers);

        System.out.println("");

        System.out.println(test.getNumPlayers());
        System.out.println("Expected number of players: 3");

        System.out.println("");

        System.out.println(test.getPlayerName(0));
        System.out.println("Expected name: Jon");

        System.out.println("");

        System.out.println(test.getPlayerName(1));
        System.out.println("Expected name: Lily");

        System.out.println("");

        System.out.println(test.getPlayerName(2));
        System.out.println("Expected name: Mohammad");

        System.out.println("");

        test.startRound(0, secretPhrase);

        System.out.println(test.getRoundBalance(0));
        System.out.println("Expected round balance for Jon: 0");

        System.out.println("");

        System.out.println(test.getRoundBalance(1));
        System.out.println("Expected round balance for Lily: 0");

        System.out.println("");

        System.out.println(test.getRoundBalance(2));
        System.out.println("Expected round balance for Mohammad: 0");

        System.out.println("");

        System.out.println(test.getGameBalance(0));
        System.out.println("Expected game balance for Jon: 0");

        System.out.println("");

        System.out.println(test.getGameBalance(1));
        System.out.println("Expected game balance for Lily: 0");

        System.out.println("");

        System.out.println(test.getGameBalance(2));
        System.out.println("Expected game balance for Mohammad: 0");

        System.out.println("");

        System.out.println(test.whoseTurn());
        System.out.println("Expected Player[] index: 0");

        System.out.println("");

        System.out.println(test.needsASpin());
        System.out.println("Expected needs a spin: true");

        System.out.println("");

        System.out.println(test.isRoundOver());
        System.out.println("Expected round not over: false");

        System.out.println("");

        System.out.println(test.getCurrentPlayerName());
        System.out.println("Expected name is: Jon");

        System.out.println("");

        System.out.println(test.canBuyVowel());
        System.out.println("Expected can buy vowel: false");

        System.out.println("");

        System.out.println(test.getWheelRotation());
        System.out.println("Expected wheel rotation: 359");

        System.out.println("");

        System.out.println(test.getWheelValue());
        System.out.println("Expected wheel value: 5000");

        System.out.println("");

        test.testSpinWheel(120);

        System.out.println(test.getWheelRotation());
        System.out.println("Expected wheel rotation: 239");

        System.out.println("");

        System.out.println(test.getWheelValue());
        System.out.println("Expected wheel value: 700");

        System.out.println("");

        System.out.println(test.guessConsonant('s'));
        System.out.println("Expected number of 's': 1");

        System.out.println("");

        System.out.println(test.getRoundBalance(0));
        System.out.println("Expected round balance for Jon: 700");

        System.out.println("");

        System.out.println(test.getDisplay());
        System.out.println("Expected display: **** *S ***");

        System.out.println("");

        System.out.println(test.needsASpin());
        System.out.println("Expected needs a spin: true");

        System.out.println("");

        test.testSpinWheel(182);

        System.out.println(test.getWheelRotation());
        System.out.println("Expected wheel rotation: 57");

        System.out.println("");

        System.out.println(test.getWheelValue());
        System.out.println("Expected wheel value: 300");

        System.out.println("");

        System.out.println(test.guessConsonant('b'));
        System.out.println("Expected number of 'b': 0");

        System.out.println("");

        System.out.println(test.getDisplay());
        System.out.println("Expected display: **** *S ***");

        System.out.println("");

        System.out.println(test.whoseTurn());
        System.out.println("Expected Player[] index: 1");

        System.out.println("");

        test.testSpinWheel(89);

        System.out.println(test.getWheelRotation());
        System.out.println("Expected wheel rotation: 328");

        System.out.println("");

        System.out.println(test.getWheelValue());
        System.out.println("Expected wheel value: 300");

        System.out.println("");

        System.out.println(test.guessConsonant('j'));
        System.out.println("Expected number of 'j': 1");

        System.out.println("");

        System.out.println(test.getRoundBalance(1));
        System.out.println("Expected round balance for Lily: 300");

        System.out.println("");

        System.out.println(test.getDisplay());
        System.out.println("Expected display: J*** *S ***");

        System.out.println("");

        test.testSpinWheel(143);

        System.out.println(test.getWheelRotation());
        System.out.println("Expected wheel rotation: 185");

        System.out.println("");

        System.out.println(test.getWheelValue());
        System.out.println("Expected wheel value: -1 (BANKRUPT)");

        System.out.println("");

        System.out.println(test.getRoundBalance(1));
        System.out.println("Expected round balance for Lily: 0");

        System.out.println("");

        System.out.println(test.whoseTurn());
        System.out.println("Expected Player[] index: 2");

        System.out.println("");

        System.out.println(test.getCurrentPlayerName());
        System.out.println("Expected current player: Mohammad");

        System.out.println("");

        test.testSpinWheel(295);

        System.out.println(test.getWheelRotation());
        System.out.println("Expected wheel rotation: 250");

        System.out.println("");

        System.out.println(test.getWheelValue());
        System.out.println("Expected: 1 (LOSE_A_TURN)");

        System.out.println("");

        System.out.println(test.whoseTurn());
        System.out.println("Expected Player[] index: 0");

        System.out.println("");

        System.out.println(test.needsASpin());
        System.out.println("Expected needs a spin: true");

        test.testSpinWheel(251);

        System.out.println("");

        System.out.println(test.getWheelRotation());
        System.out.println("Expected wheel rotation: 359");

        System.out.println("");

        System.out.println(test.getWheelValue());
        System.out.println("Expected wheel value: 5000");

        System.out.println("");

        System.out.println(test.getRoundBalance(0));
        System.out.println("Expected round balance for Jon: 700");

        System.out.println("");

        System.out.println(test.getDisplay());
        System.out.println("Expected display: J*** *S ***");

        System.out.println("");

        System.out.println(test.canBuyVowel());
        System.out.println("Expected buy vowel: true");

        System.out.println("");

        System.out.println(test.buyVowel('a'));
        System.out.println("Expected number of 'a': 2");

        System.out.println("");

        System.out.println(test.getDisplay());
        System.out.println("Expected display: JA*A *S ***");

        System.out.println("");

        System.out.println(test.getRoundBalance(0));
        System.out.println("Expected round balance: 450");

        System.out.println("");

        System.out.println(test.guessPhrase("Java is fun"));
        System.out.println("Expected correct guess: true");

        System.out.println("");

        System.out.println(test.getRoundBalance(0));
        System.out.println("Expected round balance for Jon: 15450");

        System.out.println("");

        System.out.println(test.getDisplay());
        System.out.println("Expected display: JAVA IS FUN");

        System.out.println("");

        System.out.println(test.isRoundOver());
        System.out.println("Expected over: true");

        System.out.println("");

        System.out.println(test.needsASpin());
        System.out.println("Expected needs a spin: false");

        System.out.println("");

        System.out.println(test.getGameBalance(0));
        System.out.println("Expected game balance for Jon: 15450");

        System.out.println("");

        System.out.println(test.getGameBalance(1));
        System.out.println("Expected game balance for Lily: 0");

        System.out.println("");

        System.out.println(test.getGameBalance(2));
        System.out.println("Expected game balance for Mohammad: 0");

        System.out.println("");

        System.out.println("The winner is: Jon");

    }
}
