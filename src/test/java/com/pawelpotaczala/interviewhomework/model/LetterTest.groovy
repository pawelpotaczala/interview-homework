package com.pawelpotaczala.interviewhomework.model

import spock.lang.Specification
import spock.lang.Unroll

class LetterTest extends Specification {

    @Unroll
    def "char should be a letter"() {
        given: "a char from test cases"
        def c = CHAR

        when: "initialize a new Letter"
        Letter.of(c as char)

        then: "should not throw an exception"
        noExceptionThrown()

        where: "test cases are below"
        CHAR | _
        'a'  | _
        'b'  | _
        't'  | _
        'A'  | _
        'G'  | _
        'H'  | _
        'Z'  | _
    }

    @Unroll
    def "char should not be a letter"() {
        given: "a char from test cases"
        def c = CHAR

        when: "initialize a new Letter"
        Letter.of(c as char)

        then: "should throw an IllegalArgumentException"
        thrown(IllegalArgumentException)

        where: "test cases are below"
        CHAR      | _
        '`'       | _
        '~'       | _
        '1'       | _
        '!'       | _
        '2'       | _
        '@'       | _
        '3'       | _
        '#'       | _
        '4'       | _
        '$'       | _
        '5'       | _
        '%'       | _
        '6'       | _
        '^'       | _
        '7'       | _
        '&'       | _
        '8'       | _
        '*'       | _
        '9'       | _
        '('       | _
        '0'       | _
        ')'       | _
        '-'       | _
        '_'       | _
        '='       | _
        '+'       | _
        '['       | _
        '{'       | _
        ']'       | _
        '}'       | _
        '\\'      | _
        '|'       | _
        ';'       | _
        ':'       | _
        '\''      | _
        '"'       | _
        '|'       | _
        ','       | _
        '>'       | _
        '.'       | _
        '>'       | _
        '/'       | _
        '?'       | _
        ' '       | _
        '\b'      | _
        '\f'      | _
        '\n'      | _
        '\r'      | _
        '\t'      | _
    }
}
