package com.pawelpotaczala.interviewhomework.service;

import com.pawelpotaczala.interviewhomework.validator.TextValidator;
import com.pawelpotaczala.interviewhomework.model.Letter;
import lombok.extern.log4j.Log4j2;

import java.util.*;

@Log4j2
public class TextServiceImpl implements TextService {

    private static final String BY_WHITESPACES_DOTS_COMMAS = "[\\s,.]+";
    private final String text;
    private final Map<Letter, Set<String>> assignedWordsToContainingThemLetters;

    public static TextServiceImpl of(String text) {
        return new TextServiceImpl(text);
    }

    private TextServiceImpl(String text) {
        TextValidator.validate(text);
        this.text = text;
        this.assignedWordsToContainingThemLetters = new TreeMap<>();
    }

    @Override
    public Map<Letter, Set<String>> getAssignedWordsToContainingThemLetters() {
        setupAssignedWordsToContainingThemLetters();
        String[] words = transformTextToLowerCaseWords();
        indexEachWordIn(words);
        return assignedWordsToContainingThemLetters;
    }

    private void setupAssignedWordsToContainingThemLetters() {
        assignedWordsToContainingThemLetters.clear();
    }

    private String[] transformTextToLowerCaseWords() {
        log.debug("Transform text to lower case words");
        return text.toLowerCase().split(BY_WHITESPACES_DOTS_COMMAS);
    }

    private void indexEachWordIn(String[] words) {
        for (String word: words) {
            indexEachLetterIn(word);
        }
        log.info("Successful assigned words to containing them letters");
    }

    private void indexEachLetterIn(String word) {
        for (int i = 0; i < word.length(); i++) {
            Letter letter = Letter.of(word.charAt(i));
            addLetterIfNotRepeated(letter);
            addWordToLetter(word, letter);
        }
        log.debug("finished iterate a word: '{}', current map state: {}", word, assignedWordsToContainingThemLetters);
    }

    private void addLetterIfNotRepeated(Letter letter) {
        if(isNotRepeated(letter)) {
            addLetter(letter);
        }
    }

    private boolean isNotRepeated(Letter letter) {
        return !assignedWordsToContainingThemLetters.containsKey(letter);
    }

    private void addLetter(Letter letter) {
        assignedWordsToContainingThemLetters.put(letter, new TreeSet<>());
        log.debug("Added a new letter: '{}'", letter);
    }

    private void addWordToLetter(String word, Letter letter) {
        boolean added = assignedWordsToContainingThemLetters.get(letter).add(word);
        if (added) {
            log.debug("Added a new word: '{}' to letter: '{}'", word, letter);
        }
    }
}
