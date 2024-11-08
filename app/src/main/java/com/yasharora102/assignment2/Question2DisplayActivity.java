package com.yasharora102.assignment2;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Question2DisplayActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2_display);

        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String phone = getIntent().getStringExtra("phone");

        TextView display = findViewById(R.id.tvDisplay);
        display.setText("Name: " + name + "\nEmail: " + email + "\nPhone: " + phone);
    }
}
