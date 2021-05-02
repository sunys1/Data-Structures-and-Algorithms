// add a method prepend() to the linked list that adds a node to the beginning of the list
class Node {
  constructor(value) {
    this.value = value,
    this.next =  null
  }
}
class LinkedList {
  constructor(value) {
    this.head = {
      value: value,
      next: null
    };
    this.tail = this.head;
    this.length = 1;
  }
  append(value) {
    const newNode = new Node(value);
    this.tail.next = newNode;
    this.tail = newNode;
    this.length++;
    return this;
  }
  prepend(value) {
    //Code here
    const newNode = new Node(value);
    newNode.next = this.head;
    this.head = newNode;
    this.length++;
    return this;
  }
  printList() {
    const array = [];
    let currentNode = this.head;
    while(currentNode !== null){
      array.push(currentNode.value)
      currentNode = currentNode.next
    }
    return array;
  }
  insert(index, value){
    //Code here
    //1. if insert to the end of the list
    if(index >= this.length) {
      return console.log(this.append(value).printList());
    }
    
    const leader = this.traverseToIndex(index- 1);
    const pointholder = leader.next;
    const insertedNode = new Node(value);
    leader.next = insertedNode;
    insertedNode.next = pointholder;
    this.length++;
    
    return console.log(this.printList());
  }
  remove(index) {
    if(index >= this.length) {
      let newTail = this.traverseToIndex(this.length - 2);
      newTail.next = null;
      this.tail = newTail;
      this.length--;
      
      return console.log(this.printList());
    }
    
    const leader = this.traverseToIndex(index-1);
    const unwantedNode = leader.next;
    leader.next = unwantedNode.next;
    this.length--;
    
    return console.log(this.printList());
  }
  reverse() {
    //if one node only we return this node
    if(!this.head.next) {
      return this.head;
    }
    
    let first = this.head;
    let second = first.next;
    let temp;
    while(second != null) {
      temp = second.next;
      second.next = first;
      first = second;
      second = temp;
    }
    this.head.next = null;
    this.head = first;
    
    return console.log(this.printList());
  }
  
  traverseToIndex(index) {
    let counter = 0;
    let currNode = this.head;
    while(counter !== index) {
      counter++;
      currNode = currNode.next;
    }
    
    return currNode;
  }
  
}

let myLinkedList = new LinkedList(10);
myLinkedList.append(5);
myLinkedList.append(16);
myLinkedList.prepend(1)
console.log(myLinkedList.printList());
myLinkedList.insert(2, 99)
myLinkedList.insert(20, 88)
myLinkedList.insert(20, 100)
myLinkedList.remove(2)
myLinkedList.remove(20)
myLinkedList.reverse();
