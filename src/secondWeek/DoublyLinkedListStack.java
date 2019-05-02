package secondWeek;


public class DoublyLinkedListStack {

    DoublyLinkedList dll = new DoublyLinkedList();

    public void push(Object value) {
        dll.push(value);
    }

    public Object pop() {
        Object lastNode = dll.getLast();
        dll.removeLast();
        return lastNode;
    }

    public boolean isEmpty() {
        return dll.isEmpty();
    }
}
