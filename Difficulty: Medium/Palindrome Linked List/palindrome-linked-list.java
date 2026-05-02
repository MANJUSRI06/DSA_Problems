/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}*/
class Solution {
    public Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node newhead = reverse(slow.next);
        Node first = head;
        Node second = newhead;
        while(second != null){
            if(first.data != second.data){
                reverse(newhead); 
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(newhead);
        return true;
    }
}