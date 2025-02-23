//Author: Yizhou
//Time complexity: O(n/2) = O(n)
//Space complexity: O(n)
function reverseStr(str) {
//input: str = 'Hi Hello World!'
// 1. split string into array of characters: ['H', 'i', ' ', 'H'.....]
	arrChar = str.split('');
	let temp;
// 2. reverse the seuqence of all the characters in arrChar
	for(let i = 0; i < arrChar.length / 2; i++)  {
		//Find index of the item with which arrChar[i] will swtich no.sequence
		j = arrChar.length - 1 - i;
		//Stop when i and j collide or when j < i: reverse is done
		if(i === j || j < i) {
			break;
		}
		//store its value to later use
		temp = arrChar[i];
		arrChar[i] = arrChar[j];
		arrChar[j] = temp;
	}
// 3. Combine the characters into the new reversed string
	console.log(arrChar.join(''));
}
reverseStr('Hi Hello World!');

// Other possible solutions:
//1. Create new array and loop through arrChar backwards and push characters into the new array, then join.
//2. Using built-in method: reverse() => str.split('').reverse().join()
//3. Using ES6 spread operator => [...str].reverse().join()