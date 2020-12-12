var fs = require('fs')

var instructions = fs.readFileSync('12.txt', 'utf8').split('\n')

let ship = {
  x: 0,
  y: 0,
  dir: 'E',
  move: function(dir,step){
    switch(dir){
      case 'N':
        this.y += step
        break
      case 'E':
        this.x += step
        break
      case 'S':
        this.y -= step
        break
      case 'W':
        this.x -= step
        break
    }},
  turn: function(nav,degree){
    let dirs = ['N','E','S','W']
    let curr = dirs.indexOf(this.dir)
    
    switch(nav){
      case 'R':
        curr += degree / 90
        break
      case 'L':
        curr -= degree / 90
    }
    curr = curr % 4
    if(curr<0){
      curr += 4
    }
    this.dir = dirs[curr]
  }
}

for(let instruction of instructions){
  let action = instruction[0]
  let value = Number(instruction.slice(1,instruction.length))
  if(action==='F'){
    ship.move(ship.dir,value)
  } else if(['N','E','S','W'].indexOf(action)>=0){
    ship.move(action,value)
  } else if(['L','R'].indexOf(action)>=0){
    ship.turn(action,value)
  }
}
console.log(Math.abs(ship.x)+Math.abs(ship.y))