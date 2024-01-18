package com.gopnik.feedbackservice.controller;

import com.gopnik.feedbackservice.adminservices.AdminServiceImplementations;
import com.gopnik.feedbackservice.models.Survey;
import com.gopnik.feedbackservice.models.SurveyResult;
import com.gopnik.feedbackservice.virtualdaoservices.SurveyDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminServiceImplementations adminServiceImplementations;

    @PostMapping("/createSurvey")
    public String createSurvey(@RequestBody Survey survey){
        return adminServiceImplementations.createSurvey(survey);
    }

    @GetMapping("/viewSurveyResponse")
    public SurveyResult getSurveyResult(@RequestParam int surveyId){
        return adminServiceImplementations.calculateEachAnswerAverage(surveyId);
    }
}
