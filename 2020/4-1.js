const fs = require('fs')
let arr1 = fs.readFileSync('4-test.txt', 'utf8').split('\n')
let arr2 = []
let passport = []
for(let elem of arr1){
  if(elem==''){
    arr2.push(passport)
    passport = []
  } else {
    passport.push(...elem.split(' '))
  }
}
console.log(arr2.map(v=>v.map(w=>w.slice(0,3))))