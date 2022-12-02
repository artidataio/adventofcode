import { readFileSync } from "fs";
let arr = readFileSync("1/1.txt", "utf8").split(/\r?\n/);
console.log(arr);
