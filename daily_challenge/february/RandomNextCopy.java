/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        
        if(curr == null) return curr;
        
        while(curr!= null){
            Node tmp = new Node(curr.val);
            tmp.next = curr.next;
            curr.next = tmp;
            curr = curr.next.next;
        }
        
        curr = head;
        
        while(curr!= null){
            Node rand = curr.random == null ? null : curr.random.next;
            curr.next.random = rand;
            curr = curr.next.next;
        }
        
        Node newHead = head.next;
        Node curr2 = newHead;
        Node curr1 = head;
        while(curr1 != null && curr2 != null){
            curr1.next = curr2.next;
            curr1 = curr1.next;
            curr2.next = curr1 == null ? null : curr1.next;
            curr2 = curr2.next;
        }
        
        
        return newHead;
    }
}
