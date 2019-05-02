package secondWeek;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length = 0;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getLength() {
        return length;
    }

    public void push(Object value) {
        length++;
        if (getHead() == null) {
            firstNodeSet(value);
            return;
        }
        changeTail(value);
    }

    private void firstNodeSet(Object value) {
        Node newNode = new Node(value);
        setHead(newNode);
        setTail(newNode);
    }

    private void changeTail(Object value) {
        Node newNode = new Node(value, getTail(), null);
        getTail().setNextNode(newNode);
        setTail(newNode);
    }

    public Object getLast() {
        return getTail().getValue();
    }

    public void removeLast() {
        if (getLength() == 1) {
            listReset();
            return;
        }
        removeTail();
    }

    private void removeTail() {
        Node preNode = getTail().getPreNode();
        preNode.setNextNode(null);
        setTail(preNode);
        length--;
    }

    private void listReset() {
        setHead(null);
        setTail(null);
        length--;
    }

    public boolean isEmpty() {
        return getLength() == 0;
    }
}
