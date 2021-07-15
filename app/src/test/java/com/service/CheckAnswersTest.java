package com.service;

import com.model.Words;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CheckAnswersTest {
    static CheckAnswers resolver;
    List<String> answer1 = Arrays.asList("fish", "horse", "egg", "goose", "eagle");
    List<String> answer2 = Arrays.asList("fish", "horse", "snake", "goose", "eagle");
    List<String> answer3 = Arrays.asList("fish", "horse", "", "goose", "eagle");
    List<String> answer4 = Arrays.asList("", "horse", "egg", "goose", "eagle");
    List<String> result2 = Arrays.asList("fish", "horse");
    List<String> wrongResult = Arrays.asList("fish", "horse");
    List<String> wrongResult2 = Arrays.asList("fish", "horse", "a", "goose", "eagle");
    @BeforeAll
    static void init() {
        resolver = new CheckAnswers();

    }

    @Test
    void mustReturnSameWords(){
        Assertions.assertEquals(new Words(answer1), resolver.resolve(answer1));
    }

    @Test
    void mustReturnCorrectWordsBeforeMistake(){
        Assertions.assertEquals(new Words(result2), resolver.resolve(answer2));
    }

    @Test
    void mustReturnCorrectWordsBeforeEmptyString(){
        Assertions.assertEquals(new Words(result2), resolver.resolve(answer3));
    }

    @Test
    void mustReturnEmptyArrayIfFirstIsEmpty(){
        Assertions.assertEquals(new Words(), resolver.resolve(answer4));
    }

    @Test
    void returnsEmptyArrayIfOneLetterWordWasUsed(){
        Assertions.assertEquals(new Words(), resolver.resolve(wrongResult2));
    }


    @Test
    void returnsEmptyArrayIfEmptyArrayWasReceived() {
        Assertions.assertEquals(new Words(), resolver.resolve(new ArrayList<>()));
    }

    @Test
    void mustReturnEquivalentArray() {
        Assertions.assertNotEquals(resolver.resolve(answer1).getWords(), wrongResult);
    }

    @Test
    void checkIfAnArrayDoesntContainSpecialCharacters() {
        List<String> list = Arrays.asList("fish", "horse", "egg", "goose", "eagle");
        List<String> list2 = Arrays.asList("fish", "horse", "egg", "goose111", "eagle");
        Assertions.assertTrue(resolver.ifContainsSpecialCharacters(list));
        Assertions.assertFalse(resolver.ifContainsSpecialCharacters(list2));
    }
}