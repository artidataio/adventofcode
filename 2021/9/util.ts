//assuming at least matrix 3 x 3
function getNeighbourCoords(
  coords: number[],
  nRow: number,
  nCol: number
): number[][] {
  let out: number[][] = []
  //adding top neighbour
  if (coords[0] > 0) {
    out.push([coords[0] - 1, coords[1]])
  }
  //adding left neighbour
  if (coords[1] > 0) {
    out.push([coords[0], coords[1] - 1])
  }
  //adding bottom neighbour
  if (coords[0] < nRow - 1) {
    out.push([coords[0] + 1, coords[1]])
  }
  //adding right neighbour
  if (coords[1] < nCol - 1) {
    out.push([coords[0], coords[1] + 1])
  }
  return out
}

// //Test Cases
// console.log(getNeighbourCoords([0, 0], 4, 4)) //top-left corner
// //[ [ 1, 0 ], [ 0, 1 ] ]
// console.log(getNeighbourCoords([0, 3], 3, 4)) //top-right corner
// //[ [ 0, 2 ], [ 1, 3 ] ]
// console.log(getNeighbourCoords([3, 4], 4, 5)) //bottom-right corner
// //[ [ 2, 4 ], [ 3, 3 ] ]
// console.log(getNeighbourCoords([0, 4], 4, 5)) //top-right corner
// //[ [ 0, 3 ], [ 1, 4 ] ]
// console.log(getNeighbourCoords([1, 2], 3, 5)) //middle
// //[ [ 0, 2 ], [ 1, 1 ], [ 2, 2 ], [ 1, 3 ] ]

module.exports = {
  getNeighbourCoords,
}
