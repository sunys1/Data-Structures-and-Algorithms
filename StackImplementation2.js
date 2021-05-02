//Implementation with Array
class Stack {
	constructor() {
		this.array = [];
	}
	
	peek() {
		return console.log(this.array[this.array.length - 1]);
	}
	
	push(value) {
		this.array.push(value);
		
		return console.log(this);
	}
	
	pop() {
		this.array.pop();
		
		return console.log(this);
	}
	
	isEmpty() {
		if(this.array.length === 0) {
			return true;
		}
		return false;
	}
}

let stack1 = new Stack();
stack1.peek();
stack1.push(5);
stack1.peek();
stack1.push(6);
stack1.peek();
stack1.pop();
console.log(stack1.isEmpty());
stack1.pop();
console.log(stack1.isEmpty());