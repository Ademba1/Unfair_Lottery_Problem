import java.util.Arrays;
import java.util.Scanner;

public class PrizeDistribution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the values of this week's prizes (comma-separated): ");
        String[] prizesStr = scanner.nextLine().split(",");
        int[] prizes = Arrays.stream(prizesStr).mapToInt(Integer::parseInt).toArray();

        System.out.print("Enter the names of this week's winners (comma-separated): ");
        String[] winners = scanner.nextLine().split(",");

        int totalPrizeValue = Arrays.stream(prizes).sum();
        int numWinners = winners.length;
        int minPrizeValue = totalPrizeValue / numWinners;

        for (int i = 0; i < numWinners; i++) {
            int remainingPrizeValue = totalPrizeValue - (i * minPrizeValue);
            int numRemainingWinners = numWinners - i;
            int fairPrizeValue = remainingPrizeValue / numRemainingWinners;
            System.out.println(winners[i] + " wins " + fairPrizeValue + " Shillings");
        }
    }
}
