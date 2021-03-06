package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements
 * appear twice and others appear once.
 * 
 * Find all the elements that appear twice in this array.
 * 
 * Could you do it without extra space and in O(n) runtime?
 * 
 * Example: Input: [4,3,2,7,8,2,3,1]
 * 
 * Output: [2,3]
 * 
 * @author Ellinx
 *
 */
public class FindAllDuplicatesInArray {
	public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        
        int i=0;
        while (i<nums.length) {
        	if (nums[i]!=nums[nums[i]-1]) {
        		int tmp = nums[i];
        		nums[i] = nums[tmp-1];
        		nums[tmp-1] = tmp;
        	} else 
        		i++;	
        }
        
        for (i=0;i<nums.length;i++) {
        	if (nums[i]!=i+1)
        		res.add(nums[i]);
        }
        return res;
    }
	
	//test
	public static void main(String[] args) {
		FindAllDuplicatesInArray tmp = new FindAllDuplicatesInArray();
		int[] nums = {4,3,2,7,8,2,3,1};
		List<Integer> result = tmp.findDuplicates(nums);
		System.out.println(result.toString());
	}
}
