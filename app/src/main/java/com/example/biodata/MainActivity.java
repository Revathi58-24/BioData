package com.example.biodata;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText etRollNo, etName, etAge, etDob, etSkills;
    Spinner spinnerCollege;
    String selectedCollege;
    RadioGroup rgGender;
    CheckBox cbReading, cbTraveling, cbGaming;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etRollNo = findViewById(R.id.etRollNo);
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etDob = findViewById(R.id.etDob);
        etSkills = findViewById(R.id.etSkills);
        spinnerCollege = findViewById(R.id.spinnerCollege);
        selectedCollege = spinnerCollege.getSelectedItem().toString();
        rgGender = findViewById(R.id.rgGender);
        cbReading = findViewById(R.id.cbReading);
        cbTraveling = findViewById(R.id.cbTraveling);
        cbGaming = findViewById(R.id.cbGaming);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Date Picker for Date of Birth
        etDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                etDob.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rollNo = etRollNo.getText().toString();
                String name = etName.getText().toString();
                String age = etAge.getText().toString();
                String dob = etDob.getText().toString();
                String college = spinnerCollege.getSelectedItem().toString();
                String skills = etSkills.getText().toString();
                int selectedGenderId = rgGender.getCheckedRadioButtonId();
                RadioButton selectedGender = findViewById(selectedGenderId);
                String gender = selectedGender.getText().toString();

                StringBuilder hobbies = new StringBuilder();
                if (cbReading.isChecked()) hobbies.append("Reading ");
                if (cbTraveling.isChecked()) hobbies.append("Traveling ");
                if (cbGaming.isChecked()) hobbies.append("Gaming");

                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                intent.putExtra("rollNo", rollNo);
                intent.putExtra("name", name);
                intent.putExtra("age", age);
                intent.putExtra("dob", dob);
                intent.putExtra("college", college);
                intent.putExtra("skills", skills);
                intent.putExtra("gender", gender);
                intent.putExtra("hobbies", hobbies.toString().trim());
                startActivity(intent);
            }
        });
    }
}
