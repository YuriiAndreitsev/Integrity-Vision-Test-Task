package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Words {
    private List<String> words;

    @Override
    public String toString() {
        return "Words{" +
                "words=" + words +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Words words1 = (Words) o;
        return Objects.equals(words, words1.words);
    }

    @Override
    public int hashCode() {
        return Objects.hash(words);
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public void addWordToList (String wordToAdd){
        words.add(wordToAdd);
    }
    public Words() {
        this.words = new ArrayList<>();
    }

    public Words(List<String> words) {
        this.words = words;
    }
}
