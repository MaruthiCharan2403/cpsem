package UNIT1_1.SlidingWindow;
import java.util.*;
public class KthSmallestSubArraySum {
    public static int find(int[] a,int n,int k){
        int left = Integer.MAX_VALUE;
        int right = 0;
        for(int i = 0;i<n;i++){
            left = Math.min(left, a[i]);
            right+=a[i];
        }
        while (left<right) {
            int mid = left +(right-left)/2;
            if(count(a,mid,n)>=k){
                right=mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }
    public static int count(int[] a,int s,int n){
        int cs = 0;
        int start = 0;
        int c = 0;
        for(int end = 0;end<n;end++){
            cs+=a[end];
            while (cs>s) {
                cs-=a[start++];
            }
            c+=end-start+1;
        }
        return c;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for(int i = 0;i<n;i++){
            a[i] = s.nextInt();
        }
        int k = s.nextInt();
        System.out.println(find(a,n,k));
        s.close();
    }
}


// 1. Preprocessing:
// Initialize:

// left as the minimum element of the array a[].

// right as the sum of all elements in a[].

// 2. Binary Search on Answer:
// Perform a binary search between left and right to find the smallest possible subarray sum such that there are at least k subarrays with a sum less than or equal to that value.

// find(a, n, k):
// While left < right:

// Calculate mid = (left + right) / 2

// If count(a, mid, n) >= k, set right = mid (try smaller sums)

// Else, set left = mid + 1 (need bigger sums)

// When loop ends, return left — this is the k-th smallest subarray sum.

// 3. Count Subarrays with Sum ≤ s:
// count(a, s, n):
// Use a sliding window approach:

// Initialize cs = 0 (current subarray sum), start = 0 (start of window), c = 0 (total subarrays)

// For every end in range [0, n-1]:

// Add a[end] to cs

// While cs > s, subtract a[start] and move start++

// Add end - start + 1 to c (number of valid subarrays ending at end)

// Return total count c

// 📌 Time Complexity:
// Binary Search: O(log(sum of array elements))

// Each count call: O(n) using sliding window

// Total: O(n * log(sum of array elements))