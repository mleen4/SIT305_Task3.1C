package com.example.task31c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizComplete extends AppCompatActivity {


    TextView CongratsTextView, NameTextView, YourScoreTextView, UserScore;
    Button finishButton, tryAgainButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_complete);

        CongratsTextView = findViewById(R.id.congratsTextView);
        NameTextView = findViewById(R.id.nameTextView);
        YourScoreTextView = findViewById(R.id.yourScoreTextView);
        UserScore = findViewById(R.id.userScore);

        finishButton = findViewById(R.id.finishButton);
        tryAgainButton = findViewById(R.id.tryAgainButton);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        String userScore = intent.getStringExtra("userScore");

        NameTextView.setText(userName);
        UserScore.setText(userScore + "/5");

        tryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Question.resetQuestions();
                Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                intent.putExtra("userName", userName);
                startActivity(intent);
            }
        });

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //These 2 lines of code was taken from https://stackoverflow.com/questions/6330200/how-to-quit-android-application-programmatically
                //From user Cristian Babrusi
                finishAffinity();
                System.exit(0);
            }
        });










    }
}