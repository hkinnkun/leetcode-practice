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
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        stack.push(cur);
        while(cur.next != null) {
            cur = cur.next;
            stack.push(cur);
        }
        //System.out.println(stack.stream().map(s -> Integer.toString(s.val)).collect(Collectors.toList()));
        ListNode result = new ListNode(stack.pop().val);
        ListNode next = null;
        while(!stack.empty()) {
            ListNode temp = new ListNode(stack.pop().val);
            if(result.next == null) {
                result.next =temp;
                next = temp;
            } else {
                next.next = temp;
                next =next.next;
            }
        }
        return result;
    }
}




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
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode oriList = head;
        ListNode tail = new ListNode(oriList.val);
        ListNode temp_ori = null;
        ListNode new_ori = null;
        while(oriList.next != null) {
            temp_ori = oriList.next;
            oriList = oriList.next;
            if(new_ori == null) {
                new_ori = new ListNode(temp_ori.val);
                new_ori.next = tail;
            } else {
                ListNode temp = new_ori;
                new_ori = new ListNode(temp_ori.val);
                new_ori.next = temp;
            }
        }
        return new_ori;
    }
}






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
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
}
