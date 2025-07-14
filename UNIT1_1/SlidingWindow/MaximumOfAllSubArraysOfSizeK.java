package UNIT1_1.SlidingWindow;
import java.util.*;
public class MaximumOfAllSubArraysOfSizeK {
    public static ArrayList<Integer> find(int[] a,int n,int k){
        ArrayList<Integer> al = new ArrayList<>();
        Deque<Integer> q = new LinkedList<>();
        for(int i = 0;i<k;i++){
            while (!q.isEmpty() && a[i]>=a[q.peekLast()]) {
                q.removeLast();
            }
            q.addLast(i);
        }
        al.add(a[q.peek()]);
        for(int i = k;i<n;i++){
            while (!q.isEmpty() && q.peek()<=i-k) {
                q.removeFirst();
            }
            while (!q.isEmpty()&& a[i]>=a[q.peekLast()]) {
                q.removeLast();
            }
            q.addLast(i);
            al.add(a[q.peek()]);
        }
        return al;
        
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

// The naive approach would be to check each subarray of size k one by one, which takes O(n * k) time.

// Instead, we use a Deque (double-ended queue) to keep track of potential maximum elements in O(n) time.

// But here's the trick:
// Instead of storing the elements themselves, we store their indices, and maintain the deque in such a way that:

// The front of the deque always holds the index of the maximum element of the current window.

// We remove elements from the back if the current element is greater, because the current one would dominate them in this and future windows.

// 🔍 Why it Works:
// Imagine you have a sliding window of size k moving across the array.

// At each step, you:

// Remove indices from the front if they fall out of the current window.

// Remove indices from the back whose values are less than the current element — they are not useful anymore.

// Add the current index at the back.

// Pick the front element of the deque as the max of the current window.

// By doing this:

// The deque only holds indices of elements that are potentially the largest in the current or upcoming windows.

// You always get the max in constant time per window, since you just check the front of the deque.

