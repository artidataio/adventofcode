const fs = require('fs')
let arr = fs.readFileSync('15.txt', 'utf8').split(',').map(v=>Number(v))
let latest = arr.pop()

let maxTurn = 100000
let turn = arr.length + 2
console.time('test')
while(turn<=maxTurn){
  let indexLatest = arr.lastIndexOf(latest)
  if(indexLatest<0){
    arr.push(latest)
    latest = 0 
  } else {
    arr.push(latest)
    latest = turn-indexLatest-2
  }
  turn++
}
console.log(`${turn-1} : ${latest}`)
console.timeEnd('test')  