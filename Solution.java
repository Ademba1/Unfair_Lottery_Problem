import java.util.*;

public class LotteryDistribution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the prizes
        System.out.print("Enter the values of this week's prizes (comma-separated): ");
        String[] prizesString = scanner.nextLine().split(",");
        int[] prizes = new int[prizesString.length];
        for (int i = 0; i < prizesString.length; i++) {
            prizes[i] = Integer.parseInt(prizesString[i]);
        }

        // Read the winners
        System.out.print("Enter the names of this week's winners (comma-separated): ");
        String[] winners = scanner.nextLine().split(",");

        // Distribute the prizes
        int totalPrizeValue = 0;
        for (int prize : prizes) {
            totalPrizeValue += prize;
        }
        int prizePerWinner = totalPrizeValue / winners.length;
        int remainingPrizeValue = totalPrizeValue % winners.length;
        Map<String, List<Integer>> winnerToPrizesMap = new HashMap<>();
        for (String winner : winners) {
            winnerToPrizesMap.put(winner, new ArrayList<>());
        }
        for (int i = 0; i < prizes.length; i++) {
            String winner = winners[i % winners.length];
            if (winnerToPrizesMap.get(winner).size() < prizePerWinner) {
                winnerToPrizesMap.get(winner).add(prizes[i]);
            } else {
                winnerToPrizesMap.get(winner).add(prizes[i]);
                remainingPrizeValue -= prizes[i];
                if (remainingPrizeValue < 0) {
                    System.err.println("Error: Negative remaining prize value.");
                    return;
                }
            }
        }

        // Print the prize distribution
        for (String winner : winners) {
            List<Integer> winnerPrizes = winnerToPrizesMap.get(winner);
            System.out.print(winner + ":");
            for (int i = 0; i < winnerPrizes.size(); i++) {
                System.out.print(winnerPrizes.get(i));
                if (i < winnerPrizes.size() - 1) {
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }
}
