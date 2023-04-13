package com.example.sibalapplication;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SelectedExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_exercise);


        Date selectedDate = (Date) getIntent().getSerializableExtra("selected_date");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String strdate = format.format(selectedDate);

        Log.i(TAG,"가저왔음"+strdate);
    }
}