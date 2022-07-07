package com.example.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etGPA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);





    }

    @Override
    protected void onPause() {
        super.onPause();
        //Step 1a: Get the user input from the EditText and store it in a variable
        String strName = etName.getText().toString();
        float gpa = Float.parseFloat((etGPA.getText().toString()));

        //Step 1b Obtain an instance of the SharedPreferences
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        //Step 1c: Obtain an instance of the SharedPreference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();

        //Se[ 1d: Add the key-value pair
        prefEdit.putString("name",strName);
        prefEdit.putFloat("gpa", gpa );

        //Step 1e: Call commit() to save the changes into Share
        //        String strName = etName.getText().toString();dPreferences
        prefEdit.commit();


    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        String strName = prefs.getString("name", "John");
        float gpa = prefs.getFloat("gpa", 0);

        etName.setText(strName);
        etGPA.setText((gpa + ""));
    }

}