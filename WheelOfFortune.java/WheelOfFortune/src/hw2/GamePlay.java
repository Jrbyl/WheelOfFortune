package hw2;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * Text-based user interface for the Wheel Of Fortune Game
 *
 * @author Jon Beltzhoover
 */
public class GamePlay {
    /**
     * Game object that represents the Game class
     */
    private Game game;
    /**
     * Random object that will randomize wheel spins and phrase picked
     */
    private Random rand;
    /**
     * Scanner object to read inputs from the user
     */
    private Scanner scanner;
    /**
     * Holds y/n depending on if the user wants to continue playing
     */
    private char playAgain;
    /**
     * Determines if the game has ended
     */
    private boolean isGameOver;
    /**
     * Holds the current wheel value
     */
    private int wheelValue;


    /**
     * Constructs the random and scanner assets for the Wheel of Fortune interface
     */
    public GamePlay() {
        this.rand = new Random(1000);
        this.scanner = new Scanner(System.in);

        String p1 = "Jon";
        String p2 = "Lily";
        String p3 = "Mohammad";

        String[] allPlayers = {p1, p2, p3};
        this.game = new Game(allPlayers);

        this.playAgain = 'y';
        this.isGameOver = false;
    }


    /**
     * Entry point of the game
     *
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("-----------------------");
        System.out.println("CS 227 WHEEL OF FORTUNE");
        System.out.println("-----------------------");

        GamePlay gamePlay = new GamePlay();
        gamePlay.play("phrases.txt");

        while (gamePlay.playAgain == 'y') {
            if (gamePlay.isGameOver == true) {
                gamePlay.isGameOver = false;
                gamePlay.play("phrases.txt");
            }
            gamePlay.printCurrentRoundStatus();
            gamePlay.menu();
        }

    }


    /**
     * Starts the game and sets the turn to player index 0
     *
     * @param fileName - the name of the file
     * @throws FileNotFoundException
     */
    public void play(String fileName) throws FileNotFoundException {
        PhraseList phraseList = new PhraseList(fileName);

        int index = rand.nextInt(phraseList.getSize());
        String randomPhrase = phraseList.getPhrase(index);

        HiddenText secretPhrase = new HiddenText(randomPhrase);
        game.startRound(0, secretPhrase);
    }

    /**
     * Displays current player balances, hidden phrase, current player name
     */
    private void printCurrentRoundStatus() {

        int numPlayers = game.getNumPlayers();

        for (int i = 0; i < numPlayers; i++) {
            System.out.println(game.getPlayerName(i) + ": " + game.getRoundBalance(i));
        }
        System.out.println();

        System.out.println("CURRENT DISPLAY: " + game.getDisplay());
        System.out.println();
    }

    /**
     * Displays game totals for each player
     */
    private void printFinalGameStatus() {
        System.out.println();
        System.out.println("That ends this round: ");

        int numPlayers = game.getNumPlayers();

        for (int i = 0; i < numPlayers; i++) {
            System.out.println(game.getPlayerName(i) + " total winnings: " + game.getGameBalance(i));
        }
        System.out.println();

        isGameOver = true;

        System.out.print("Play again (y/n)? ");
        playAgain = scanner.next().charAt(0);
        scanner.nextLine();

        if (playAgain == 'y') {
            System.out.println("Have fun!");
            playAgain = 'y';
        }
        else if (playAgain == 'n') {
            System.out.println("Goodbye!");
            playAgain = 'n';
        }

    }

    /**
     * Displays the choices in the game for the user
     */
    private void menu() {
        System.out.println("IT IS " + game.getCurrentPlayerName() + "'s TURN TO SPIN THE WHEEL.");
        System.out.print("--> " + game.getCurrentPlayerName() + "! PLEASE PRESS ENTER TO SPIN THE WHEEL!");

        String input = scanner.nextLine();

        spin();

        boolean canBuyVowel = game.canBuyVowel();

        if (wheelValue != -1 && wheelValue != 1) {
            System.out.println("  a) solve the puzzle");
            if (canBuyVowel == true) {
                System.out.println("  b) buy a vowel");
            }
            System.out.println("  c) guess a consonant");
            System.out.print("Enter your choice: ");

            char choice = '_';

            if (canBuyVowel == true) {
                while (choice != 'a' && choice != 'b' && choice != 'c') {
                    choice = scanner.next().charAt(0);
                    scanner.nextLine();

                    if (choice == 'a') {
                        doGuessPhrase();
                    } else if (choice == 'b') {
                        doGuessLetter(true);
                    } else if (choice == 'c') {
                        doGuessLetter(false);
                    } else {
                        System.out.println("Please enter a, b, or c");
                        choice = '_';
                    }
                }
            } else {
                while (choice != 'a' && choice != 'c') {
                    choice = scanner.next().charAt(0);
                    scanner.nextLine();

                    if (choice == 'a') {
                        doGuessPhrase();
                    } else if (choice == 'c') {
                        doGuessLetter(false);
                    } else {
                        System.out.println("Please enter a or c");
                        choice = '_';
                    }
                }
            }
        }

    }

