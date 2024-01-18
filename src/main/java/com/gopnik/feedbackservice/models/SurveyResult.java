package com.gopnik.feedbackservice.models;

import lombok.*;

import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
public class SurveyResult {

    private int surveyId;

    private String noOfResponses;

    private Map<Integer,Double> answersAvg;

    private Double surveyRating;
}
