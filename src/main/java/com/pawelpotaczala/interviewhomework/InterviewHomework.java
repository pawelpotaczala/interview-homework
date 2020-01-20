package com.pawelpotaczala.interviewhomework;

import com.pawelpotaczala.interviewhomework.output.Output;
import lombok.extern.log4j.Log4j2;

import java.util.*;

@Log4j2
public class InterviewHomework {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);) {
            while (scanner.hasNextLine()) {
                try {
                    Output.printIndexEachLetterToWordsFrom(scanner.nextLine());
                } catch (RuntimeException e) {
                    log.error(e);
                    System.out.println();
                }
            }
        }
    }
}
