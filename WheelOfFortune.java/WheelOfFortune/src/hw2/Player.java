package hw2;


/**
 * This class encapsulates information about a player for a game in which money is won in
 * multiple rounds. A player has a round balance, which represent potential winnings for the
 * current round, and a game balance, which is the total winnings for all rounds. When a player
 * wins a round, the round balance is transferred to the game balance. When a player loses in
 * a round, the round balance is set to zero but the game balance is kept.
 *
 * @author Jon Beltzhoover
 */
public class Player {
    /**
     * Holds the player's total balance.
     */
    private int gameBalance;
    /**
     * Name of the player;
     */
    private final String name;
    /**
     * Holds the player's round balance.
     */
    private int roundBalance;


    /**
     * Constructs a new player with a name. Sets total balance and round balance to 0.
     *
     * @param givenName - a string input of the given name
     */
    public Player(String givenName) {
        this.name = givenName;
        this.gameBalance = 0;
        this.roundBalance = 0;
    }


    /**
     * Resets the player round balance in preparation for the next round.
     */
    public void clearRoundBalance() {
        roundBalance = 0;
    }

    /**
     * Returns the current player balance.
     *
     * @return - the game balance
     */
    public int getGameBalance() {
        return gameBalance;
    }

    /**
     * Returns the player's name.
     *
     * @return - the player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the current player round balance before round balance is reset.
     *
     * @return - the round balance
     */
    public int getRoundBalance() {
        return roundBalance;
    }

    /**
     * Updates the player's round balance by the given amount.
     *
     * @param amount - amount the round balance is updated by
     */
    public void updateRoundBalance(int amount) {
        roundBalance = roundBalance + amount;
    }

    /**
     * Adds round balance to the player's total balance.
     */
    public void winRound() {
        gameBalance = gameBalance + roundBalance;
    }


}
