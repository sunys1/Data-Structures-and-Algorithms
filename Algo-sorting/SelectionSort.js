const numbers = [99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0];

function selectionSort(array) {
  let min , temp;
  for(let i = 0; i < array.length; i++) {
    //set initial minimum to the first item encountered.
    min = i;
    for(let j = i+1; j < array.length; j++) {
      if(array[j] < numbers[min]) {
        min = j;
      }
    }
    temp = array[i];
    array[i] = array[min];
    array[min] = temp;
  }
}

selectionSort(numbers);
console.log(numbers);