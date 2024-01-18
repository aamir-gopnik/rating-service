package com.gopnik.feedbackservice.models;

import com.gopnik.feedbackservice.models.Question;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Survey {

    private int surveyId;
    private String surveyName;
    private List<Question> questionList;
    private int noOfQuestions;

}
