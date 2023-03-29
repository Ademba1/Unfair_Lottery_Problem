import java.util.*;

public class UnfairLottery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input
        System.out.print("Enter the values of this week's prizes (comma-separated): ");
        String[] valuesStr = scanner.nextLine().split(",");
        int[] values = new int[valuesStr.length];
        for (int i = 0; i < valuesStr.length; i++) {
            values[i] = Integer.parseInt(valuesStr[i]);
        }
        System.out.print("Enter the names of this week's winners (comma-separated): ");
        String[] winners = scanner.nextLine().split(",");

        // Sort values in descending order
        Arrays.sort(values);
        reverse(values);

        // Create map to store each winner's prizes
        Map<String, List<Integer>> prizeMap = new HashMap<>();
        for (String winner : winners) {
            prizeMap.put(winner, new ArrayList<>());
        }

        // Distribute prizes
        for (int i = 0; i < values.length; i++) {
            String winner = getWinnerWithLowestPrize(prizeMap);
            prizeMap.get(winner).add(values[i]);
        }

        // Print results
        for (String winner : prizeMap.keySet()) {
            List<Integer> prizes = prizeMap.get(winner);
            System.out.print(winner + ":");
            for (int i = 0; i < prizes.size(); i++) {
                System.out.print(prizes.get(i));
                if (i < prizes.size() - 1) {
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }

    // Utility method to reverse an array
    private static void reverse(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    // Utility method to get the winner with the lowest total prize
    private static String getWinnerWithLowestPrize(Map<String, List<Integer>> prizeMap) {
        String winner = null;
        int lowestTotal = Integer.MAX_VALUE;
        for (String key : prizeMap.keySet()) {
            List<Integer> prizes = prizeMap.get(key);
            int total = 0;
            for (int prize : prizes) {
                total += prize;
            }
            if (total < lowestTotal) {
                winner = key;
                lowestTotal = total;
            }
        }
        
        return winner;
    }
}
