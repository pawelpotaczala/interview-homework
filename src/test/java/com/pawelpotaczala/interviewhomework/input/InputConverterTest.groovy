package com.pawelpotaczala.interviewhomework.input

import com.pawelpotaczala.interviewhomework.UnitTestUtils
import spock.lang.Specification
import spock.lang.Unroll

class InputConverterTest extends Specification {

    @Unroll
    def "'indexEachLetterToWordsFrom' should correctly assign letters their words"() {
        given: "a text from test cases"
        def input = INPUT
        and: "expected result of 'indexEachLetterToWordsFrom' method"
        def expected = UnitTestUtils.transform(OUTPUT)

        when: "invoke real 'indexEachLetterToWordsFrom' method"
        def actual = InputConverter.indexEachLetterToWordsFrom(input)

        then: "should not throw an exception"
        noExceptionThrown()
        and: "make sure that results are equal"
        actual == expected
        and: "make sure entries are defined in the same order"
        actual.collect { it.key } == expected.collect { it.key }

        where: "test cases are below"
        INPUT                                  | OUTPUT
        "ala ma kota"                          | ['a': ['ala', 'kota', 'ma'], 'k': ['kota'], 'l': ['ala'], 'm': ['ma'], 'o': ['kota'], 't': ['kota']]
        "ala ma kota, kot koduje w Javie Kota" | ['a': ['ala', 'javie', 'kota', 'ma'], 'd': ['koduje'], 'e': ['javie', 'koduje'], 'i': ['javie'], 'j': ['javie', 'koduje'], 'k': ['koduje', 'kot', 'kota'], 'l': ['ala'], 'm': ['ma'], 'o': ['koduje', 'kot', 'kota'], 't': ['kot', 'kota'], 'u': ['koduje'], 'v': ['javie'], 'w': ['w']]
    }

    @Unroll
    def "'indexEachLetterToWordsFrom' should throw a runtime exception"() {
        given: "a text from test cases"
        def text = TEXT

        when: "invoke 'indexEachLetterToWordsFrom' method"
        InputConverter.indexEachLetterToWordsFrom(text)

        then: "should throw an exception equals to expected"
        def exception = thrown(EXCEPTION)
        and: "message from exception should be equal to expected"
        exception.message == MESSAGE

        where: "test cases are below"
        TEXT                                        | EXCEPTION                | MESSAGE
        null                                        | NullPointerException     | "Text cannot be null"
        ""                                          | IllegalArgumentException | "Text must contain words"
        "  "                                        | IllegalArgumentException | "Text must contain words"
        "Ala ma kota*"                              | IllegalArgumentException | "String must contain only eng. letters, whitespace characters, commas and dots. Incorrect 1 chains of characters: *"
        " Ala 67 *     "                            | IllegalArgumentException | "String must contain only eng. letters, whitespace characters, commas and dots. Incorrect 2 chains of characters: 67 *"
        "Kotre=()! \\"                              | IllegalArgumentException | "String must contain only eng. letters, whitespace characters, commas and dots. Incorrect 2 chains of characters: =()! \\"
        "!2ala ma kota, ko&t koduje98 w Javie Kota" | IllegalArgumentException | "String must contain only eng. letters, whitespace characters, commas and dots. Incorrect 3 chains of characters: !2 & 98"
    }
}
