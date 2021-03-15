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
    public ListNode swapNodes(ListNode head, int k) {
        int index = 1;
        ListNode currPtr = head;
        ListNode first = null, last = null;
        
        while(currPtr != null){
            if(index == k){
                first = currPtr;
            }
            if(index == k+1) last = head;
            if(last != null) last = last.next;
            currPtr = currPtr.next;
            index++;
        }
        if(first != null && last == null) last = head;
        int tmp = first.val;
        first.val = last.val;
        last.val = tmp;
        return head;
    }
}
