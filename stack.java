class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
        next = null;

    }
}

class stack {
    Node top;

    stack() {
        top = null;
    }

    void push(int x) {
        Node newnode = new Node(x);
        newnode.next = top;
        top = newnode;
        System.out.println(x);
    }

    void pop() {
        if (top == null) {
            System.out.println("stack empty");
            return;
        } else {
            System.out.println("pop" + top.data);
            top = top.next;
        }
    }

    void peek() {
        if (top == null) {
            System.out.println("Stack empty");
            return;
        } else {
            System.out.println("peek" + top.data);
        }
    }

    void display() {
        if (top == null) {
            System.out.println("Stack empty");
            return;
        } else {
            Node temp = top;
            while (temp != null) {
                System.out.print(temp.data);
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        stack s = new stack();
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        s.push(8);
        s.display();
        s.pop();
        s.peek();
        s.display();
    }
}
