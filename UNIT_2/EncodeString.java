import java.util.*;
public class EncodeString {
    public static String encode(int n){
        StringBuilder sb = new StringBuilder();
        n+=1;
        while(n>1){
            sb.append(n&1);
            n = n>>1;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(encode(n));
        s.close();
    }
}

// Initialize an empty string builder sb.

// Increment n by 1 (since encoding is based on n + 1):

// n += 1;
// While n > 1:

// Extract the least significant bit using n & 1 and append it to sb.

// Right shift n by 1 (n = n >> 1) to move to the next bit.

// Loop continues until n == 1 (this leading 1 is excluded from the result).

// Reverse the bits collected in sb, because bits were added from LSB to MSB.

// Return the resulting string.