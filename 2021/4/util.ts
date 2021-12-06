function isBingo(arr: number[]): boolean {
  return arr.every((val) => val === 1)
}

// //Test cases
// const sample1 = [0,0,0,0,1]
// const sample2 = [1,1,1,1,1]
// console.log(isBingo(sample1)) //false
// console.log(isBingo(sample2)) //true

function hasBingo(arr2d: number[][]): boolean {
  for (let i = 0; i < 5; i++) {
    if (isBingo(arr2d[i])) {
      return true
    }
    if (isBingo(arr2d.map((val) => val[i]))) {
      return true
    }
  }
  return false
}

// // Test cases
// const sample1 = [
//   [0, 0, 0, 0, 0],
//   [0, 0, 0, 0, 1],
//   [0, 0, 0, 0, 1],
//   [0, 0, 0, 0, 1],
//   [0, 0, 0, 0, 1],
// ]

// const sample2 = [
//   [0, 0, 0, 0, 1],
//   [0, 0, 0, 0, 1],
//   [0, 0, 0, 0, 1],
//   [0, 0, 0, 0, 1],
//   [0, 0, 0, 0, 1],
// ]

// console.log(hasBingo(sample1)) //false
// console.log(hasBingo(sample2)) //true

function locateNum(arr2d: number[][], num: number): number[] {
  for (let i = 0; i < 5; i++) {
    const ind = arr2d[i].indexOf(num)
    if (ind >= 0) {
      return [i, ind]
    }
  }
  return [-1, -1]
}

// //Test cases
// const sample = [
//   [22, 13, 17, 11, 0],
//   [8, 2, 23, 4, 24],
//   [21, 9, 14, 16, 7],
//   [6, 10, 3, 18, 5],
//   [1, 12, 20, 15, 19],
// ]

// console.log(locateNum(sample, 20)) //[4,2]

function updateBoard(arr2d: number[][], ind: number[]): number[][] {
  arr2d[ind[0]][ind[1]] = 1
  return [
    ...arr2d.slice(0, ind[0]),
    [...arr2d[ind[0]].slice(0, ind[1]), 1, ...arr2d[ind[0]].slice(ind[1] + 1)],
    ...arr2d.slice(ind[0] + 1),
  ]
}

// // Test cases
// const sample = [
//   [0, 0, 0, 0, 0],
//   [0, 0, 0, 0, 1],
//   [0, 0, 0, 0, 1],
//   [0, 0, 0, 0, 1],
//   [0, 0, 0, 0, 1],
// ]

// console.log(updateBoard(sample, [1, 3]))
// // [
// //   [ 0, 0, 0, 0, 1 ],
// //   [ 0, 0, 0, 0, 1 ],
// //   [ 0, 0, 0, 0, 1 ],
// //   [ 0, 0, 0, 0, 1 ],
// //   [ 0, 0, 0, 0, 1 ]
// // ]

function generateBoard(): number[][] {
  return new Array(5).fill([]).map((val) => new Array(5).fill(0))
}

// // Test cases
// console.log(generateBoard())
// // [
// //   [ 0, 0, 0, 0, 0 ],
// //   [ 0, 0, 0, 0, 0 ],
// //   [ 0, 0, 0, 0, 0 ],
// //   [ 0, 0, 0, 0, 0 ],
// //   [ 0, 0, 0, 0, 0 ]
// // ]

function computeSum(arr2d1: number[][], arr2d2: number[][]): number {
  let count = 0
  for (let i = 0; i < 5; i++) {
    for (let j = 0; j < 5; j++) {
      count += arr2d2[i][j] === 0 ? arr2d1[i][j] : 0
    }
  }
  return count
}

// // Test cases
// console.log(
//   computeSum(
//     [
//       [14, 21, 17, 24, 4],
//       [10, 16, 15, 9, 19],
//       [18, 8, 23, 26, 20],
//       [22, 11, 13, 6, 5],
//       [2, 0, 12, 3, 7],
//     ],
//     [
//       [1, 1, 1, 1, 1],
//       [0, 0, 0, 1, 0],
//       [0, 0, 1, 0, 0],
//       [0, 1, 0, 0, 1],
//       [1, 1, 0, 0, 1],
//     ]
//   )
// ) //188

module.exports = {
  isBingo,
  hasBingo,
  locateNum,
  updateBoard,
  generateBoard,
  computeSum,
}
