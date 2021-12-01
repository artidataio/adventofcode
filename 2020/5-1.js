const fs = require('fs')

let arr = fs.readFileSync('5.txt', 'utf8').split('\n')

function getIntFromBin(str,truthy){
  let out = 0;
  [...str].forEach((v,i) => out += v===truthy ? Math.pow(2,str.length-(i+1)) : 0)
  return out
}

function getSeatID(str){
  return getIntFromBin(str.slice(0,7),'B') * 8 + getIntFromBin(str.slice(7,10),'R')
}

let seatIDs = arr.map(v=>getSeatID(v))
console.log(seatIDs.length)
console.log(Math.max(...seatIDs))