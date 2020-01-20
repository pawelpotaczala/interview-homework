package com.pawelpotaczala.interviewhomework.input;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log4j2
@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class InputValidator {

    private static final String REGEX = "[^a-zA-Z\\s,.]+";

    static void valid(String text) {
        log.debug("Start validation");
        if(text == null) {
            throw new NullPointerException("Text cannot be null");
        }
        if(text.isBlank()) {
            throw new IllegalArgumentException("Text must contain words");
        }

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(text);

        List<String> incorrectChainsOfCharacters = new ArrayList<>();
        while (matcher.find()) {
            log.debug("Text contains incorrect chain of characters from idx[" + matcher.start() + "] = " + matcher.group());
            incorrectChainsOfCharacters.add(matcher.group());
        }
        if(!incorrectChainsOfCharacters.isEmpty()) {
            throw new IllegalArgumentException("String must contain only eng. letters, whitespace characters, commas and dots. " +
                    "Incorrect " + incorrectChainsOfCharacters.size() + " chains of characters: " + String.join(" ", incorrectChainsOfCharacters));
        }
        log.debug("End validation");
        log.info("Text is correct");
    }
}
