package com.example.android.mygarden;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class activity_videosa_and_stories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videosa_and_stories);
    }

    public void onVideosCliced(View view) {
        Intent intent = new Intent(activity_videosa_and_stories.this , video_list_activity.class);
        startActivity(intent);
    }

    public void onStoryCliced(View view) {
        Intent intent = new Intent(activity_videosa_and_stories.this ,  activity_story_list.class);
        startActivity(intent);
    }

    public void onBackButtonClick(View view) {
        finish();
    }
}
