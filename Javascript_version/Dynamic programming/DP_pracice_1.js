//0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233...
//author: Yizhou
//Dynamic programming approach to solve the Fibonacci series challenge

function DPFibonacci(){
  let cache = {}; // hash table to store arguments calculated before
  
  return function fib(n) {
    //Check if the argument n has been calculated before
    if(cache[n]) {
      return cache[n];
    }else {
      if(n < 2) {
        return n;
      }else {
        cache[n] = fib(n-2) + fib(n-1);
        console.log(cache[n]);
        return cache[n];
      }
    }
  }
}

test = DPFibonacci();
//test(10);
console.log('DP ' + 10 + ' = ' + test(10));