import { readFileSync } from 'fs'
const { getNeighbourCoords } = require('./util')

const arr = readFileSync('./1.txt', 'utf8')
  .split('\n')
  .map((val1) => val1.split('').map((val2) => parseInt(val2)))

let count = 0
for (let row = 0; row < arr.length; row++) {
  for (let col = 0; col < arr[0].length; col++) {
    const cell = arr[row][col]
    const neighbours = getNeighbourCoords(
      [row, col],
      arr.length,
      arr[0].length
    ).map((val: number[]) => arr[val[0]][val[1]])
    count += neighbours.every((val: number) => val > cell) ? cell + 1 : 0
  }
}

console.log(count)
