package com.example.android.mygarden;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.mygarden.ui.MainActivity;

public class patient_facilities extends AppCompatActivity {
    String isintentfinancialSupport=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_facilities);


        if (getIntent() !=null){

            if (getIntent().hasExtra("isintentfinancialSupport")){

              isintentfinancialSupport=getIntent().getStringExtra("isintentfinancialSupport");
                TextView tvMoney= (TextView) findViewById(R.id.tv_value);
                TextView tvValue= (TextView) findViewById(R.id.tv_mony);
                tvMoney.setVisibility(View.VISIBLE);
                tvValue.setVisibility(View.VISIBLE);

            }

        }





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
