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
    public ListNode getIntersectionNode(ListNode heada, ListNode headb) {
        ListNode a = heada, b = headb;
        
        int aLen=0,bLen = 0;
        while(a!= null || b!= null){
            if(a!= null){
                aLen++;a=a.next;
            }
            if(b!= null){
                bLen++;b=b.next;
            }
        }
        
        a = heada;b = headb;
        while(aLen > bLen){
            a = a.next;
            aLen--;
        }
        
        while(bLen > aLen){
            b = b.next;
            bLen--;
        }
        
        while(a!=null & b!=null){
            if(a==b) return a;
            a=a.next;
            b=b.next;
        }
        
        return null;
        
    }
}
