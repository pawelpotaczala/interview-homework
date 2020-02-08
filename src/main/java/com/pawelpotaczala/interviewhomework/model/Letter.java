package com.pawelpotaczala.interviewhomework.model;

import lombok.Value;

@Value
public class Letter implements Comparable<Letter> {
    private final char value;

    public static Letter of(char value) {
        return new Letter(value);
    }

    private Letter(char value) {
        if(Character.isLetter(value)) {
            this.value = value;
        } else {
            throw new IllegalArgumentException("Character " + value + " is not a letter");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public int compareTo(Letter o) {
        return this.value - o.value;
    }
}
