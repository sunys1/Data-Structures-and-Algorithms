//Implementation with LinkedList
class Node {
	constructor(value) {
		this.value = value;
		this.next = null;
	}
}

class Stack {
	constructor() {
		this.top = null;
		this.bottom = null;
		this.length = 0;
	}
	
	peek() {
		return console.log(this.top);
	}
	
	push(value) {
		const temp = new Node(value);
		if(this.length === 0) {
			this.top = temp;
			this.bottom = temp;
		}else {
			temp.next = this.top;
			this.top = temp;
		}	
		this.length ++;
		
		return console.log(this);
	}
	
	pop() {
		if(!this.top)	 {
			return null;
		}
		
		if(this.top === this.bottom) {
			this.bottom = null;	
		}
		this.top = this.top.next;
		this.length--;
		
		return console.log(this);
	}
}

let stack1 = new Stack();
stack1.peek();
stack1.push(5);
stack1.peek();
stack1.push(6);
stack1.peek();
stack1.pop();
stack1.pop();