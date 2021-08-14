package DataStructures;



public class BallancedParentheses {

    private static final char[][] TOKENS = {{'{', '}'}, {'[', ']'}, {'(', ')'}};

    public static boolean isBallanced(String expression) {
        if (isExpressionValid(expression)) return false;

        Stack<Character> expressionStack = new Stack<>();

        for (char term : expression.toCharArray()) {
            if (isOpenChar(term)) {
                expressionStack.push(term);
            } else {
                if (!isCloseChar(expressionStack.pop(), term)) {
                    return false;
                }
            }
        }

        return expressionStack.isEmpty();
    }

    private static boolean isExpressionValid(String expression) {
        return ((expression == null || expression.isEmpty()) || (expression.length() % 2) > 0);
    }

    private static boolean isOpenChar(Character term) {
        for (char[] token : TOKENS) {
            if (term == token[0])
                return true;
        }
        return false;
    }

    private static boolean isCloseChar(char top, char c) {
        for (char[] token : TOKENS) {
            if (top == token[0] && c == token[1]) {
                return true;
            }
        }
        return false;
    }
}
