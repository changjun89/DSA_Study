module.exports.int2Str=int2Str;
module.exports.digit=digit;
module.exports.remainNumber=remainNumber;

let numbers =[];

function int2Str(input) {
    if(input <= 0 ) {
        return numbers.reverse().join("");
    }
    numbers.push(digit(input));
    return int2Str(remainNumber(input));
}

function digit(input) {
    return input%10;
}

function remainNumber(input) {
    return Math.floor(input/10);
}

