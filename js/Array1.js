function assertEquals(a, b) {
    if (a !== b) {
        console.error("expected : " + a + "  but actual : " + b);
    }
}

const number = 123;

function execute(number,numbers) {
    let str = numbers;
    if (number < 1) {
        const resultString = str.reverse().join();
        return resultString;
    }
    const digit = number % 10;
    const remainNumber = Math.floor(number / 10);
    str.push(digit);
    execute(remainNumber,str);

}

function number2String(number) {
    return execute(number,[]);
}

assertEquals(number2String(number), "123");