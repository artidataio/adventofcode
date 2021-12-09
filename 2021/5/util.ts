function getCoords(str: string): number[][] {
  return str
    .split(' -> ')
    .map((val1) => val1.split(',').map((val2) => parseInt(val2)))
}

// // Test Cases
// console.log(getCoords('0,9 -> 5,9'))
// // [ [ 0, 9 ], [ 5, 9 ] ]

function generateSeq(int1: number, int2: number): number[] {
  return new Array(Math.abs(int1 - int2) + 1)
    .fill(1)
    .map((val, ind) => ind + Math.min(int1, int2))
}

// // Test Cases
// console.log(generateSeq(1, 2))
// //[ 1, 2 ]
// console.log(generateSeq(3, 1))
// //[ 1, 2, 3 ]

function generateSeq2(int1: number, int2: number): number[] {
  return new Array(Math.abs(int1 - int2) + 1)
    .fill(1)
    .map((val, ind) => int1 + ind * (int2 > int1 ? 1 : -1))
}

// // Test Cases
// console.log(generateSeq2(1, 2))
// //[ 1, 2 ]
// console.log(generateSeq2(3, 1))
// //[ 3, 2, 1 ]

function generateKeys(arr: number[][]): string[] {
  const isEqualX1X2 = arr[0][0] === arr[1][0]
  const isEqualY1Y2 = arr[0][1] === arr[1][1]
  if (isEqualX1X2 && !isEqualY1Y2) {
    return generateSeq(arr[0][1], arr[1][1]).map((val) => `${arr[0][0]},${val}`)
  } else if (isEqualY1Y2 && !isEqualX1X2) {
    return generateSeq(arr[0][0], arr[1][0]).map((val) => `${val},${arr[0][1]}`)
  } else {
    return []
  }
}

// // Test Cases
// console.log(
//   generateKeys([
//     [0, 9],
//     [5, 9],
//   ])
// )
// //[ '0,9', '1,9', '2,9', '3,9', '4,9', '5,9' ]
// console.log(
//   generateKeys([
//     [3, 4],
//     [3, 5],
//   ])
// )
// //[ '3,4', '3,5' ]
// console.log(
//   generateKeys([
//     [0, 6],
//     [5, 7],
//   ])
// )
// //[]

function join(arr1: number[], arr2: number[]): string[] {
  let out: string[] = []
  for (let i = 0; i < arr1.length; i++) {
    out = out.concat([`${arr1[i]},${arr2[i]}`])
  }
  return out
}

// // Test Cases
// console.log(join([1, 2], [3, 4]))
// //[ '1,3', '2,4' ]
// console.log(join([2, 3, 4], [2, 3, 4]))
// //[ '2,2', '3,3', '4,4' ]

function generateKeys2(arr: number[][]): string[] {
  const isEqualX1X2 = arr[0][0] === arr[1][0]
  const isEqualY1Y2 = arr[0][1] === arr[1][1]
  if (isEqualX1X2 && !isEqualY1Y2) {
    return generateSeq(arr[0][1], arr[1][1]).map((val) => `${arr[0][0]},${val}`)
  } else if (isEqualY1Y2 && !isEqualX1X2) {
    return generateSeq(arr[0][0], arr[1][0]).map((val) => `${val},${arr[0][1]}`)
  } else {
    return join(
      generateSeq2(arr[0][0], arr[1][0]),
      generateSeq2(arr[0][1], arr[1][1])
    )
  }
}

// // Test Cases
// console.log(
//   generateKeys2([
//     [0, 9],
//     [5, 9],
//   ])
// )
// //[ '0,9', '1,9', '2,9', '3,9', '4,9', '5,9' ]
// console.log(
//   generateKeys2([
//     [3, 4],
//     [3, 5],
//   ])
// )
// //[ '3,4', '3,5' ]
// console.log(
//   generateKeys2([
//     [5, 5],
//     [8, 2],
//   ])
// )
// //[ '5,5', '6,4', '7,3', '8,2' ]

function countOverlap(obj: object): number {
  return Object.values(obj).filter((val) => val >= 2).length
}

// // Test Cases
// console.log(countOverlap({ '0,0': 1, '0,1': 2, '0,3': 1 }))
// // 1

module.exports = {
  getCoords,
  generateKeys,
  generateKeys2,
  countOverlap,
}
