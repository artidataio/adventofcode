import { readFileSync } from "fs";

const hasFullyContains = (
  start1: number,
  end1: number,
  start2: number,
  end2: number
) => {
  return (
    (start1 <= start2 && end1 >= end2) || (start2 <= start1 && end2 >= end1)
  );
};

const arr = readFileSync("4/input.txt", "utf8")
  .split(/\r?\n/)
  .map((val) => val.split(",").map((val2) => val2.split("-")))
  .filter((val) =>
    hasFullyContains(
      parseInt(val[0][0]),
      parseInt(val[0][1]),
      parseInt(val[1][0]),
      parseInt(val[1][1])
    )
  );

console.log(arr.length);
