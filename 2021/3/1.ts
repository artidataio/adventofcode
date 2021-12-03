import fs = require('fs')

let arr = fs.readFileSync('./1.txt', 'utf8').split('\n')

let count0 = Array(arr[0].length).fill(0)
arr.forEach((val) => {
  ;[...val].map((val, ind) => {
    count0[ind] += val === '0' ? 1 : 0
  })
})
let gamma = ''
let epsilon = ''

count0.forEach((val) => {
  //question didn't mention on even condition
  if (val >= arr.length / 2) {
    gamma += '0'
    epsilon += '1'
  } else {
    gamma += '1'
    epsilon += '0'
  }
})

console.log(parseInt(gamma, 2) * parseInt(epsilon, 2))
