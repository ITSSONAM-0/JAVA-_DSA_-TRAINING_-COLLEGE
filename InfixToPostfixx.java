class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    Node top;

    void push(char data) {
        Node newnode = new Node(data);
        newnode.next = top;
        top = newnode;
    }

    char pop() {
        if (top == null) {
            return '\0';
        } else {
            char d = top.data;
            top = top.next;
            return d;
        }
    }

    char peek() {
        if (top == null) {
            return '\0';
        }
        return top.data;

    }

    boolean isEmpty() {
        return top == null;
    }
}

public class InfixToPostfixx {
    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String Convert(String exp) {
        String result = "";
        Stack obj = new Stack();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                result += c;
            } else if (c == '(') {
                obj.push(c);
            } else if (c == ')') {
                while (!obj.isEmpty() && obj.peek() != '(') {
                    result += obj.pop();
                }
                obj.pop();
            } else {
                while (!obj.isEmpty() && precedence(c) <= precedence(obj.peek())) {
                    result += obj.pop();
                }
                obj.push(c);
            }
        }
        while (!obj.isEmpty()) {
            result += obj.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        String exp = "A+(B*C)";
        System.out.println("Infix Expression: " + exp);
        System.out.println("Conversion " + Convert(exp));
    }
}
