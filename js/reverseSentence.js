module.exports.reverseSentence=reverseSentence;
module.exports.parseWord=parseWord;
module.exports.cutSentence=cutSentence;

let wordList= [];

function parseWord(input) {
    return input.substr(0,input.indexOf(" "));
}

function cutSentence(input) {
    if(input.indexOf(" ") >-1){
        return input.substr(input.indexOf(" ")+1);
    }
    return input;
}

function reverseSentence(input) {
    if (input.indexOf(" ") === -1) {
        wordList.unshift(input);
        return wordList.join(" ");
    }
    wordList.unshift(parseWord(input));
    return reverseSentence(cutSentence(input));
}