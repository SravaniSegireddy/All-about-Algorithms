/**

234. Palindrome Linked List
Easy

4994

432

Add to List

Share
Given the head of a singly linked list, return true if it is a palindrome.

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
        if(head == null) return false;
        
        ListNode slow = head, fast = head;
        
        while(fast.next!= null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode prev = slow, curr = slow.next;
        ListNode next = null, rHead = slow;
        while(curr != null){
            rHead = curr;
            next = curr.next;
            curr.next= prev;
            prev = curr;
            curr = next; 
        }
        
        ListNode ltmp = head, rtmp = rHead;
        
        while(ltmp!= rtmp){
            if(ltmp.val != rtmp.val) return false;
            if(rtmp.next == ltmp) return true;
            ltmp = ltmp.next;
            rtmp = rtmp.next;
        }
        
        return true;
        
    }
}
