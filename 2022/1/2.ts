import { readFileSync } from "fs";
let arr = readFileSync("1/1.txt", "utf8").split(/\r?\n/);
arr.push("");

let current = 0;
let top3 = [0, 0, 0];
for (let i = 0; i < arr.length; i++) {
  if (arr[i].length === 0) {
    if (current > top3[0]) {
      top3 = [current, top3[0], top3[1]];
    } else if (current > top3[1]) {
      top3 = [top3[0], current, top3[1]];
    } else if (current > top3[2]) {
      top3 = [top3[0], top3[1], current];
    }
    current = 0;
  } else {
    current += parseInt(arr[i]);
  }
}

console.log(top3[0] + top3[1] + top3[2]);
//197301
