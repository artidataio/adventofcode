import { readFileSync } from 'fs'

let arr = readFileSync('./1.txt', 'utf8').split('\n')

let o2 = [...arr]

for (let i = 0; i < arr[0].length; i++) {
  if (o2.length === 1) {
    break
  }
  let arr0: string[] = []
  let arr1: string[] = []
  o2.forEach((val) => {
    if (val[i] === '0') {
      arr0.push(val)
    } else {
      arr1.push(val)
    }
  })
  o2 = arr1.length >= arr0.length ? arr1 : arr0
}

let co2 = [...arr]

for (let i = 0; i < arr[0].length; i++) {
  if (co2.length === 1) {
    break
  }
  let arr0: string[] = []
  let arr1: string[] = []
  co2.forEach((val) => {
    if (val[i] === '0') {
      arr0.push(val)
    } else {
      arr1.push(val)
    }
  })
  co2 = arr0.length <= arr1.length ? arr0 : arr1
}

console.log(parseInt(o2[0], 2) * parseInt(co2[0], 2))
