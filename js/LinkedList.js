function assertEquals(a, b) {
  if (a !== b) {
    console.error(`expeted ${a} but actually ${b}`);
  }

}

function Node(value) {
  this.value = value;
  this.next = null;
}

function linkedList() {
  this.head = null;
  this.length = 0;
  this.append = append;
  this.isEmpty = isEmpty;
  this.insert = insert;
  this.removeAt = removeAt;
  this.remove = remove;
}

function append(element) {
  const node = new Node(element);
  this.length += 1;
  if (this.head === null) {
    this.head = node;
  } else {
    let curNode;
    curNode = this.head;
    while (curNode.next) {
      curNode = curNode.next;
    }
    curNode.next = node;
  }
}

function insert(element, idx) {
  const newNode = new Node(element);
  if (idx > this.length || idx < 0) {
    console.error('범위를 벗어남');
    return false;
  }

  if (idx === 0) {
    newNode.next = this.head;
    this.head = newNode;
    this.length++;
    return;
  }

  let curNode = this.head;
  let curIdx = 0;
  let preNode = this.head;
  while (idx > curIdx++) {
    preNode = curNode;
    curNode = curNode.next;
  }
  newNode.next = curNode;
  preNode.next = newNode;
  this.length++
}

function removeAt(idx) {
  if (idx > this.length || idx < 0) {
    console.error('범위를 벗어남');
    return false;
  }
  if (idx === 0) {
    this.head = this.head.next;
    this.length--;
  }

  let curNode = this.head;
  let preNode = this.head;
  let curIdx = 0;
  while (idx > curIdx++) {
    preNode = curNode;
    curNode = curNode.next;
  }

  preNode.next = curNode.next;
  this.length--;

}

function remove(element) {

  let curNode = this.head;
  let preNode = this.head;

  if (curNode.value ===element) {
    this.head = curNode.next;
    this.length--;
    return ;
  }

  while (curNode.next) {
    preNode = curNode;
    curNode = curNode.next;
    if (curNode.value === element) {
      preNode.next = curNode.next;
      this.length--;
      return ;
    }
  }

  return -1;

}

function isEmpty() {
  return this.length === 0 ? true : false;
}

let list = new linkedList();
assertEquals(true, list.isEmpty());
list.append('5');
list.append('4');
list.append('3');
list.insert('1', 1);
list.removeAt(1);
list.remove('4');
assertEquals(false, list.isEmpty());
assertEquals(2, list.length);
assertEquals('5', list.head.value);
assertEquals('3', list.head.next.value);
//assertEquals('4', list.head.next.next.value);
