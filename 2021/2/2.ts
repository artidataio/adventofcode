import { readFileSync } from 'fs'

let arr = readFileSync('./1.txt', 'utf8').split('\n')

let a = 0
let h = 0
let v = 0

arr.forEach((val) => {
  let ins: string
  let num: string | number
  ;[ins, num] = val.split(' ')
  num = parseInt(num)

  switch (ins) {
    case 'forward':
      h += num
      v += a * num
      break
    case 'down':
      a += num
      break
    case 'up':
      a -= num
      break
  }
})

console.log(h * v)
