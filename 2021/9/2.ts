import { readFileSync } from 'fs'
const { getNeighbourCoords } = require('./util')

const arr = readFileSync('./1.txt', 'utf8')
  .split('\n')
  .map((val1) => val1.split('').map((val2) => parseInt(val2)))

let label = 0 //-1 forblock or missing
let basin: number[][] = new Array(arr.length)
  .fill([])
  .map((val) => new Array(arr[0].length).fill(-1))
let link: Record<number, number[][]> = {}

for (let row = 0; row < arr.length; row++) {
  for (let col = 0; col < arr[0].length; col++) {
    const cell = arr[row][col]
    if (cell === 9) {
      continue
    }
    let topLabel = row > 0 ? basin[row - 1][col] : -1
    let leftLabel = col > 0 ? basin[row][col - 1] : -1
    if (leftLabel === -1 && topLabel === -1) {
      basin[row][col] = label
      link[label] = [[row, col]]
      label++
    } else if (leftLabel > -1 && topLabel === -1) {
      basin[row][col] = leftLabel
      link[leftLabel].push([row, col])
    } else if (leftLabel === -1 && topLabel > -1) {
      basin[row][col] = topLabel
      link[topLabel].push([row, col])
    } else if (leftLabel === topLabel) {
      basin[row][col] = topLabel
      link[topLabel].push([row, col])
    } else if (leftLabel !== topLabel) {
      const minLabel = Math.min(leftLabel)
      const maxLabel = Math.max(topLabel)
      basin[row][col] = minLabel
      link[minLabel].push([row, col])
      link[maxLabel].forEach((val) => {
        basin[val[0]][val[1]] = minLabel
        link[minLabel].push(val)
      })
      delete link[maxLabel]
    }
  }
}

const sizes = Object.values(link)
  .map((val) => val.length)
  .sort((a, b) => b - a)

console.log(sizes[0] * sizes[1] * sizes[2])
