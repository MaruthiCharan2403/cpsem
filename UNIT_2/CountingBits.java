import java.util.*;
public class CountingBits{
    public static String find(int n){
        int[] dp = new int[n+1];
        dp[0] =0;
        for(int i = 1;i<=n;i++){
            dp[i] = dp[i/2]+i%2;
        }
        return Arrays.toString(dp);
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(find(n));
        s.close();
    }
}

// Step-by-step Algorithm
// Initialize an array dp of size n + 1 to store results.

// dp[i] will hold the number of 1s in binary of i.

// Set base case:

// dp[0] = 0 → binary of 0 is 0, which has 0 ones.

// Iterate from i = 1 to n:

// For each number i, compute:

// dp[i] = dp[i / 2] + (i % 2)

// i / 2: Right shift by 1 (removes the last bit)

// i % 2: Checks if the last bit is 1 (odd number → last bit is 1)

// Return the array as a string using Arrays.toString(dp).

