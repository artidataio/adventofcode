import { readFileSync } from "fs";

const mapOpp = {
  A: "rock",
  B: "paper",
  C: "scissors",
};

type Opp = "A" | "B" | "C";
type Res = "Y" | "X" | "Z";
const getPoint = (opp: Opp, res: Res) => {
  const valOpp = mapOpp[opp];

  let valYou: "rock" | "paper" | "scissors";
  if (
    (res === "X" && valOpp === "paper") ||
    (res === "Y" && valOpp === "rock") ||
    (res === "Z" && valOpp === "scissors")
  ) {
    valYou = "rock";
  } else if (
    (res === "X" && valOpp === "scissors") ||
    (res === "Y" && valOpp === "paper") ||
    (res === "Z" && valOpp === "rock")
  ) {
    valYou = "paper";
  } else {
    valYou = "scissors";
  }

  let point1;
  switch (valYou) {
    case "rock":
      point1 = 1;
      break;
    case "paper":
      point1 = 2;
      break;
    case "scissors":
      point1 = 3;
      break;
  }

  let point2;
  switch (res) {
    case "X":
      point2 = 0;
      break;
    case "Y":
      point2 = 3;
      break;
    case "Z":
      point2 = 6;
      break;
    default:
      point2 = 0;
  }

  return point1 + point2;
};

let arr = readFileSync("2/1.txt", "utf8")
  .split(/\r?\n/)
  .map((val) => val.split(" "));

let out = 0;
arr.forEach((val) => {
  out += getPoint(val[0] as Opp, val[1] as Res);
});

console.log(out);
//10498
