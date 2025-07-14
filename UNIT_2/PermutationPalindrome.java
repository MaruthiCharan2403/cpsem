import java.util.*;
public class PermutationPalindrome {
    public static boolean find(String w){
        int b = 0;
        for(char ch:w.toCharArray()){
            b^=(1<<(ch-'a'));
        }
        return (b==0 || (b&(b-1))==0);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String w = s.nextLine();
        System.out.println(find(w));
        s.close();
    }
}


// Steps:
// Initialize an integer variable b = 0. This will act as a bitmask of 26 bits (for each letter a to z).

// Loop through each character ch in the string w:

// Calculate its position: ch - 'a'

// Flip the corresponding bit in b:
// b ^= (1 << (ch - 'a'))

// After the loop, check:

// If b == 0 → all characters occur even times → return true

// Else if (b & (b - 1)) == 0 → only one bit set → only one odd character → return true

// Else → more than one odd character → return false

