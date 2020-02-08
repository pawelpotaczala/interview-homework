package com.pawelpotaczala.interviewhomework.validator


import spock.lang.Specification
import spock.lang.Unroll

class TestValidatorTest extends Specification {

    @Unroll
    def "'validate' method should not throw a runtime exception for '#TEXT'"() {
        given: "a text from test cases"
        def text = TEXT

        when: "invoke 'validate' method"
        TextValidator.validate(text)

        then: "should not throw an exception"
        noExceptionThrown()

        where: "test cases are below"
        TEXT                                                          | _
        "null"                                                        | _
        "ala ma kota, kot koduje w Javie Kota"                        | _
        "   Ala has a cat  ,   a cat develops   a cat    in Java    " | _
    }

    @Unroll
    def "'validate' method should throw a runtime exception for '#TEXT'"() {
        given: "a text from test cases"
        def text = TEXT

        when: "invoke 'valid' method"
        TextValidator.validate(text)

        then: "should throw an exception equals to expected"
        def exception = thrown(EXCEPTION)
        and: "message from exception should be equal to expected"
        exception.message == MESSAGE

        where: "test cases are below"
        TEXT             | EXCEPTION                | MESSAGE
        null             | IllegalArgumentException | "Text must contain words"
        ""               | IllegalArgumentException | "Text must contain words"
        "  "             | IllegalArgumentException | "Text must contain words"
        "Ala ma kota*"   | IllegalArgumentException | "String must contain only eng. letters, whitespace characters, commas and dots. Incorrect 1 chains of characters: *"
        " Ala 67 *     " | IllegalArgumentException | "String must contain only eng. letters, whitespace characters, commas and dots. Incorrect 2 chains of characters: 67 *"
        "Kotre=()! \\"   | IllegalArgumentException | "String must contain only eng. letters, whitespace characters, commas and dots. Incorrect 2 chains of characters: =()! \\"
    }
}
