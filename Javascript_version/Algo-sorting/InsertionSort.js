const numbers = [99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0];

function insertionSort(array) {
  //For each item at index i in the array, compare with the first item of the sorted part of the array before this item
  //if array[i] < array[0], move array[i] to the beginning of the array
  for(let i = 0; i < array.length; i++) {
    if(array[i+1] <= array[0]) {
      let removed = array.splice(i+1,1);
      array.unshift(removed[0]);
      //console.log(array);
    }
    else {
      //move array[i+1] to the right spot
      for(let j = 0; j < i; j++) {
        if(array[i+1] > array[j] && array[i+1] < array[j+1]) {
          let removed = array.splice(i+1,1);
          array.splice(j+1,0, removed[0]);
        }
      }
    }
  }
}

insertionSort(numbers);
console.log(numbers);