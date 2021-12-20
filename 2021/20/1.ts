import { readFileSync } from 'fs'

const raw = readFileSync('./input.txt', 'utf8').split('\n')
const sepIdx = raw.indexOf('')

const algo = raw
  .slice(0, sepIdx)
  .map((val) => [...val])
  .flat()
console.log(algo)

let input = raw.slice(sepIdx + 1).map((val) => [...val])

for (let turn = 1; turn <= 2; turn++) {
  let nRow = input.length
  let nCol = input.length
  console.log(nRow)
  console.log(nCol)
  for (let i = 0; i < nCol; i++) {
    input[i].unshift('.', '.')
    input[i].push('.', '.')
  }
  input.unshift(new Array(nRow + 4).fill('.'), new Array(nRow + 4).fill('.'))
  input.push(new Array(nRow + 4).fill('.'), new Array(nRow + 4).fill('.'))

  let inputNew: string[][] = []
  for (let row = 1; row < input.length - 1; row++) {
    let rowNew: string[] = []
    for (let col = 1; col < input[0].length - 1; col++) {
      const box = [
        input[row - 1][col - 1],
        input[row - 1][col],
        input[row - 1][col + 1],
        input[row][col - 1],
        input[row][col],
        input[row][col + 1],
        input[row + 1][col - 1],
        input[row + 1][col],
        input[row + 1][col + 1],
      ]
      rowNew.push(
        algo[parseInt(box.map((val) => (val === '#' ? '1' : '0')).join(''), 2)]
      )
    }
    inputNew.push(rowNew)
  }
  input = inputNew
}
console.log(input.flat().filter((val) => val === '#').length)
