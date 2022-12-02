import { readFileSync } from "fs";

const mapOpp = {
  A: "rock",
  B: "paper",
  C: "scissors",
};

const mapYou = {
  X: "rock",
  Y: "paper",
  Z: "scissors",
};

const mapValue = {
  rock: 1,
  paper: 2,
  scissors: 3,
};

type Opp = "A" | "B" | "C";
type You = "Y" | "X" | "Z";
const getPoint = (opp: Opp, you: You) => {
  const valOpp = mapOpp[opp];
  const valYou = mapYou[you];

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
    default:
      point1 = 0;
  }

  let point2;
  if (valOpp === valYou) {
    point2 = 3;
  } else if (
    (valYou === "rock" && valOpp === "scissors") ||
    (valYou === "paper" && valOpp === "rock") ||
    (valYou === "scissors" && valOpp === "paper")
  ) {
    point2 = 6;
  } else {
    point2 = 0;
  }

  return point1 + point2;
};

let arr = readFileSync("2/1.txt", "utf8")
  .split(/\r?\n/)
  .map((val) => val.split(" "));

let out = 0;
arr.forEach((val) => {
  out += getPoint(val[0] as Opp, val[1] as You);
});

console.log(out);
//14297
