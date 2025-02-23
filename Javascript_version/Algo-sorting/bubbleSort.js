const numbers = [99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0];

function bubbleSort(array) {
	let temp;
	for(let i = 0; i < array.length; i++) {
		for(let j = 0; j < array.length; j++) {
			if(array[j] > array[j+1]) {
				temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
			}
		}
	}
}

bubbleSort(numbers);
console.log(numbers);