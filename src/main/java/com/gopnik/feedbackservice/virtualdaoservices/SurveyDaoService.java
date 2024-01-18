package com.gopnik.feedbackservice.virtualdaoservices;

import com.gopnik.feedbackservice.models.Question;
import com.gopnik.feedbackservice.models.Survey;

import java.util.HashMap;
import java.util.Map;


public class SurveyDaoService {

    public static final Map<Integer, Survey> surveyMap = new HashMap<>();

    public static boolean saveSurvey(Survey s){
        surveyMap.put(s.getSurveyId(),s);
        return true;
    }

    public static Survey getSurvey(int surveyId){
        return surveyMap.get(surveyId);
    }

    public static boolean addQuestion(int surveyId, Question question){
        surveyMap.get(surveyId).getQuestionList().add(question);
        return true;
    }

}
