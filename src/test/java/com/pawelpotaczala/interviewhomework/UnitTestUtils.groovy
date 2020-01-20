package com.pawelpotaczala.interviewhomework

import com.pawelpotaczala.interviewhomework.model.Letter

class UnitTestUtils {

    static TreeMap<Letter, Set<String>> transform(Map<String, Object> overrides = [:]){
        if (overrides == null) {
            return null
        }
        def o = new TreeMap<Letter, Set<String>>()
        overrides.each { letter, words ->
            o.put(Letter.of(letter as char), words as Set<String>)
        }
        return o
    }
}
