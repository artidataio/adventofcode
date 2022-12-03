import { readFileSync } from "fs";

const alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
const priority = (char: string) => alphabet.indexOf(char) + 1;

const intersect = (a: Array<string>, b: Array<string>) => {
  return a.filter((val) => b.includes(val));
};

let arr = readFileSync("3/input.txt", "utf8")
  .split(/\r?\n/)
  .map((val) => val.split(""));

let out = 0;
for (let i = 0; i < arr.length / 3; i++) {
  out += priority(
    intersect(intersect(arr[i * 3 + 0], arr[i * 3 + 1]), arr[i * 3 + 2])[0]
  );
}
console.log(out);
