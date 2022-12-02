import { readFileSync } from "fs";
let arr = readFileSync("1/1.txt", "utf8").split(/\r?\n/);

let current = 0;
let max = 0;
for (let i = 0; i < arr.length; i++) {
  if (arr[i].length === 0) {
    if (current > max) {
      max = current;
    }
    current = 0;
  } else {
    current += parseInt(arr[i]);
  }
}
//corner case
if (current > max) {
  max = current;
}

console.log(max);
