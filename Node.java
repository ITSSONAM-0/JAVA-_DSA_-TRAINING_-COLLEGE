// starting me node kaise banate hai
public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public static void main(String[] args) {
        Node obj = new Node(10);
        System.out.println(obj.data);
    }
}
