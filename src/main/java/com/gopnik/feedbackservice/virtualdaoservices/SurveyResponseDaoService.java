package com.gopnik.feedbackservice.virtualdaoservices;

import com.gopnik.feedbackservice.models.SurveyResponse;
import com.gopnik.feedbackservice.models.User;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class SurveyResponseDaoService {

    public static final Map<Integer, SurveyResponse> responseMap = new HashMap<>();

    public static int responseCount = 0;



    public static void saveResponse(int userId, SurveyResponse s) {
        if(responseMap.containsKey(userId))
        {
            System.out.println("Survey already submitted by user " + userId);
            return;
        }
        responseMap.put(userId, s);
        responseCount++;
    }




}
