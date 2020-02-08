package com.pawelpotaczala.interviewhomework.service;

import com.pawelpotaczala.interviewhomework.model.Letter;

import java.util.Map;
import java.util.Set;

public interface TextService {
    Map<Letter, Set<String>> getAssignedWordsToContainingThemLetters();
}
