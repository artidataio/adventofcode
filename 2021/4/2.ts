import { readFileSync } from 'fs'
const {
  isBingo,
  hasBingo,
  locateNum,
  updateMark,
  generateMark,
  computeSum,
} = require('./util')
const arr = readFileSync('./1.txt', 'utf8').split('\n')

const sequence = arr[0].split(',').map((val) => parseInt(val))

//boards setup
const boards: number[][][] = []

arr.slice(1).forEach((val, ind) => {
  const i = Math.floor(ind / 6)
  const j = (ind % 6) - 1
  if (j === -1) {
    boards[i] = []
  } else if (j >= 0) {
    boards[i][j] = val
      .split(' ')
      .map((val) => parseInt(val))
      .filter((val) => !isNaN(val))
  }
})

const marks = new Array(boards.length).fill([]).map((val) => generateMark())
let winners: number[] = []
outer: for (let i = 0; i < sequence.length; i++) {
  for (let j = 0; j < boards.length; j++) {
    if (winners.includes(j)) {
      continue
    }
    const locateIJ = locateNum(boards[j], sequence[i])
    if (locateIJ[0] >= 0 && locateIJ[1] >= 0) {
      const markNew = updateMark(marks[j], locateIJ)
      if (hasBingo(markNew)) {
        winners = [...winners, j]
        if (winners.length === boards.length) {
          console.log(computeSum(boards[j], markNew) * sequence[i])
          break outer
        }
      }
      marks[j] = markNew
    }
  }
}
