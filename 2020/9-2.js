const fs = require('fs')
let arr = fs.readFileSync('9.txt', 'utf8').split('\n')
arr = arr.map(val=>Number(val)) 
let out
let preamble = 25
let combination=[]
for(let i=0; i<preamble; i++){
  let id = arr[i] 
  let values = []
  for(let j=i+1; j<preamble; j++){
    values.push(arr[i]+arr[j])
  }
  let elem = {id: id,values:values}
  combination.push(elem)
}

for(let i=preamble;i<arr.length;i++){
  let id = arr[i]
  if(combination.map(v=>v.values).flat().indexOf(id)<0){
    out = id
    break
  } else {
    combination.shift()
    for(let elem of combination){
      elem.values.push(elem.id+id)
    }
    combination.push({id:id,values:[]})
  }
}
console.log(out)

let i = 0
let ids = [arr[i]]
let sum = arr[i]
while (sum!==out){
  i += 1
  sum += arr[i]
  ids.push(arr[i]) 
  if(sum < out){
    continue
  } else if(sum>out){
    while(sum>out){
      sum -= ids[0]
      ids.shift()
    }
  } else {
    break
  }
}
console.log(sum)
console.log(Math.min(...ids)+Math.max(...ids))