/*
 *  "I am a boy"  문자열을 "boy a am I" 로 변환
 *
 * */
function assertEquals(a, b) {
    if(a!==b) {
        console.error("expected : "+a +"  but actual : " + b);
    }
}

const centense ="I am a boy";

function revereSentence(sentence) {
    let words =[];
    if(sentence.length ==0 ){
        return;
    }
    while(sentence.indexOf(" ")>-1) {
        let idx = sentence.indexOf(" ");
        let word = sentence.substr(0, idx);
        sentence = sentence.substr(idx + 1);
        words.push(word);
    }
    words.push(sentence);
    let reverseSentence =""

    words.reverse().forEach(function (word) {
        reverseSentence += " "+word;
    });
    return reverseSentence.substr(1);

}

function revereSentence2(sentence) {
    let words =[];
    if(sentence.length ==0 ){
        return;
    }
    while(sentence.indexOf(" ")>-1) {
        let idx = sentence.indexOf(" ");
        let word = sentence.substr(0, idx);
        sentence = sentence.substr(idx + 1);
        words.push(word);
        words.push(" ");
    }
    words.push(sentence);

    let reverseSentence ="";
    words.reverse().forEach(function (word) {
        reverseSentence += word;
    })
    return reverseSentence;
}

function revereSentence3(sentence) {
    sentence += " ";
    let word="";
    let words = [];
    for(let i = 0; i<sentence.length; i++) {
        if(sentence.charAt(i) === " "){
            words.push(word);
            words.push(" ");
            word="";
        } else {
            word += sentence.charAt(i);
        }
    }

    let reverseSentence ="";
    words.reverse().forEach(function (word) {
        reverseSentence += word;
    })
    return reverseSentence.substr(1);
    
}


assertEquals("boy a am I",revereSentence(centense) );
assertEquals("boy a am I",revereSentence2(centense) );
assertEquals("boy a am I",revereSentence3(centense) );
