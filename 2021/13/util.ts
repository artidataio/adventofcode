function foldX(int: number, coord: number[]): number[] {
  if (coord[0] < int) {
    return coord
  } else if (coord[0] > int) {
    return [coord[0] - 2 * (coord[0] - int), coord[1]]
  } else {
    return []
  }
}

// //Test Cases
// console.log(foldX(5, [9, 0])) //top-left corner
// //[ 1, 0 ]
// console.log(foldX(5, [10, 3])) //top-left corner
// //[ 0, 3 ]

function foldY(int: number, coord: number[]): number[] {
  if (coord[1] < int) {
    return coord
  } else if (coord[1] > int) {
    return [coord[0], coord[1] - 2 * (coord[1] - int)]
  } else {
    return []
  }
}

// //Test Cases
// console.log(foldY(5, [0, 9])) //top-left corner
// //[ 0, 1 ]
// console.log(foldY(5, [3, 10])) //top-left corner
// //[ 3, 0 ]

function countUniqCoord(coords: number[][]): number {
  return new Set(coords.map((val) => val.join(','))).size
}

// //Test Cases
// console.log(
//   countUniqCoord([
//     [0, 1],
//     [0, 2],
//     [2, 0],
//   ])
// )
// //3
// console.log(
//   countUniqCoord([
//     [0, 1],
//     [0, 2],
//     [2, 0],
//     [0, 1],
//     [2, 0],
//   ])
// )
// //3
module.exports = {
  foldX,
  foldY,
  countUniqCoord,
}
