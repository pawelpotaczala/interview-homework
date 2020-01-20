package com.pawelpotaczala.interviewhomework.output;

import com.pawelpotaczala.interviewhomework.input.InputConverter;
import com.pawelpotaczala.interviewhomework.model.Letter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.Map;
import java.util.Set;

@Log4j2
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Output {

    public static void printIndexEachLetterToWordsFrom(String text) {
        System.out.println();
        Map<Letter, Set<String>> map = InputConverter.indexEachLetterToWordsFrom(text);
        System.out.println("\nOutput:");
        map.forEach((letter, words) -> System.out.println(letter + ": " + String.join(", ", words)));
        System.out.println();
    }
}
