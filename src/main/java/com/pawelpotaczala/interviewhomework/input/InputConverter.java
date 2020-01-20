package com.pawelpotaczala.interviewhomework.input;

import com.pawelpotaczala.interviewhomework.model.Letter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.*;

@Log4j2
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class InputConverter {

    public static Map<Letter, Set<String>> indexEachLetterToWordsFrom(String text) {
        InputValidator.valid(text);
        Map<Letter, Set<String>> result = new TreeMap<>();

        log.debug("Transform input text to words");
        String[] words = transformToWords(text);

        log.debug("Start index each letter to words containing it");
        for (String word: words) {
            log.debug("start iterate a word: '" + word + "'");
            for (int i = 0; i < word.length(); i++) {
                char character = word.charAt(i);
                Letter letter = Letter.of(character);

                if (!result.containsKey(letter)) {
                    result.put(letter, new TreeSet<>());
                    log.debug("Added a new letter: '" + letter + "'");
                }
                boolean added = result.get(letter).add(word);
                if (added) {
                    log.debug("Added a new word: '" + word + "' to letter: '" + letter + "'");
                }
            }
            log.debug("finished iterate a word: '" + word + "', current map state: " + result);
        }
        log.debug("Finished index each letter to words containing it.");
        log.info("Successful index each letter to words containing it.");
        return result;
    }

    private static String[] transformToWords(String text) {
        return text.toLowerCase().split("[\\s,.]+");
    }
}
