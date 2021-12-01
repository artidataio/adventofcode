import fs = require('fs')
let arr = fs.readFileSync('./1.txt', 'utf8').split('\n')
let count = 0
for (let i = 0; i < arr.length - 2; i++) {
  count += parseInt(arr[i]) < parseInt(arr[i + 3]) ? 1 : 0
}
console.log(count)
