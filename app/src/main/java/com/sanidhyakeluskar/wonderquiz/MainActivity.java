package com.sanidhyakeluskar.wonderquiz;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button mytruebutton;
    Button myfalsebutton;
    TextView mQuestionTextView;
    int mIndex;
    int mQuestion;
    int mScoreCount;
    ProgressBar mProgressBar;
    TextView mScore;


    private TrueFalse[] mQuestionBank= new TrueFalse[]{
            new TrueFalse(R.string.question_1, false),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, false),
            new TrueFalse(R.string.question_6, true),
            new TrueFalse(R.string.question_7, false),

    };
    final int PROGRESS_BAR_CONSTANT= (int)Math.ceil(100.0/mQuestionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mytruebutton= findViewById(R.id.truebutton);
        myfalsebutton= findViewById(R.id.falsebutton);
        mQuestionTextView= findViewById(R.id.textViewQuestion);
        mProgressBar= findViewById(R.id.progressBar2);
        mScore= findViewById(R.id.scoreView);

        mQuestion= mQuestionBank[mIndex].getQuestionId();

        mQuestionTextView.setText(mQuestion);



        mytruebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(true);
                updateQuestion();

            }
        });
        myfalsebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(false);
                updateQuestion();
            }
        });

    }
    private void updateQuestion(){
        mIndex=(mIndex+1)% mQuestionBank.length;
        if(mIndex==0)
        {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Quiz Over");
            alert.setCancelable(false);
            alert.setMessage("You scored " + mScoreCount + " Points");
            alert.setPositiveButton("Closing Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.show();
        }
        mQuestion= mQuestionBank[mIndex].getQuestionId();

        mQuestionTextView.setText(mQuestion);
        mProgressBar.incrementProgressBy(14);
        mScore.setText("Score: "+mScoreCount+"/"+mQuestionBank.length);



    }
    private void checkAnswer(boolean userSelection){
        boolean correctAnswer= mQuestionBank[mIndex].isAnswer();
        if( userSelection== correctAnswer)
        {
            Toast.makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();
            mScoreCount=mScoreCount+1;
        }
        else{
            Toast.makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
        }
    }
}
