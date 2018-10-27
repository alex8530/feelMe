package com.example.android.mygarden;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.android.mygarden.ui.MainActivity;

public class patient_facilities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_facilities);
    }




    public void onRequestClick(View view) {
        Toast.makeText(this, "Request Sent", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(patient_facilities.this , MainActivity.class);
        startActivity(intent);
        finish();
    }













    public void onBackButtonClick(View view) {
        finish();
    }
}
