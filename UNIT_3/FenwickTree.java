import java.util.*;
class Ft{
    int[] nums;
    int[] bit;
    int n;
    public Ft(int[] nums){
        this.nums = nums;
        this.bit = new int[nums.length+1];
        this.n = nums.length;
        for(int i = 0;i<n;i++){
            init(i,nums[i]);
        }
    }
    public void init(int i,int val){
        i++;
        while (i<=n) {
            bit[i]+=val;
            i += i&-i;
        }
    }
    public void update(int i,int val){
        int diff = val-nums[i];
        nums[i] = val;
        init(i, diff);
    }
    public int getsum(int i){
        i++;
        int sum=0;
        while(i>0){
            sum+=bit[i];
            i-=i&-i;
        }
        return sum;
    }
    public int getrangesum(int l,int r){
        return getsum(r)-getsum(l-1);
    }
}
public class FenwickTree{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i<n;i++){
            nums[i] = s.nextInt();
        }
        int l = s.nextInt();
        int r = s.nextInt();
        Ft f = new Ft(nums);
        System.out.println(f.getrangesum(l,r));
        s.close();
    }
}

// 1. Constructor: Ft(int[] nums)
// Purpose: Initialize the Fenwick Tree with values of nums.

// Steps:
// Store original array and size.

// Initialize BIT array bit[] of size n+1 (1-based indexing).

// For every index i in nums[]:

// Call init(i, nums[i]) to build BIT.

// 2. Method: init(int i, int val)
// Purpose: Add val to index i in BIT.

// Steps:
// Convert to 1-based index: i++.

// While i <= n:

// Add val to bit[i].

// Move to next responsible node using i += (i & -i).

// 3. Method: update(int i, int val)
// Purpose: Update nums[i] to a new val.

// Steps:
// Calculate the difference: diff = val - nums[i].

// Update nums[i] with new value.

// Call init(i, diff) to update the BIT.

// 4. Method: getsum(int i)
// Purpose: Get prefix sum from index 0 to i.

// Steps:
// Convert to 1-based: i++.

// Initialize sum = 0.

// While i > 0:

// Add bit[i] to sum.

// Move to parent using i -= (i & -i).

// Return sum.

// 5. Method: getrangesum(int l, int r)
// Purpose: Get sum of nums[l] to nums[r].

// Formula:
// java
// Copy
// Edit
// return getsum(r) - getsum(l - 1);