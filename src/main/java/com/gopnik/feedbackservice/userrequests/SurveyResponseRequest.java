package com.gopnik.feedbackservice.userrequests;


import com.gopnik.feedbackservice.models.SurveyResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class SurveyResponseRequest {

    private int userId;

    private SurveyResponse surveyResponse;
}
