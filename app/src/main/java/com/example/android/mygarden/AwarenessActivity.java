package com.example.android.mygarden;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AwarenessActivity extends AppCompatActivity {

    String number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awareness);
        String[] name = new String[]{" Please use the word of hope, love and life instead of death and illness", "kindly use the term (disease of power)instead of (Malignant disease) ", "tell her she is beautiful today"};


        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 3; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_name", name[i]);
            aList.add(hm);
        }

        String[] from = {"listview_name"};
        int[] to = {R.id.listview_tamplet};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_item2, from, to);
        final ListView lst = (ListView) findViewById(R.id.listview_awareness);
        lst.setAdapter(simpleAdapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //  Toast.makeText(AwarenessActivity.this, "open chat", Toast.LENGTH_SHORT).show();
                // custom dialog
                final Dialog dialog = new Dialog(AwarenessActivity.this);
                dialog.setContentView(R.layout.custom);
                dialog.setTitle("Title...");

                // set the custom dialog components - text, image and button
                TextView text = (TextView) dialog.findViewById(R.id.text);
                text.setText("send advice (message from anonymous)");
                ImageView image = (ImageView) dialog.findViewById(R.id.image);
                image.setImageResource(R.drawable.love);
                EditText num = (EditText) findViewById(R.id.edit_num);
                // number= num.getText().toString().trim();
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();

                        Toast.makeText(AwarenessActivity.this, "your message was sent", Toast.LENGTH_SHORT).show();

                    }
                });

                dialog.show();

            }


        });

    }
}

