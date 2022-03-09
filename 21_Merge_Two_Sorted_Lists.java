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
	//recursive
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val <= list2.val ) {
            return new ListNode(list1.val, mergeTwoLists(list1.next, list2));
        } else {
            return new ListNode(list2.val, mergeTwoLists(list1, list2.next));
        }
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
	//iterative	
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode tracker = generate(-1,null);
        ListNode result = tracker;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                tracker.val = list1.val;
                tracker.next = generate(-1,null);
                list1 = list1.next;
                tracker = tracker.next;
            } else {
                tracker.val = list2.val;
                tracker.next = generate(-1,null);
                list2 = list2.next;
                tracker = tracker.next;
            }
        }
        if(list1 == null) {
            tracker.val = list2.val;
            tracker.next = list2.next;
        };
        if(list2 == null){
            tracker.val = list1.val;
            tracker.next = list1.next;  
        }
        return result;
    }
    
    private ListNode generate(int val, ListNode next) {
        return new ListNode(val, next);
    }
    private void print(ListNode node) {
        if(node == null) return;
        System.out.println("node val: " + node.val );
    }
    
}