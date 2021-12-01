import fs = require('fs')
let arr = fs.readFileSync('./1.txt', 'utf8').split('\n')
console.log(arr)
let count = 0
for (let i = 1; i < arr.length; i++) {
  count += parseInt(arr[i]) > parseInt(arr[i - 1]) ? 1 : 0
}
console.log(count)
