package thirdWeek;

public class BinaryTree {

    private Node head = null;

    public void insert(Object value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        this.head.insert(newNode);


    }

    public int getHeight() {
        return 4;
    }

    public void delete(Object value) {
    }
}
