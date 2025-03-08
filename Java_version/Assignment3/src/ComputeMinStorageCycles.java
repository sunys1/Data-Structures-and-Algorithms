import java.util.*;

/***
 * The goal of this question is to compare the originalStorage sizes
 * and the refactoredStorage sizes, and find the minimum cycle required
 * to archive the files in the order of their original storage sizes
 *
 * Time Compelxity: O(N)
 * Space Complexity: O(N)
 */
class Pair implements Comparable<Pair> {
    int original, refactored;

    public Pair(int original, int refactored) {
        this.original = original;
        this.refactored = refactored;
    }

    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.original, other.original); // Sort by first element
    }
}

public class ComputeMinStorageCycles {
    public static void main(String[] args) {
        // Expected output: 8
        int[] originalStorage1 = {2, 8, 4, 6};
        int[] refactoredStorage1 = {1, 2, 3, 3};


        // Expected output: 1
        int[] originalStorage2 = {1, 9, 2};
        int[] refactoredStorage2 = {1, 1, 1};

        System.out.println(computeMinStorageCycles(originalStorage1, refactoredStorage1));
        System.out.println(computeMinStorageCycles(originalStorage2, refactoredStorage2));
    }

    private static int computeMinStorageCycles(int[] originalStorage, int[] refactoredStorage) {
        // Register the (originalStorage, refactoredStorage) pairs and sort by originalStorage
        List<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < originalStorage.length; i++){
            pairs.add(new Pair(originalStorage[i], refactoredStorage[i]));
        }

        // Sort pairs by originalStorage
        Collections.sort(pairs);
        int minCycle = 0;

        // Compare and register the minCycle at each iteration
        // If the smaller cycle has passed before the corresponding file can be processed,
        // it must be processed in the larger cycle

        for(Pair pair : pairs) {
            int smallerCycle = Math.min(pair.original, pair.refactored);
            int largerCycle = Math.max(pair.original, pair.refactored);

            if (smallerCycle >= minCycle){
                minCycle = smallerCycle;
            }else{
                minCycle = largerCycle;
            }
        }

        return minCycle;
    }
}
