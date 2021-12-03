import { readFileSync } from 'fs'

let arr = readFileSync('./1.txt', 'utf8').split('\n')

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
      break
    case 'down':
      v += num
      break
    case 'up':
      v -= num
      break
  }
})

console.log(h * v)
