const fs = require('fs')
let arr = fs.readFileSync('6.txt', 'utf8').split('\n')

let group = {people:0,data:{}}
let counter = 0
for (let elem of arr){
  if(elem === ''){
    counter += Object.keys(group.data).filter(v=>group.data[v]===group.people).length
    group = {people:0,data:{}}
  } else {
    group.people += 1;
    [...elem].forEach(v => {
      if(typeof(group.data[v])==='undefined'){
        group.data[v] = 1
      } else{
        group.data[v] += 1
      }})}}
//ending corner case
counter += Object.keys(group.data).filter(v=>group.data[v]===group.people).length
console.log(counter)