package com.sanidhyakeluskar.wonderquiz;

/**
 * Created by sanidhya on 1/20/18.
 */

public class TrueFalse {
    private int mQuestionId;
    private boolean mAnswer;

    public TrueFalse(int questionResourceId, boolean trueorfalse){
        mQuestionId= questionResourceId;
        mAnswer= trueorfalse;

    }
    public int getQuestionId() {
        return mQuestionId;
    }

    public void setQuestionId(int questionId) {
        mQuestionId = questionId;
    }

    public boolean isAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }
}
