package hw2;


/**
 * This class encapsulates all the logic for a multiplayer game of "Wheel of Fortune".
 * Use the startRound() method to start a new round of the game using a new hidden text.
 * An instance of this class can be used for multiple rounds by calling startRound() to
 * initiate a new round, and the total winnings for all rounds are stored internally in
 * the Player objects. Players are indexed starting at zero; when a player loses their turn,
 * the "next" player is the player with the next index. (The index wraps around to zero when
 * the index reaches the number of players, i.e., if there are five players, then player 0 comes
 * after player 4.) Rounds continue until some player guesses the complete phrase.
 *
 * @author Jon Beltzhoover
 */
public class Game {
    /**
     * True if the player still needs to spin, false otherwise.
     */
    private boolean isInNeedOfASpin;
    /**
     * True is the round is over, false otherwise.
     */
    private boolean isRoundOver;
    /**
     * Holds the hidden puzzle.
     */
    private HiddenText phrase;
    /**
     * Holds the players in the game.
     */
    private Player[] players;
    /**
     * Determines the current player's turn. Holds the index of the current player's turn.
     */
    private int turn;
    /**
     * Holds the cost to buy a vowel.
     */
    private static final int VOWEL_COST = 250;
    /**
     * Holds the wheel and all of its segments.
     */
    private Wheel wheel;


    /**
     * Constructs the game with the given player names.
     *
     * @param playerNames - the array of player names
     */
    public Game(String[] playerNames) {
        players = new Player[playerNames.length];
        int i;

        for (i = 0; i < playerNames.length; i++) {
            this.players[i] = new Player(playerNames[i]);
        }

        this.wheel = new Wheel();
    }


    /**
     * Checks if the guessed vowel occurs in the puzzle. Updates phrase then takes the
     * vowel cost from the player's balance.
     *
     * @param ch - a character input
     * @return - number of vowel appearances in the phrase
     */
    public int buyVowel(char ch) {
        char isVowel = Character.toUpperCase(ch);
        boolean vowel;
        boolean buyVowel = canBuyVowel();
        int numVowelsRevealed = 0;

        int beforeVowel = phrase.countHiddenLetters();

        if (isVowel == 'A' || isVowel == 'E' || isVowel == 'I' || isVowel == 'O' || isVowel == 'U') {
            vowel = true;
        }
        else {
            vowel = false;
        }

        if (vowel == true && buyVowel == true) {
            phrase.update(ch);
            players[turn].updateRoundBalance(-VOWEL_COST);

            int afterVowel = phrase.countHiddenLetters();

            if (beforeVowel != afterVowel) {
                numVowelsRevealed = beforeVowel - afterVowel;
            }
            else {
                numVowelsRevealed = beforeVowel - afterVowel;
                if (turn == (players.length) - 1) {
                    turn = 0;
                }
                else {
                    turn++;
                }
            }

        }
        isInNeedOfASpin = true;

        return numVowelsRevealed;
    }

