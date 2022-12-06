import { readFileSync } from "fs";
const input = readFileSync("6/input.txt", "utf8").split("");

let curr = input.slice(0, 14);
let i = 0;
for (i; i < input.length; i++) {
  if (curr.length === new Set(curr).size) {
    break;
  } else {
    curr = input.slice(i + 1, i + 15);
  }
}
console.log(i + 14);
