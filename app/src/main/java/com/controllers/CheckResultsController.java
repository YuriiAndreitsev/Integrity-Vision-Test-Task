package com.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Words;
import com.service.CheckAnswers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("check_words")
public class CheckResultsController {
    @Autowired
    CheckAnswers checkAnswersService;

    @PostMapping
    public Words showSentWords(@RequestBody String words) {
        ObjectMapper mapper = new ObjectMapper();
        Words wordsObj = null;
        try {
            wordsObj = mapper.readValue(words, Words.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            // or LOGGER for exceptions
        }
        return checkAnswersService.resolve(wordsObj.getWords());

    }
}
