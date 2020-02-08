package com.pawelpotaczala.interviewhomework.validator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Log4j2
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TextValidator {

    private static final String NOT_LETTERS_DOTS_COMMAS_WS_ONE_OR_MORE = "[^a-zA-Z.,\\s]+";

    public static void validate(String text) {
        new TextValidator(text);
    }

    private TextValidator(String text) {
        log.debug("Start validation");
        isEmpty(text);
        containsLettersDotsAndCommas(text);
    }

    private void isEmpty(String text) {
        if(text == null || text.isBlank()) {
            throw new IllegalArgumentException("Text must contain words");
        }
    }

    private void containsLettersDotsAndCommas(String text) {
        Pattern pattern = Pattern.compile(NOT_LETTERS_DOTS_COMMAS_WS_ONE_OR_MORE);
        Matcher matcher = pattern.matcher(text);
        List<MatchResult> incorrectChainsOfCharacters = matcher.results()
                .peek(result -> log.debug("Text contains incorrect chains of characters from idx[{}] = {}", result.start(), result.group()))
                .collect(Collectors.toList());
        isNotEmptyIncorrectChainsOfCharacters(incorrectChainsOfCharacters);
    }

    private void isNotEmptyIncorrectChainsOfCharacters(List<MatchResult> incorrectChainsOfCharacters) {
        if(!incorrectChainsOfCharacters.isEmpty()) {
            throw new IllegalArgumentException("String must contain only eng. letters, whitespace characters, commas and dots. " +
                    "Incorrect " + incorrectChainsOfCharacters.size() + " chains of characters: " + String.join(" ", getGroups(incorrectChainsOfCharacters)));
        }
    }

    private String getGroups(List<MatchResult> matchResults) {
        return matchResults.stream().map(MatchResult::group).collect(Collectors.joining(" "));
    }
}
