package interview.LinkedList;

import interview.LinkedList.Node;

import java.util.LinkedList;
import java.util.Stack;

public class ReverseLinkedList {
    /**
     * reversing by recursion
     * @param head
     * @return
     */
    public static Node reverse(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node temp = head.next;
        Node newHead = reverse(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }

    public static void reverse2(Node head){
        Stack<Node> nodes = new Stack<>();
         Node node = head;
        while(node !=null){
            nodes.push(node);
            node = node.next;
        }
        while(!nodes.empty()){
            System.out.print(nodes.pop().value + "->");
        }
        System.out.print("null");
    }

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=null;
        System.out.println(node1);
        System.out.println(reverse(node1));

        System.out.println("-------------------------");
        reverse2(node1);
    }
}
