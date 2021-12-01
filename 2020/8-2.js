const fs = require('fs')
let instructions = fs.readFileSync('8.txt', 'utf8').split('\n')
instructions = instructions.map(v=>v.split(' '))

let history = []
let curr = 0
let acc = 0
let change
let accChange
while(curr<instructions.length){
  if(history.indexOf(curr)<0){
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
  } else {
    if(typeof(change) !== 'undefined'){
      history = history.slice(0,history.indexOf(change))
      acc = accChange
    }
    change = history.pop()
    //accChange = acc
    while (['nop','jmp'].indexOf(instructions[change][0])<0){
      //reverse the acc
      acc -= eval(instructions[change][1])
      change = history.pop()
    }
    accChange = acc
    curr = change
    switch(instructions[curr][0]){
      case 'nop':
        history.push(curr)
        curr += eval(instructions[curr][1])
        break
      case 'jmp':
        history.push(curr)
        curr += 1
        break
    }
  }
}
console.log(acc)