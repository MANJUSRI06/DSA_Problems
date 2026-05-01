/* Structure of node
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
} */

class Solution {

    // Function to find the data of kth node from
    // the end of a linked list.
    int getKthFromLast(Node head, int k) {
        int count = 0;
        Node temp = head;
        while(temp!= null){
            count++;
            temp = temp.next;
        }
        if(k>count){
            return -1;
        }
        temp = head;
        int pos = count-k;
        for(int i=0; i<pos; i++){
            temp = temp.next;
        }
        return temp.data;
    }
}