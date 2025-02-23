const numbers = [99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0];
 
function mergeSort (array) {
  //console.log(array);
  if (array.length === 1) {
    return array
  }
  // Split Array in into right and left
  let indx =  Math.floor(array.length / 2); // 3.5 => 3
  let left = array.slice(0, indx); //index from 0 ~ 3 (4 is exclusive)
  let right = array.slice(indx); //index from 4 ~ end including the last one
  
//  console.log(left);
//  console.log(right);

  return merge(
    mergeSort(left),
    mergeSort(right)
  )
}

function merge(left, right){
  let result = [];
  let leftIndx = 0, rightIndx = 0;
  
  while(
    //compare elements in left and right at indiviual index and push to result array until
    // either left or right finishes.
    leftIndx < left.length &&
    rightIndx < right.length) {
      
    if(left[leftIndx] < right[rightIndx]) {
      result.push(left[leftIndx]);
      leftIndx++;
    }else {
      result.push(right[rightIndx]);
      rightIndx++;
    }
  }
  
  console.log(left);
  console.log(right);
  console.log(leftIndx);
  console.log(rightIndx);
  console.log(result);
  console.log('--------------------------------');

  //elements in results are the smallest, then we need to concatenate with the rest from either left or right.
  return result.concat(left.slice(leftIndx), right.slice(rightIndx));
}

const answer = mergeSort(numbers);
console.log(answer);