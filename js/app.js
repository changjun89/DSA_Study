module.exports = revereSentence;
module.exports = revereSentence2;
module.exports = revereSentence3;

function assertEquals(a, b) {
    if (a !== b) {
        console.error(`expected :  + ${a} +   but actual :  + ${b}`);
    }
}



const centense = "I am a boy";

function revereSentence(sentence) {
    let words = [];
    if (sentence.length == 0) {
        return;
    }
    while (sentence.indexOf(" ") > -1) {
        let idx = sentence.indexOf(" ");
        let word = sentence.substr(0, idx);
        sentence = sentence.substr(idx + 1);
        words.push(word);
    }
    words.push(sentence);
    return words.reverse().join(" ");
}

function revereSentence2(sentence) {
    let words = [];
    if (sentence.length == 0) {
        return;
    }
    while (sentence.indexOf(" ") > -1) {
        let idx = sentence.indexOf(" ");
        let word = sentence.substr(0, idx);
        sentence = sentence.substr(idx + 1);
        words.push(word);
    }
    words.push(sentence);

    return words.reverse().join(" ");
}

function revereSentence3(sentence) {
    sentence += " ";
    let word = "";
    let words = [];
    for (let i = 0; i < sentence.length; i++) {
        if (sentence.charAt(i) === " ") {
            words.push(word);
            word = "";
        } else {
            word += sentence.charAt(i);
        }
    }
    return words.reverse().join(" ");
}


assertEquals("boy a am I", revereSentence(centense));
assertEquals("boy a am I", revereSentence2(centense));
assertEquals("boy a am I", revereSentence3(centense));
