import { readFileSync } from "fs";

const alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
const priority = (char: string) => alphabet.indexOf(char) + 1;

const intersect = (a: Array<string>, b: Array<string>) => {
  return a.filter((val) => b.includes(val));
};

let out = 0;
let arr = readFileSync("3/input.txt", "utf8")
  .split(/\r?\n/)
  .map((val) => [
    val.slice(0, val.length / 2).split(""),
    val.slice(val.length / 2).split(""),
  ])
  .map((val) => intersect(val[0], val[1]))
  .forEach((val, ind) => {
    out += priority(val[0]);
  });

console.log(out);
//7817
