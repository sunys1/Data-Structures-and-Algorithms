//const numbers = [99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0];
//
////1. Pick pivot. The median is the best
////2. Partitioning - items to the left of the pivot < pivot < items to the right of the pivot
////3. Quick sort - divide and conquer like merge sort for the left and right side of the pivot
////4. 
//function quickSort(array, left, right) {
//	
//}
//
//function partition(array, left, right) {
//	
//}
//
//
////Select first and last index as 2nd and 3rd parameters
//quickSort(numbers, 0, numbers.length - 1);
//console.log(numbers);



//find median
const median = arr => {
	const mid = Math.floor(arr.length / 2),
	nums = [...arr].sort((a, b) => a - b);
	return arr.length % 2 !== 0 ? nums[mid] : (nums[mid - 1] + nums[mid]) / 2;
};

console.log(median([5, 6, 50, 1, -5, 4]));
console.log(median([1, 2, 3, 4, 5, 6]));