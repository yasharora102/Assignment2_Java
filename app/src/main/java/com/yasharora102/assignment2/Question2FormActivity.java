package com.yasharora102.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class Question2FormActivity extends AppCompatActivity {
    private EditText name, email, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2_form);

        name = findViewById(R.id.etName);
        email = findViewById(R.id.etEmail);
        phone = findViewById(R.id.etPhone);
    }

    public void submitForm(View view) {
        Intent intent = new Intent(this, Question2DisplayActivity.class);
        intent.putExtra("name", name.getText().toString());
        intent.putExtra("email", email.getText().toString());
        intent.putExtra("phone", phone.getText().toString());
        startActivity(intent);
    }
}