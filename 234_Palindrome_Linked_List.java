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
    public boolean isPalindrome(ListNode head) {
        Stack<Character> stack = new Stack<>();
        List<Character> list = new ArrayList<>();
        while(head != null) {
            char c = (char) head.val;
            stack.push(c);
            list.add(c);
            head = head.next;
        }
        int i = 0;
        boolean result = true;
        while(!stack.empty()) {
            if(list.get(i) != stack.pop()) {
                result = false;
                break;
            }
            i++;
        }
        return result;
    }
}