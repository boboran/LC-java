package solutions;

/**
Given an array nums of n integers where n > 1,  
return an array output such that output[i] is equal to 
the product of all the elements of nums except nums[i].

Example:
Input:  [1,2,3,4]
Output: [24,12,8,6]

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? 
(The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        left[0] = 1;
        int[] right = new int[n];
        right[n-1] = 1;
        for (int i=1;i<n;i++) {
            left[i] = left[i-1]*nums[i-1];
            right[n-1-i] = right[n-i]*nums[n-i];
        }
        int[] ret = new int[n];
        for (int i=0;i<n;i++) {
            ret[i] = left[i]*right[i];
        }
        return ret;
    }
}
