/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = null;
        ListNode next = null;
        ListNode last = null;
        while (l1 != null || l2 != null || carry != 0) {
            int digit = 0; 
            digit += carry;
            carry = 0;
            if(l1 != null) digit += l1.val;
            if(l2 != null) digit += l2.val;
            
            if(digit >= 10) {
                carry = digit / 10;
            }
            digit = digit % 10;
            
            
            next = new ListNode(digit);
            //System.out.println("digit: "+ digit);
            if(last != null) last.next = next;
            last = next;
            if(result == null) result = next;
            
            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return result;
    }
}
