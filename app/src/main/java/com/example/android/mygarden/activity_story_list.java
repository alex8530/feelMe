package com.example.android.mygarden;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class activity_story_list extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_list);

    }

    public void onStoryCliced(View view) {
    }


    public void onBackButtonClick(View view) {
        finish();
    }
}