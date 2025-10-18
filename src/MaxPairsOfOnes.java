import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxPairsOfOnes {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1};

        int highestConsecutivePairs = maxConsecutivePairs(arr);

        System.out.println("Highest consecutive pairs of 1's: " + highestConsecutivePairs);
    }




    public static int maxConsecutivePairs(int[] arr) {
        int maxConsecutivePairs = 0;
        int count = 0;

        // Iterate through the array to count consecutive 1's

        for (int num : arr) {
            if (num == 1) {
                count++;  // Increment count when encountering a 1
            } else {
                // If count > 1, calculate pairs from the consecutive 1's
                if (count > 1) {
                    maxConsecutivePairs = Math.max(maxConsecutivePairs, count / 2);
                }
                count = 0;  // Reset count when a 0 is encountered
            }
        }

        // Check for the last part of the array if it ends with consecutive 1's
        if (count > 1) {
            maxConsecutivePairs = Math.max(maxConsecutivePairs, count / 2);
        }

        return maxConsecutivePairs;
    }
}

