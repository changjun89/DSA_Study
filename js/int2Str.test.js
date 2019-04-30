const int2Str = require("./int2Str");

test("int를 str로 바꾼다." ,() => {
    const input =123;
    expect(int2Str.int2Str(input)).toBe("123");
});


test("첫째자리를 가지고온다.." ,() => {
    const input =123;
    expect(int2Str.digit(input)).toBe(3);
});


test("1의자리수를 버린다.." ,() => {
    const input =123;
    expect(int2Str.remainNumber(input)).toBe(12);
});


