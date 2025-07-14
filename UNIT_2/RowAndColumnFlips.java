import java.util.*;
public class RowAndColumnFlips {
    public static boolean find(int[][] a,int m,int n){
        for(int c = 0;c<n;c++){
            if(a[0][c]==0){
                for(int r = 0;r<m;r++){
                    a[r][c]^=1;
                }
            }
        }
        for(int r = 0;r<m;r++){
            int s = 0;
            for(int c = 0;c<n;c++){
                s+=a[r][c];
            }
            if(s!=0 || s!=n) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        int[][] a = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                a[i][j] = s.nextInt();
            }
        }
        System.out.println(find(a,m,n));
        s.close();
    }
}


// Column Flip Phase
// For every column c:

// If a[0][c] == 0 → flip the column:

// For each row r, do: a[r][c] ^= 1

// ✅ This makes first row all 1s after column flips.

// Row Check Phase
// For each row r:

// Compute the sum s of elements in the row.

// If s != 0 and s != n:

// This row is mixed (has both 0 and 1) → return false

// If all rows are either all 0s or all 1s → return true