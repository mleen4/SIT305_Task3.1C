package com.example.task31c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ZoomButtonsController;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    List<Question> questionList2;
    List<Button> buttonList = new ArrayList<>();




    ProgressBar progressBar;
    TextView progressText;
    TextView questionTitle;
    TextView questionBody;
    Button answerOneButton;
    Button answerTwoButton;
    Button answerThreeButton;
    Button submitButton;
    String selectedAnswer;
    String userName;
    Boolean finished = false;
    Integer progress = 0;
    Integer AnswersCorrect = 0;


    //Video used to change colour of Buttons https://www.youtube.com/watch?v=AdlxIdYus14
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        userName = intent.getStringExtra("userName");


        setContentView(R.layout.activity_quiz);
        progressBar = findViewById(R.id.progressBar);
        progressText = findViewById(R.id.progressText);
        questionTitle = findViewById(R.id.questionTitle);
        questionBody = findViewById(R.id.questionBody);
        answerOneButton = findViewById(R.id.answerOneButton);
        answerTwoButton = findViewById(R.id.answerTwoButton);
        answerThreeButton = findViewById(R.id.answerThreeButton);
        submitButton = findViewById(R.id.submitButton);

        buttonList.add(answerOneButton);
        buttonList.add(answerTwoButton);
        buttonList.add(answerThreeButton);

        Question.addQuestions();
        questionList2 = Question.getQuestions();

        NextQuestion(progress);

        answerOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = answerOneButton.getText().toString();
//                Toast.makeText(getApplicationContext() , "You Have selected " + selectedAnswer, Toast.LENGTH_LONG).show();
            }
        });

        answerTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = answerTwoButton.getText().toString();
//                Toast.makeText(getApplicationContext() , "You Have selected " + selectedAnswer, Toast.LENGTH_LONG).show();
            }
        });
        answerThreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 selectedAnswer = answerThreeButton.getText().toString();
//                 Toast.makeText(getApplicationContext() , "You Have selected " + selectedAnswer, Toast.LENGTH_LONG).show();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Boolean isCorrect = CorrectAnswer(selectedAnswer, questionList2.get(progress).correctAnswer);



                if(finished)
                {
                    Intent intent2 = new Intent(QuizActivity.this, QuizComplete.class);
                    intent2.putExtra("userName", userName);
                    intent2.putExtra("userScore", Integer.toString(AnswersCorrect));
                    startActivity(intent2);
                }
                if(progress == 4)
                {
//                    progress++;
                    //Watch that
                    if(isCorrect)
                    {
                        AnswersCorrect++;
                    }
                    submitButton.setText("Finish");
                    finished = true;
                }
                if(questionList2.get(progress).nextQuestion == true)
                {
                    progress++;
                    NextQuestion(progress);
                    ClearButtonBackgroundTint();
                    selectedAnswer = "";
                }

                if(!selectedAnswer.equals("") && finished != true)
                {
                    submitButton.setText("Next Question");
                    questionList2.get(progress).nextQuestion = true;
                    if(isCorrect == true){AnswersCorrect++;}
                }


//                Toast.makeText(getApplicationContext() , Integer.toString(progress), Toast.LENGTH_LONG).show();
            }
        });


    }


    public Boolean CorrectAnswer(String selected, String answer)
    {
        //Changing the button tint and adding the /color folder in /res and learning how to change the button tint came from https://stackoverflow.com/questions/29801031/how-to-add-button-tint-programmatically
        // From user ColdFire
        for(Button button : buttonList)
        {
            Integer buttonColour = (button.getText().toString().equals(answer)) ? R.color.button_correct : R.color.button_incorrect;
            button.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(buttonColour));
        }
        return (selected.equals(answer)) ? true : false;
    }

    public void NextQuestion(Integer i)
    {
        progressText.setText("Progress " + Integer.toString(progress) + "/5");
        progressBar.setProgress(progress);
        submitButton.setText("Submit");
        questionTitle.setText(questionList2.get(i).title);
        questionBody.setText(questionList2.get(i).questionBody);
        answerOneButton.setText(questionList2.get(i).firstAnswer);
        answerTwoButton.setText(questionList2.get(i).secondAnswer);
        answerThreeButton.setText(questionList2.get(i).thirdAnswer);

    }

    private void ClearButtonBackgroundTint()
    {
        for(Button button : buttonList)
        {
            button.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.button_default));
        }
    }
}