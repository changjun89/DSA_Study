const reverseModule = require("./reverseSentence");

test('문자열 거꾸로 테스트',() =>{
    const input = "I am a boy";
    expect(reverseModule.reverseSentence(input)).toBe("boy a am I");
});

test('맨 앞자리 짜르기',() =>{
    const input = "I am a boy";
    expect(reverseModule.parseWord(input)).toBe("I");
})

test('문장에서 맨 앞자리 없애기',() =>{
    const input = "I am a boy";
    expect(reverseModule.cutSentence(input)).toBe("am a boy");
})

