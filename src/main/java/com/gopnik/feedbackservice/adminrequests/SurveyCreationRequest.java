package com.gopnik.feedbackservice.adminrequests;

import com.gopnik.feedbackservice.models.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class SurveyCreationRequest {

    private String surveyName;
    private List<Question> questionList;
    private int noOfQuestions;

}
