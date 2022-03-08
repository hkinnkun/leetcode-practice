/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode runner_1 = head;
        ListNode runner_2 = head;
        boolean result = false;
        while( runner_1 != null && runner_2 != null ){
            if(runner_1.next != null) {
                runner_1 = runner_1.next;
            } else {
                runner_1 = null;
            }
            if(runner_2.next != null && runner_2.next.next != null) {
                runner_2 = runner_2.next.next;
            } else {
                runner_2 = null;
            }
            if(runner_1.equals(runner_2)) {
                result = true;
                break;
            }
        }
        return result;
    }
    
    //or done by Set<ListNode> ..
}