package UNIT1_1.TwoPointer;

import java.util.*;

public class ClosestPair {
    void printClosest(int ar1[], int ar2[], int m, int n, int x) {
        int diff = Integer.MAX_VALUE;
        int res_l = 0, res_r = 0;

        // Start from left of ar1[] and right of ar2[]
        int l = 0, r = n - 1;

        while (l < m && r >= 0) {
            int sum = ar1[l] + ar2[r];

            // Update result if this pair is closer to x
            if (Math.abs(sum - x) < diff) {
                res_l = l;
                res_r = r;
                diff = Math.abs(sum - x);
            }

            // Move pointers
            if (sum > x) {
                r--;
            } else {
                l++;
            }
        }

        // Print the result
        System.out.println("The closest pair is [" + ar1[res_l] + ", " + ar2[res_r] + "]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClosestPair ob = new ClosestPair();

        System.out.println("Enter size of array_1:");
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Enter the values of array_1:");
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter size of array_2:");
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        System.out.println("Enter the values of array_2:");
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        System.out.println("Enter the target sum (x):");
        int x = sc.nextInt();

        // Arrays must be sorted for two-pointer technique to work
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        ob.printClosest(arr1, arr2, n1, n2, x);
        sc.close();
    }
}
