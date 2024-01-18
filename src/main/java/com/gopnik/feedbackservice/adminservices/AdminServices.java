package com.gopnik.feedbackservice.adminservices;

import com.gopnik.feedbackservice.adminrequests.SurveyCreationRequest;
import com.gopnik.feedbackservice.models.Survey;
import com.gopnik.feedbackservice.models.SurveyResult;

import java.util.Map;

public interface AdminServices {

    public String createSurvey(Survey scr);

    public SurveyResult calculateEachAnswerAverage(int surveyId);

    public Double calculayeSurveyRating(int surveyId);

}
