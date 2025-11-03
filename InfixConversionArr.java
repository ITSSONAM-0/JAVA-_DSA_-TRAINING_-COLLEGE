// Stack using Array
class StackArr {
    int top;
    char[] arr;

    StackArr(int size) {
        arr = new char[size];
        top = -1;
    }

    void push(char c) {
        if (top == arr.length - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = c;
    }

    char pop() {
        if (isEmpty())
            return '\0';
        return arr[top--];
    }

    char peek() {
        if (isEmpty())
            return '\0';
        return arr[top];
    }

    boolean isEmpty() {
        return top == -1;
    }
}

// Expression Converter
class ExpressionConverter {

    // precedence function
    static int precedence(char c) {
        switch (c) {
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

    // check if operand
    static boolean isOperand(char c) {
        return Character.isLetterOrDigit(c);
    }

    // Infix → Postfix
    static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        StackArr stack = new StackArr(exp.length());

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (isOperand(c)) {
                result.append(c); // operand
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // remove '('
            } else { // operator
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    if (c == '^' && stack.peek() == '^')
                        break; // handle right-associative ^
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    // Infix → Prefix
    static String infixToPrefix(String exp) {
        StringBuilder sb = new StringBuilder(exp);
        sb.reverse();

        // swap brackets
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(')
                sb.setCharAt(i, ')');
            else if (sb.charAt(i) == ')')
                sb.setCharAt(i, '(');
        }

        // get postfix of reversed expression
        String postfix = infixToPostfix(sb.toString());

        // reverse postfix → prefix
        return new StringBuilder(postfix).reverse().toString();
    }
}

// Main class
public class InfixConversionArr {
    public static void main(String[] args) {
        String infix = "(A-B/C)*(A/K-L)";

        System.out.println("Infix   : " + infix);
        System.out.println("Postfix : " + ExpressionConverter.infixToPostfix(infix));
        System.out.println("Prefix  : " + ExpressionConverter.infixToPrefix(infix));
    }
}
