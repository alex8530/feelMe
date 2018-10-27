package com.example.android.mygarden;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class activity_story_list extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_list);

    }


    public void onBackButtonClick(View view) {
        finish();
    }

    public void onStoryCliced_details(View view) {
        Toast.makeText(this, "this isdsf", Toast.LENGTH_SHORT).show();
        Intent intentDetails= new Intent(this,activity_story_details.class);
        startActivity(intentDetails);


    }
}
