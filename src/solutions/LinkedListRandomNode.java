package solutions;

/**
 * Given a singly linked list, return a random node's value from the linked
 * list. Each node must have the same probability of being chosen.
 * 
 * Follow up: What if the linked list is extremely large and its length is
 * unknown to you? Could you solve this efficiently without using extra space?
 * 
 * Example:
 * 
 * // Init a singly linked list [1,2,3]. ListNode head = new ListNode(1);
 * head.next = new ListNode(2); head.next.next = new ListNode(3); Solution
 * solution = new Solution(head);
 * 
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should
 * have equal probability of returning. solution.getRandom();
 * 
 * @author Ellinx
 *
 */

//Reservoir Sampling
//Problem:
//Choose k entries from n numbers. Make sure each number is selected with the probability of k/n
//Basic idea:
//Choose 1, 2, 3, ..., k first and put them into the reservoir.
//For k+1, pick it with a probability of k/(k+1), and randomly replace a number in the reservoir.
//For k+i, pick it with a probability of k/(k+i), and randomly replace a number in the reservoir.
//Repeat until k+i reaches n
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class LinkedListRandomNode {
    
    private ListNode head;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int ret = 0;
        ListNode cur = head;
        for (int i=0;;i++) {
            if (cur==null) {
                break;
            }
            if ((int)(Math.random()*(i+1))==i) {
                ret = cur.val;
            }
            cur = cur.next;
        }
        return ret;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */