package com.pawelpotaczala.interviewhomework.util;

import com.pawelpotaczala.interviewhomework.model.Letter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Set;

import static java.lang.System.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class OutputPrinter {

    public static void print(Map<Letter, Set<String>> assignedWordsToContainingThemLetters) {
        out.println();
        out.println("\nOutput:");
        assignedWordsToContainingThemLetters.forEach((letter, words) -> out.println(letter + ": " + String.join(", ", words)));
        out.println();
    }
}
