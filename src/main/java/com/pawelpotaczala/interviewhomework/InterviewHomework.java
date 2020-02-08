package com.pawelpotaczala.interviewhomework;

import com.pawelpotaczala.interviewhomework.service.TextService;
import com.pawelpotaczala.interviewhomework.service.TextServiceImpl;
import com.pawelpotaczala.interviewhomework.util.OutputPrinter;
import lombok.extern.log4j.Log4j2;

import java.util.*;

@Log4j2
public class InterviewHomework {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();
                TextService textService = TextServiceImpl.of(text);
                OutputPrinter.print(textService.getAssignedWordsToContainingThemLetters());
            }
        }
    }
}
