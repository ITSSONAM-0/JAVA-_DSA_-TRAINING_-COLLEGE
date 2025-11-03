import java.util.Stack;

public class InfixToPostfix {

    // function to return precedence
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

    // infix to postfix conversion
    static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            // 1. If operand -> add to result
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            // 2. If '(' -> push to stack
            else if (c == '(') {
                stack.push(c);
            }
            // 3. If ')' -> pop until '('
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // remove '('
            }
            // 4. Operator
            else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    if (c == '^' && stack.peek() == '^')
                        break; // handle right associativity of ^
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // 5. Pop all remaining operators
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    // driver code
    public static void main(String[] args) {
        String exp = "A+B*(C^D-E)^(F+G*H)-I";
        System.out.println("Infix : " + exp);
        System.out.println("Postfix : " + infixToPostfix(exp));
    }
}
