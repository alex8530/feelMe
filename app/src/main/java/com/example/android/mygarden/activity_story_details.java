package com.example.android.mygarden;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class activity_story_details extends AppCompatActivity {


    TextView details , nameOfPreson ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_details);
        details = (TextView)findViewById(R.id.details);
        nameOfPreson = (TextView)findViewById(R.id.nameOfPreson);

    }


    public void onBackButtonClick(View view) {
        finish();
    }

    public void onSharClick(View view) {
        String message = details.getText().toString();
        String name = nameOfPreson.getText().toString();
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, message);

        startActivity(Intent.createChooser(share, name));
    }
}
