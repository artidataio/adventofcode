import { readFileSync } from 'fs'
const { foldX, foldY, countUniqCoord } = require('./util')

const arr = readFileSync('./input.txt', 'utf8').split('\n')

const blank = arr.indexOf('')

const arr1 = arr
  .slice(0, blank)
  .map((val1) => val1.split(',').map((val2) => parseInt(val2)))

const arr2 = arr.slice(blank + 1)

console.log(countUniqCoord(arr1.map((val) => foldX(655, val))))
