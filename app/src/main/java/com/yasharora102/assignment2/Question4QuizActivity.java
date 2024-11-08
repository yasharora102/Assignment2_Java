package com.yasharora102.assignment2;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Question4QuizActivity extends AppCompatActivity {
    private RadioButton q1Answer;
    private CheckBox q2Option1, q2Option2, q2Option3, q2Option4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4_quiz);

        // Correct answer for question 1: "Paris"
        q1Answer = findViewById(R.id.rbQ1Option2);

        // Correct answers for question 2: "3" and "7"
        q2Option1 = findViewById(R.id.cbQ2Option1); // 3
        q2Option2 = findViewById(R.id.cbQ2Option2); // 6
        q2Option3 = findViewById(R.id.cbQ2Option3); // 7
        q2Option4 = findViewById(R.id.cbQ2Option4); // 9
    }

    public void submitQuiz(View view) {
        int score = 0;

        // Check if question 1 answer is correct
        if (q1Answer.isChecked()) score++;

        // Check if question 2 answers are correct
        if (q2Option1.isChecked() && q2Option3.isChecked() && !q2Option2.isChecked() && !q2Option4.isChecked()) score++;

        Toast.makeText(this, "Total Score: " + score, Toast.LENGTH_LONG).show();
    }
}
