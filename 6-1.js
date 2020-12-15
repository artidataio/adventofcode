const fs = require('fs')
let arr = fs.readFileSync('6.txt', 'utf8').split('\n')

let group = []
let counter = 0
for (let elem of arr){
  if(elem === ''){
    let unique = new Set(group)
    counter += unique.size
    group = []
  } else {
    group.push(...elem)
  }
}
//ending corner case
let unique = new Set(group)
    counter += unique.size
    
console.log(counter)