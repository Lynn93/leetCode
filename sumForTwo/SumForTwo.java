package sumForTwo;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode pointer = head;
        int toAdd = 0;

        int times = 0;
        while (true) {
            //1. l1 l2 都有
            if(l1!=null && l2!=null){
                int singleResult = l1.val + l2.val + toAdd;
                if(singleResult > 9){
                    toAdd = 1;
                    singleResult = singleResult % 10;
                } else {
                    toAdd = 0;
                }
                if(pointer.val == -1){
                    pointer.val = singleResult;
                } else {
                    pointer.next = new ListNode(singleResult);
                    pointer = pointer.next;
                }
                l1 = l1.next;
                l2 = l2.next;
            } else if(l1 != null && l2 == null){
                int singleResult = l1.val + toAdd;
                if(singleResult > 9){
                    toAdd = 1;
                    singleResult = singleResult % 10;
                } else {
                    toAdd = 0;
                }
                if(pointer.val == -1){
                    pointer.val = singleResult;
                } else {
                    pointer.next = new ListNode(singleResult);
                    pointer = pointer.next;
                }
                l1 = l1.next;
            } else if(l1 == null && l2 != null){
                int singleResult = l2.val + toAdd;
                if(singleResult > 9){
                    toAdd = 1;
                    singleResult = singleResult % 10;
                } else {
                    toAdd = 0;
                }
                if(pointer.val == -1){
                    pointer.val = singleResult;
                } else {
                    pointer.next = new ListNode(singleResult);
                    pointer = pointer.next;
                }
                l2 = l2.next;
            } else if(toAdd != 0){
                if(pointer.val == -1){
                    pointer.val = toAdd;
                } else {
                    pointer.next = new ListNode(toAdd);
                    pointer = pointer.next;
                }
                toAdd = 0;
            } else {
                return head;
            }
            
            System.out.println(times++);
        }
    }
}



public class SumForTwo {
    public static void main(String []args){
        // ListNode l1 = new ListNode(2);
        // l1.next = new ListNode(4);
        // l1.next.next = new ListNode(3);


        // ListNode l2 = new ListNode(5);
        // l2.next = new ListNode(6);
        // l2.next.next = new ListNode(4);

        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);

        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);


        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        Solution sl = new Solution();
        ListNode result = sl.addTwoNumbers(l1, l2);
        System.out.println("done!");
    }
}
