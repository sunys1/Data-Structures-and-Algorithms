import java.util.HashMap;
import java.util.Map;
/**
 * The goal of this question is to find the reverse complement of a given DNA sequence.
 *
 * The idea is to build a table to map each DNA symbol with its complement,
 * then reverse the DNA sequence and replace each symbol with its complement.
 *
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class GetReversedComplement {
    public static void main(String[] args){
        String dna = "GTCAG"; // Output: "CTGAC"
        System.out.println(getReversedComplement(dna));
        System.out.println(getReversedComplement2(dna));
    }

    // Solution 1: Use hashmap and StringBuilder
    private static String getReversedComplement(String dna) {
        Map<Character, Character> complements = new HashMap<>();
        // Register the complements
        complements.put('A', 'T');
        complements.put('T', 'A');
        complements.put('C', 'G');
        complements.put('G', 'C');

        // Build the reversed complement string
        StringBuilder reversedComplement = new StringBuilder();

        for(int i = dna.length() - 1; i >= 0; i--){
            reversedComplement.append(complements.get(dna.charAt(i)));
        }

        return reversedComplement.toString();
    }

    // Solution 2: since the table is small, we can use a switch statement
    private static String getReversedComplement2(String dna) {
        // Use char[] instead of dynamic resizing StringBuilder
        char[] reversedComplement = new char[dna.length()];

        for(int i = dna.length() - 1; i >= 0; i--){
            reversedComplement[dna.length() - 1 - i] = getCharComplement(dna.charAt(i));
        }

        return new String(reversedComplement);
    }

    private static char getCharComplement(char symbol){
        switch(symbol){
            case 'A':
                return 'T';
            case 'T':
                return 'A';
            case 'C':
                return 'G';
            case 'G':
                return 'C';
            default :
                throw new IllegalArgumentException("Invalid symbol: " + symbol);
        }
    }
}
