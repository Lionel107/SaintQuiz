package com.example.gestionprofil.Model;

import java.util.List;

public class QuestionBank {
    private List<Question> mQuestionList;
    private int mNextQuestionIndex;
    public QuestionBank(List<Question> questionList) {
        mQuestionList = questionList;

    }
    public Question getNextQuestion() {

        return mNextQuestionIndex < mQuestionList.size() ? mQuestionList.get(mNextQuestionIndex++) : null;
    }
}