const revereSentence = require("./app");
const revereSentence2 = require("./app");
const revereSentence3 = require("./app");

test('revereSentence', () => {
    expect(revereSentence("I am a boy")).toBe("boy a am I");
});

test('revereSentence2', () => {
    expect(revereSentence2("I am a boy")).toBe("boy a am I");
});
test('revereSentence3', () => {
    expect(revereSentence3("I am a boy")).toBe("boy a am I");
});