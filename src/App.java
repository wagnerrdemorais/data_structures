import DataStructures.BallancedParentheses;
import DataStructures.CycleInLinkedList;
import DataStructures.QueueWithTwoStacks;

public class App {

    public static void main(String[] args) {
        testBalancedParentheses();
        testQueueWithTwoStacks();
        testCycleLinkedList();
    }

    private static void testCycleLinkedList() {
        CycleInLinkedList.Node<String> node1 = new CycleInLinkedList.Node<>();
        CycleInLinkedList.Node<String> node2 = new CycleInLinkedList.Node<>();
        CycleInLinkedList.Node<String> node3 = new CycleInLinkedList.Node<>();
        CycleInLinkedList.Node<String> node4 = new CycleInLinkedList.Node<>();
        CycleInLinkedList.Node<String> node5 = new CycleInLinkedList.Node<>();

        node1.data = "foo";
        node2.data = "bar";
        node3.data = "foobar";
        node4.data = "foofoo";
        node5.data = "barbar";

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;

        CycleInLinkedList cycleInLinkedList = new CycleInLinkedList();
        System.out.println("Has Cycle : " + cycleInLinkedList.hasCycle(node1));

        node4.next = node5;
        System.out.println("Has Cycle : " + cycleInLinkedList.hasCycle(node1));
    }

    private static void testQueueWithTwoStacks() {
        QueueWithTwoStacks<String> queue = new QueueWithTwoStacks<>();
        queue.enqueue("Bla");
        queue.enqueue("Foo");
        queue.enqueue("Bar");

        System.out.println("Peek: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Peek: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Peek: " + queue.peek());
        queue.enqueue("Final");
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
    }

    private static void testBalancedParentheses() {
        String expression1 = "{()[{({})[]()}]}([])";
        String expression2 = "{()[{({})[]()}]}([]";
        String expression3 = "{()[{({})[]})}]}";
        String expression4 = "{()}";

        checkBalancedExpression(expression1);
        checkBalancedExpression(expression2);
        checkBalancedExpression(expression3);
        checkBalancedExpression(expression4);
    }

    private static void checkBalancedExpression(String expression1) {
        if(BallancedParentheses.isBallanced(expression1)){
            System.out.println("The given expression is ballanced!");
        } else {
            System.out.println("The given expression is NOT ballanced!");
        }
    }
}
