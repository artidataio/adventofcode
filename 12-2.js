var fs = require('fs')

var instructions = fs.readFileSync('12.txt', 'utf8').split('\n')

let ship = {
  x:0,
  y:0,
  waypoint: {x:10,y:1},
  
  move: function(t){
    this.x += t*this.waypoint.x
    this.y += t*this.waypoint.y 
  },
  
  moveWaypoint: function(dir,step){
    switch(dir){
      case 'N':
        this.waypoint.y += step
        break
      case 'E':
        this.waypoint.x += step
        break
      case 'S':
        this.waypoint.y -= step
        break
      case 'W':
        this.waypoint.x -= step
        break
    }},
    
  turnWaypoint: function(nav,degree){
    
    let xNew,
        yNew
        
    if (nav==='R'){
      degree = - 1*degree
    }
    xNew = Math.round(this.waypoint.x*Math.cos(degree*Math.PI/180) - this.waypoint.y*Math.sin(degree*Math.PI/180))
    yNew = Math.round(this.waypoint.x*Math.sin(degree*Math.PI/180) + this.waypoint.y*Math.cos(degree*Math.PI/180))
    
    this.waypoint.x = xNew
    this.waypoint.y = yNew
  }
    
}

for(let instruction of instructions){
  let action = instruction[0]
  let value = Number(instruction.slice(1,instruction.length))
  if(action==='F'){
    ship.move(value)
  } else if(['N','E','S','W'].indexOf(action)>=0){
    ship.moveWaypoint(action,value)
  } else if(['L','R'].indexOf(action)>=0){
    ship.turnWaypoint(action,value)
  }
}

console.log(Math.abs(ship.x)+Math.abs(ship.y))