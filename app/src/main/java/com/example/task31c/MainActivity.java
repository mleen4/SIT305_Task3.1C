package com.example.task31c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button startQuizButton;
    EditText inputName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        startQuizButton = findViewById(R.id.startQuizButton);
        inputName = findViewById(R.id.enterNameInput);


        startQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = inputName.getText().toString();
                Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                intent.putExtra("userName", name);
                startActivity(intent);

            }
        });

        //Use start activity for result to wait for 5 questions to be answered then open the results Activity

    }

//    public List<Question> getQuestions()
//    {
//        return questionList;
//    }
}
