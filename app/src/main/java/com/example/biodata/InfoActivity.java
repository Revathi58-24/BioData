package com.example.biodata;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        tvDisplay = findViewById(R.id.tvDisplay);

        String rollNo = getIntent().getStringExtra("rollNo");
        String name = getIntent().getStringExtra("name");
        String age = getIntent().getStringExtra("age");
        String dob = getIntent().getStringExtra("dob");
        String gender = getIntent().getStringExtra("gender");
        String college = getIntent().getStringExtra("college");
        String skills = getIntent().getStringExtra("skills");
        String hobbies = getIntent().getStringExtra("hobbies");

        String displayText = "Roll Number: " + rollNo + "\n" +
                "Name: " + name + "\n" +
                "Age: " + age + "\n" +
                "Date of Birth: " + dob + "\n" +
                "Gender: " + gender + "\n" +
                "College: " + college + "\n" +
                "Skills: " + skills + "\n" +
                "Hobbies: " + hobbies;

        tvDisplay.setText(displayText);
    }
}
