import { readFileSync } from 'fs'
const { foldX, foldY, countUniqCoord } = require('./util')

const arr = readFileSync('./input.txt', 'utf8').split('\n')

const blank = arr.indexOf('')

let arr1 = arr
  .slice(0, blank)
  .map((val1) => val1.split(',').map((val2) => parseInt(val2)))

const arr2 = arr.slice(blank + 1)

for (let i = 0; i < arr2.length; i++) {
  const str = arr2[i][11]
  const int = parseInt(arr2[i].slice(13))
  if (str === 'x') {
    arr1 = arr1.map((val) => foldX(int, val))
  } else if (str === 'y') {
    arr1 = arr1.map((val) => foldY(int, val))
  }
}

const strings = new Set(arr1.map((val) => val.join(',')))
for (let i = 0; i < 6; i++) {
  let str = ''
  for (let j = 0; j < 40; j++) {
    if (strings.has(`${j},${i}`)) {
      str += '#'
    } else {
      str += '.'
    }
  }
  console.log(str)
}
