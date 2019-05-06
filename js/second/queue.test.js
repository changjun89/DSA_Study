class Node {
  constructor(value) {
    this.value = value;
    this.preNode = null;
  }
}

class Stack {
  constructor() {
    this.last = null;
    this.size = 0;
  }

  push(value) {
    const newNode = new Node(value);
    newNode.preNode = this.last;
    this.last = newNode;
    this.size++;
  }

  pop() {
    this.size--;
    const lastValue = this.last.value;
    this.last = this.last.preNode;
    return lastValue;
  }

  isEmpty() {
    return this.size === 0;
  }
}

test('스텍 테스트', () => {
  const stack = new Stack();
  expect(stack.isEmpty()).toBe(true);
  stack.push(1);
  stack.push(2);
  stack.push(3);
  expect(3).toBe(stack.pop());
  expect(stack.isEmpty()).toBe(false);
});

class Queue {
  constructor() {
    this.enStack = new Stack();
    this.deStack = new Stack();
  }

  enqueue(value) {
    this.enStack.push(value);
  }

  dequeue() {
    if (this.deStack.isEmpty()) {
      while (!this.enStack.isEmpty()) {
        const value = this.enStack.pop();
        this.deStack.push(value);
      }
    }
    return this.deStack.pop();
  }
}

test('큐 테스트', () => {
  const queue = new Queue();
  queue.enqueue(1);
  queue.enqueue(2);
  queue.enqueue(3);
  expect(queue.dequeue()).toBe(1);
  expect(queue.dequeue()).toBe(2);
  queue.enqueue(4);
  expect(queue.dequeue()).toBe(3);

});