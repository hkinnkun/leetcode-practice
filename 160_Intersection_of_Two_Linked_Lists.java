/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode nextA = headA;
        while(nextA != null) {
            set.add(nextA);
            nextA = nextA.next;
        }
        boolean found = false;
        ListNode nextB = headB;
        while(nextB != null){
            if(set.contains(nextB)) {
                return nextB;
            }
            nextB = nextB.next;
        }
        return null;
    }
}







/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        ListNode nextA = headA;
        while(nextA != null) {
            lenA++;
            nextA = nextA.next;
        }
        int lenB = 0;
        ListNode nextB = headB;
        while(nextB != null) {
            lenB++;
            nextB = nextB.next;
        }
        nextA = headA;            
        nextB = headB;
        if(lenA > lenB) {
            for(int i = 0; i < lenA - lenB; i++){
                nextA = nextA.next;
            }
        } else {
            for(int i = 0; i < lenB - lenA; i++){
                nextB = nextB.next;
            }
        }
        while(nextA != null && nextB != null) {
            if(nextA == nextB) return nextA;
            nextA = nextA.next;
            nextB = nextB.next;
        }
        return null;
    }
}



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //if intersects, will return the intersected node, else, the intersected is null
        ListNode a = headA;
        ListNode b = headB;
        while(a != b) {
            a = a == null ? headA : a.next;
            b = b == null ? headB : b.next;
        }
        return a;
    }
}





/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //if intersects, will return the intersected node, else, the intersected is null
        ListNode a = headA;
        ListNode b = headB;
        while(a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
            //when reach to end, switch the route
        }
        return a;
    }
}



