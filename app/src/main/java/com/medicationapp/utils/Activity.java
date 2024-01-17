package com.medicationapp.utils;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.medicationapp.R;

/**
 * activity used for notifications
 * just opens up the reminders page
 */
public class Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reminders);
    }
}
