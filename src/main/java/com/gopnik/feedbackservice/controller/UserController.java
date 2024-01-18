package com.gopnik.feedbackservice.controller;


import com.gopnik.feedbackservice.userrequests.SurveyResponseRequest;
import com.gopnik.feedbackservice.models.Survey;
import com.gopnik.feedbackservice.virtualdaoservices.SurveyDaoService;
import com.gopnik.feedbackservice.virtualdaoservices.SurveyResponseDaoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("/getSurvey/{surveyId}")
    public Survey getSurvey(@PathVariable int surveyId){
        return SurveyDaoService.getSurvey(surveyId);
    }

    @PostMapping("/surveyResponse")
    public void saveFeedbackResponse(@RequestBody SurveyResponseRequest srr){
        SurveyResponseDaoService.saveResponse(srr.getUserId(),srr.getSurveyResponse());
    }


}
