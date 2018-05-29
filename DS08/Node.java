package DS08;

public class Node {
    private Node next;
    private Node prev;
    private BinaryNode value;

    Node() {
        next = this;
        prev = this;
    }

    private Node(BinaryNode value) {
        this.value = value;
    }

    public void addLast(BinaryNode value) {
        Node newNode = new Node(value);

        this.prev.next = newNode;
        newNode.prev = this.prev;
        newNode.next = this;
        this.prev = newNode;
    }

    public Node removeFirst() {
        Node node = this.next;
        this.next = node.next;
        this.next.prev = this;
        return node;
    }

    public Node getNext() {
        return this.next;
    }

    public BinaryNode getValue() {
        return this.value;
    }

}
