//Google Question
//Given an array = [2,5,1,2,3,5,1,2,4]:
//It should return 2

//Given an array = [2,1,1,2,3,5,1,2,4]:
//It should return 1

//Given an array = [2,3,4,5]:
//It should return undefined

//Author: Yizhou
//Time complexity: O(n)
//Space complexity: O(n)
function firstRecurringCharacter(input) {
//input is array of integers, unsorted
//	1. build a hash map
//	2. loop through the input array, check if the indexed item exists in the hashmap already
//	   if the item exists, we confired the recurring item found;
//	   else we add the item as a key into the hashmap and assign a value like 'true' to it;
//	3. If at the end no recurring item found, we return undefined

	// Initiate the hash map
	let result = {}; 
	
	for(let i = 0; i < input.length; i++) {
		//check if the indexed item exists in the hashmap already. If the item exists, we confired the recurring item found;
		if(result[input[i]] !== undefined) {
			return input[i];
		}
		else {
			//If not found, we add the key to the hash map
			result[input[i]] = true;
		}
	}
	//When nothing found, return undefined
	return undefined;
}

console.log(firstRecurringCharacter([2,5,1,2,2,3,5,1,2,4]))
//Bonus... What if we had this:
// [2,5,5,2,3,5,1,2,4]
// return 5 because the pairs are before 2,2