    /**
     * Checks player balance to see if they can buy a vowel.
     *
     * @return - true/false depending on if the player has enough money for a vowel
     */
    public boolean canBuyVowel() {
        if (players[turn].getRoundBalance() >= VOWEL_COST) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Returns the current player's name.
     *
     * @return - the current turn's player
     */
    public String getCurrentPlayerName() {
        return players[turn].getName();
    }

    /**
     * Returns what the current puzzle looks like, including letters and "*."
     *
     * @return - the display of the hidden phrase
     */
    public String getDisplay() {
        return phrase.getDisplayedText();
    }

    /**
     * Returns the current player's total balance.
     *
     * @param player - the index of the player in the player array
     * @return - game balance of the player
     */
    public int getGameBalance(int player) {
        return players[player].getGameBalance();
    }

    /**
     * Returns number of players in the game.
     *
     * @return - number of players in the array
     */
    public int getNumPlayers() {
        int i;
        int numPlayers = 0;

        for (i = 0; i < players.length; i++) {
            numPlayers++;
        }

        return numPlayers;
    }

    /**
     * Returns name of the current player.
     *
     * @param player - the index of the player in the player array
     * @return - player name
     */
    public String getPlayerName(int player) {
        return players[player].getName();
    }

    /**
     * Returns the current player's round balance.
     *
     * @param player - the index of the player in the player array
     * @return - player's round balance
     */
    public int getRoundBalance(int player) {
        return players[player].getRoundBalance();
    }

    /**
     * Returns degrees of the wheel's rotation.
     *
     * @return - current rotation of the wheel in degrees
     */
    public int getWheelRotation() {
        return wheel.getRotation();
    }

    /**
     * Returns the value spun by the wheel.
     *
     * @return - the current segment the wheel is at
     */
    public int getWheelValue() {
        return wheel.getSegmentValue();
    }

    /**
     * Checks if the letter input matches any letters in the puzzle. Updates displayed text
     * and updates player balance.
     *
     * @param ch - a character input
     * @return - how many letters are revealed from the character input in the hidden phrase
     */
    public int guessConsonant(char ch) {
        int valueRolled = getWheelValue();
        int lettersRevealed = 0;
        char isVowel = Character.toUpperCase(ch);
        boolean vowel;
        int beforeGuess = phrase.countHiddenLetters();
        int updatedBalance;

        if (isVowel == 'A' || isVowel == 'E' || isVowel == 'I' || isVowel == 'O' || isVowel == 'U') {
            vowel = true;
        }
        else {
            vowel = false;
        }

        if (vowel == false) {
            phrase.update(ch);
            int afterGuess = phrase.countHiddenLetters();

            if (beforeGuess != afterGuess) {
                lettersRevealed = beforeGuess - afterGuess;

                updatedBalance = valueRolled * lettersRevealed;
                players[turn].updateRoundBalance(updatedBalance);
            }
            else {
                lettersRevealed = beforeGuess - afterGuess;
                if (turn == (players.length) - 1) {
                    turn = 0;
                }
                else {
                    turn++;
                }
            }
        }
        isInNeedOfASpin = true;

        return lettersRevealed;
    }

    /**
     * Checks if the guessed phrase matches the hidden puzzle. True if phrases match, false otherwise.
     *
     * @param guess - a string input
     * @return - true/false depending on if the string guess was correct or not
     */
    public boolean guessPhrase(String guess) {
        int valueRolled = getWheelValue();
        int updatedBalance = 0;
        int hiddenToRevealedConsonants = phrase.countHiddenConsonants();

        boolean guessIsCorrect = phrase.updateString(guess);

        if (guessIsCorrect == true) {
            isRoundOver = true;
            updatedBalance = valueRolled * hiddenToRevealedConsonants;
            players[turn].updateRoundBalance(updatedBalance);
            players[turn].winRound();
            return true;
        }
        else {
            if (turn == (players.length) - 1) {
                turn = 0;
            }
            else {
                turn++;
            }
            isInNeedOfASpin = true;
            return false;
        }
    }

    /**
     * Returns true if the round is over, false otherwise. It is updated in other methods.
     *
     * @return - true/false depending on if the round is over or not
     */
    public boolean isRoundOver() {
        if (isRoundOver == true) {
            isInNeedOfASpin = false;
            return isRoundOver;
        }
        else if (isRoundOver == false) {
            return isRoundOver;
        }
        return false;
    }

    /**
     * Returns true if the player hasn't spun, false otherwise. It is updated in other methods.
     *
     * @return - true/false depending on if the player needs to spin
     */
    public boolean needsASpin() {
        return isInNeedOfASpin;
    }

    /**
     * Spins the wheel.
     */
    public void spinWheel() {
        if (isRoundOver == false) {
            wheel.spin();
            isInNeedOfASpin = false;
            if (wheel.getSegmentValue() == -1) {
                players[turn].clearRoundBalance();

                if (turn == (players.length) - 1) {
                    turn = 0;
                } else {
                    turn++;
                }
                isInNeedOfASpin = true;
            } else if (wheel.getSegmentValue() == 1) {
                if (turn == (players.length) - 1) {
                    turn = 0;
                } else {
                    turn++;
                }
                isInNeedOfASpin = true;
            }
        }
    }

    /**
     * Starts a new round, given the current player and hidden puzzle.
     *
     * @param startingPlayer - the index in the player array of the starting player
     * @param secretPhrase - the secret phrase
     */
    public void startRound(int startingPlayer, HiddenText secretPhrase) {
        phrase = secretPhrase;
        turn = startingPlayer;
        isInNeedOfASpin = true;
        isRoundOver = false;

        for (int i = 0; i < players.length; i++) {
            players[i].clearRoundBalance();
        }
    }

    /**
     * Returns the index of the Player[] array of whose turn it is.
     *
     * @return - the index of the player array of whose turn it is
     */
    public int whoseTurn() {
        return turn;
    }

    /**
     * THIS METHOD IS PURELY FOR TESTING.
     *
     * @param degreesSpun - the degrees spun on the wheel
     */
    public void testSpinWheel(int degreesSpun) {
        if (isRoundOver == false) {
            wheel.testSpin(degreesSpun);
            isInNeedOfASpin = false;
            if (wheel.getSegmentValue() == -1) {
                players[turn].clearRoundBalance();

                if (turn == (players.length) - 1) {
                    turn = 0;
                } else {
                    turn++;
                }
                isInNeedOfASpin = true;
            } else if (wheel.getSegmentValue() == 1) {
                if (turn == (players.length) - 1) {
                    turn = 0;
                } else {
                    turn++;
                }
                isInNeedOfASpin = true;
            }
        }
    }


}
