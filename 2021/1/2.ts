import fs = require('fs')

let arr = fs
  .readFileSync('./1.txt', 'utf8')
  .split('\n')
  .map((val) => parseInt(val))

let count = 0

for (let i = 0; i < arr.length - 2; i++) {
  count += arr[i] < arr[i + 3] ? 1 : 0
}

console.log(count)
