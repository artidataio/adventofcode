import { readFileSync } from 'fs'
const { getCoords, generateKeys, countOverlap } = require('./util')
const arr = readFileSync('./1.txt', 'utf8').split('\n')

const obj: Record<string, number> = {}

arr.forEach((val1) => {
  const keys = generateKeys(getCoords(val1))
  keys.forEach((val2: string) => {
    if (obj.hasOwnProperty(val2)) {
      obj[val2] += 1
    } else {
      obj[val2] = 1
    }
  })
})

console.log(countOverlap(obj))
