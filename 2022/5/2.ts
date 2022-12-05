import { readFileSync } from "fs";

const input = readFileSync("5/input.txt", "utf8").split(/\r?\n/);
const indexSpacer = input.indexOf("");
const numStack = (input[indexSpacer - 1].length + 1) / 4;

let arr = new Array(numStack).fill("");

for (let i = indexSpacer - 2; i >= 0; i--) {
  for (let j = 0; j < numStack; j++) {
    if (input[i][j * 4 + 1] != " ") {
      arr[j] += input[i][j * 4 + 1];
    }
  }
}

for (let i = indexSpacer + 1; i < input.length; i++) {
  const split = input[i].split(" ");
  const crate = parseInt(split[1]);
  const from = parseInt(split[3]) - 1;
  const to = parseInt(split[5]) - 1;

  const move = arr[from].substring(arr[from].length - crate);
  arr[from] = arr[from].substring(0, arr[from].length - crate);
  arr[to] = arr[to] + move;
}
const out = arr.map((val) => val[val.length - 1]).join("");
console.log(out);
