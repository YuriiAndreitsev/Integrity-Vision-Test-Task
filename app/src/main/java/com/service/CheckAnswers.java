package com.service;

import com.model.Words;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckAnswers {
    public Words resolve(List<String> answers) {
        Words resultingWordsList = new Words();
        if (answers.isEmpty() ||
                !ifContainsSpecialCharacters(answers) ||
                !ifWordIsTooShort (answers)||
                answers.size() < 2 || answers.get(0).isEmpty() || answers.get(1).isEmpty()) {
            return resultingWordsList;
        }
        String word;
        String nextWord;
        for (int i = 0; i < answers.size(); i++) {
            word = answers.get(i);
            if (i + 1 < answers.size() && !answers.get(i + 1).isEmpty()) {
                nextWord = answers.get(i + 1);
                if (word.charAt(word.length() - 1) == nextWord.charAt(0)) {
                    resultingWordsList.addWordToList(word);
                } else {
                    resultingWordsList.addWordToList(word);
                    return resultingWordsList;
                }
            } else {
                resultingWordsList.addWordToList(word);
                return resultingWordsList;
            }
        }

        return resultingWordsList;
    }

    public boolean ifContainsSpecialCharacters(List<String> listToCheck) {
        for (String word : listToCheck        ) {
            if (!word.matches("([A-Za-z]|(^$))+")) {
                return false;
            }
        }
        return true;
    }

    public boolean ifWordIsTooShort(List<String> listToCheck){
        for (String word : listToCheck        ) {
            if (!word.isEmpty() && word.length()<2) {
                return false;
            }
        }
        return true;
    }
}