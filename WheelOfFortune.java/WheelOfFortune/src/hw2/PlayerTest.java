package hw2;

public class PlayerTest {

    public static void main(String[] args) {

        Player player = new Player("Jon");

        System.out.println("");

        System.out.println(player.getName());
        System.out.println("Expected: Jon");

        System.out.println("");

        System.out.println(player.getGameBalance());
        System.out.println("Expected: 0");

        System.out.println("");

        System.out.println(player.getRoundBalance());
        System.out.println("Expected: 0");

        System.out.println("");

        player.updateRoundBalance(300);

        System.out.println(player.getRoundBalance());
        System.out.println("Expected: 300");

        System.out.println("");

        player.updateRoundBalance(550);

        System.out.println(player.getRoundBalance());
        System.out.println("Expected: 850");

        System.out.println("");

        player.winRound();

        System.out.println(player.getGameBalance());
        System.out.println("Expected: 850");

        System.out.println("");

        player.clearRoundBalance();

        System.out.println(player.getRoundBalance());
        System.out.println("Expected: 0");

        System.out.println("");


        Player player2 = new Player("Lily");

        System.out.println("");

        System.out.println(player2.getName());
        System.out.println("Expected: Lily");

        System.out.println("");

        System.out.println(player2.getGameBalance());
        System.out.println("Expected: 0");

        System.out.println("");

        System.out.println(player2.getRoundBalance());
        System.out.println("Expected: 0");

        System.out.println("");

        player2.updateRoundBalance(900);

        System.out.println(player2.getRoundBalance());
        System.out.println("Expected: 900");

        System.out.println("");

        player2.updateRoundBalance(650);

        System.out.println(player2.getRoundBalance());
        System.out.println("Expected: 1550");

        System.out.println("");

        player2.winRound();

        System.out.println(player2.getGameBalance());
        System.out.println("Expected: 1550");

        System.out.println("");

        player2.clearRoundBalance();

        System.out.println(player2.getRoundBalance());
        System.out.println("Expected: 0");

        System.out.println("");

    }
}
