package com.example.android.mygarden;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class video_list_activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list_activity);
    }

    public void onVideosCliced1(View view) {

        Intent youtubeIntent = new Intent(this,VideoViewActivity.class);
        startActivity(youtubeIntent);

    }

    public void onBackButtonClick(View view) {
        finish();
    }
}
