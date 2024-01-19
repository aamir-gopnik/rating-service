package com.gopnik.feedbackservice.adminservices;

import com.gopnik.feedbackservice.adminrequests.SurveyCreationRequest;
import com.gopnik.feedbackservice.models.*;
import com.gopnik.feedbackservice.virtualdaoservices.SurveyDaoService;
import com.gopnik.feedbackservice.virtualdaoservices.SurveyResponseDaoService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdminServiceImplementations implements AdminServices{
    @Override
    public String createSurvey(Survey survey) {
        SurveyDaoService.saveSurvey(survey);
        return "Survey created";
    }

    @Override
    public SurveyResult calculateEachAnswerAverage(int surveyId) {
        Map<Integer, SurveyResponse> surveyResponseMap = SurveyResponseDaoService.responseMap;
        List<SurveyResponse> surveyResponseList = surveyResponseMap.values().stream().toList();
        Map<Integer,Integer> eachResponseWeightageMap = new HashMap<>();
        int count = SurveyResponseDaoService.responseCount;
        Survey s = SurveyDaoService.getSurvey(surveyId);
        for(Question q : s.getQuestionList())
        {
            int i = 0;
            //System.out.println("Question -> " + q.getQuestionName());
            for(SurveyResponse sr : surveyResponseList){
                int sumOfWeightageOfEachUser = 0;
                Option selectedOption = sr.getSurveyAnswers().get(i).getSelectedOption();
                //System.out.println("33 ->" + selectedOption.getWeightage());
                sumOfWeightageOfEachUser += selectedOption.getWeightage();
                eachResponseWeightageMap.put(q.getQuestionId(),sumOfWeightageOfEachUser);
            }
        }
        return calculateEachAnswerAverage(surveyId,eachResponseWeightageMap);
    }

    private SurveyResult calculateEachAnswerAverage(int surveyId,Map<Integer,Integer> eachResponseWeightageMap){
        Map<Integer,Double> eachQuestionAvgResponse = new HashMap<>();
        Double noOfUsersAttempted = (double) SurveyResponseDaoService.responseCount;
        for(Integer question : eachResponseWeightageMap.keySet())
        {
            Double eachAnswerAverage = eachResponseWeightageMap.get(question).doubleValue() / noOfUsersAttempted;
            System.out.println(eachAnswerAverage);
            eachQuestionAvgResponse.put(question,eachAnswerAverage);
        }
        return buildSurveyResult(surveyId,eachQuestionAvgResponse);
    }

    private SurveyResult buildSurveyResult(int surveyId,Map<Integer,Double> eachQuestionAvgResponse) {
        return SurveyResult.builder()
                .surveyId(surveyId)
                .surveyRating(calculateSurveyRating(surveyId,eachQuestionAvgResponse))
                .answersAvg(eachQuestionAvgResponse)
                .build();
    }

    @Override
    public Double calculateSurveyRating(int surveyId,Map<Integer,Double> eachQuestionAvgResponse) {
        Double surveyRating = 0d;
        for(Integer question : eachQuestionAvgResponse.keySet()) {
            surveyRating += eachQuestionAvgResponse.get(question);
        }
        return surveyRating;
    }
}
