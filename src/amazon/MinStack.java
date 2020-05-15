package amazon;

public class MinStack {

    class Node{
        int val;
        int min;
        Node next;

        Node(int x,int min){
            this.min = min;
            this.val = x;
            this.next = null;
        }
    }

    Node head;

    public void push(int x){
        if(head == null){
            head = new Node(x,x);
        }

        else{
            Node newNode = new Node(x, Math.min(x,head.min));
            newNode.next = head;
            head = newNode;
        }
    }

    public int pop(){
        int val = head.val;
        head = head.next;
        return val;
    }

    public int getTop(){
        return head.val;
    }

    public int getMin(){
        return head.min;
    }
    public static void main(String[] args) {
        
    }

    
}