    /**
     * Spins the wheel then displays the result
     */
    private void spin() {
        String bankrupt;
        String loseATurn;

        game.spinWheel();

        wheelValue = game.getWheelValue();
        if (wheelValue == -1) {
            bankrupt = "BANKRUPT!";
            System.out.println("You spun: " + bankrupt + " (" + game.getWheelRotation() + " degrees)");
        }
        else if (wheelValue == 1) {
            loseATurn = "LOSE A TURN!";
            System.out.println("You spun: " + loseATurn + " (" + game.getWheelRotation() + " degrees)");
        }
        else {
            System.out.println("You spun: $" + wheelValue + " (" + game.getWheelRotation() + " degrees)");
        }
    }

    /**
     * Lets the user guess either a vowel or consonant
     *
     * @param buyingAVowel - true if the user is buying a vowel, false otherwise
     */
    private void doGuessLetter(boolean buyingAVowel) {
        if (buyingAVowel == true) {
            System.out.print("Enter a vowel: ");
            char choice = scanner.next().charAt(0);
            scanner.nextLine();

            System.out.println("---------------------------------------------");
            System.out.println("---------------------------------------------");

            boolean vowel = isVowel(choice);

            while (vowel == false) {
                System.out.println("Please enter a, e, i, o, or u");
                choice = scanner.next().charAt(0);
                scanner.nextLine();
                vowel = isVowel(choice);
            }

            if (vowel == true) {
                System.out.println("--> YOU (" + game.getCurrentPlayerName() + ") ENTERED: " + choice);
                System.out.println();

                int vowelsRevealed = game.buyVowel(choice);
                char outputChoice = Character.toUpperCase(choice);
                System.out.println("--> There were " + vowelsRevealed + " " + outputChoice + "'s hidden!");
                System.out.println();
            }
        }
        else {
            System.out.print("Enter a consonant: ");
            char choice = scanner.next().charAt(0);
            scanner.nextLine();

            System.out.println("---------------------------------------------");
            System.out.println("---------------------------------------------");

            boolean consonant = isConsonant(choice);

            while (consonant == false) {
                System.out.println("Please enter a consonant");
                choice = scanner.next().charAt(0);
                scanner.nextLine();
                consonant = isConsonant(choice);
            }

            if (consonant == true) {
                System.out.println("--> YOU (" + game.getCurrentPlayerName() + ") ENTERED: " + choice);
                System.out.println();

                int consonantsRevealed = game.guessConsonant(choice);
                char outputChoice = Character.toUpperCase(choice);
                System.out.println("--> There were " + consonantsRevealed + " " + outputChoice + "'s hidden!");
                System.out.println();
            }
        }
    }

    /**
     * Lets the user guess the phrase
     */
    private void doGuessPhrase() {
        System.out.print("Enter a phrase: ");
        String input = scanner.nextLine();

        System.out.println("---------------------------------------------");
        System.out.println("---------------------------------------------");

        boolean isCorrect = game.guessPhrase(input);

        if (isCorrect == true) {
            System.out.println("--> That's it!");
            printFinalGameStatus();
        }
        else {
            System.out.println("--> That's incorrect!");
        }

    }

    /**
     * Checks the parameter and returns true if it's a vowel, false otherwise
     *
     * @param ch - character input
     * @return - true if ch is a vowel, false otherwise
     */
    private boolean isVowel(char ch) {
        char vowel = Character.toUpperCase(ch);

        if (vowel == 'A' || vowel == 'E' || vowel == 'I' || vowel == 'O' || vowel == 'U') {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Checks the parameter and returns true if it's a consonant, false otherwise
     *
     * @param ch - character input
     * @return - true if ch is a vowel, false otherwise
     */
    private boolean isConsonant(char ch) {
        char cons = Character.toUpperCase(ch);

        if (cons != 'A' && cons != 'E' && cons != 'I' && cons != 'O' && cons != 'U') {
            return true;
        }
        else {
            return false;
        }
    }

}
