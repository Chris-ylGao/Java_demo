package interview.LinkedList;

public class Node {

    int value;
    Node next;
    public Node(int value){
        this.value =value;
        next = null;
    }

    public String toString(){
        return value + "->" + next;
    }
}
