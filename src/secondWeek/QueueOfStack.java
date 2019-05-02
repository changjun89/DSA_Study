package secondWeek;

/*
 *  2개의 이중 연결 리스트로 구성된 스택 2개를 이용해
 *  queue 를 구현
 *  예 ) enqueue(1)
 *       enqueue(2)
 *       enqueue(3)
 *       dequeue() = 1
 *       dequeue() = 2
 *       enqueue(4)
 *       enqueue() = 3
 * */
public class QueueOfStack {
    DoublyLinkedListStack enqueueStack = new DoublyLinkedListStack();
    DoublyLinkedListStack dequeueStack = new DoublyLinkedListStack();

    public void enqueue(Object value) {
        enqueueStack.push(value);
    }

    public Object dequeue() {
        if (dequeueStack.isEmpty()) {
            transData();
        }
        return dequeueStack.pop();
    }

    private void transData() {
        while (!enqueueStack.isEmpty()) {
            Object value = enqueueStack.pop();
            dequeueStack.push(value);
        }
    }
}
