package DS08;

public class LinkedQueue {
    private Node head;

    public LinkedQueue() {
        this.head = new Node();
    }

    public boolean isEmpty() {
        return head.getNext() == head;
    }

    public void add(BinaryNode binaryNode) {
        head.addLast(binaryNode);
    }

    public BinaryNode remove() {
        if (isEmpty()) {
            return null;
        }
        return head.removeFirst().getValue();
    }


}
