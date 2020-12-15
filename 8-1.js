const fs = require('fs')
let instructions = fs.readFileSync('8.txt', 'utf8').split('\n')
instructions = instructions.map(v=>v.split(' '))

const history = []
let curr = 0
let acc = 0
while(history.indexOf(curr)<0){
  switch(instructions[curr][0]){
    case 'nop':
      history.push(curr)
      curr += 1
      break
    case 'acc':
      history.push(curr)
      acc += eval(instructions[curr][1])
      curr += 1
      break
    case 'jmp':
      history.push(curr)
      curr += eval(instructions[curr][1])
      break
  }
}
console.log(acc)