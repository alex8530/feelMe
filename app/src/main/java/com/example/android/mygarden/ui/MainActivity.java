package com.example.android.mygarden.ui;

/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.android.mygarden.PlantWateringService;
import com.example.android.mygarden.R;
import com.example.android.mygarden.VideoViewActivity;

import static com.example.android.mygarden.PlantWateringService.ACTION_UPDATE_PLANT_WIDGETS;
import static com.example.android.mygarden.provider.PlantContract.BASE_CONTENT_URI;
import static com.example.android.mygarden.provider.PlantContract.PATH_PLANTS;
import static com.example.android.mygarden.provider.PlantContract.PlantEntry;

public class MainActivity
        extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<Cursor> {
    private static final String TAG = "PlantWateringService";

    private static final int GARDEN_LOADER_ID = 100;
    private PlantListAdapter mAdapter;

    private RecyclerView mGardenRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runAlarmManagerWithDefaultTile20Sec();
        setTitle("FeelMe");
        // The main activity displays the garden as a grid layout recycler view
        mGardenRecyclerView = (RecyclerView) findViewById(R.id.plants_list_recycler_view);
        mGardenRecyclerView.setLayoutManager(
                new GridLayoutManager(this, 4)
        );
        mAdapter = new PlantListAdapter(this, null);
        mGardenRecyclerView.setAdapter(mAdapter);

        getSupportLoaderManager().initLoader(GARDEN_LOADER_ID, null, this);
        startActivity(new Intent(this,VideoViewActivity.class).putExtra("index",0));
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Uri PLANT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_PLANTS).build();
        return new CursorLoader(this, PLANT_URI, null,
                null, null, PlantEntry.COLUMN_CREATION_TIME);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        cursor.moveToFirst();
        mAdapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(Loader loader) {

    }

    public void onPlantClick(View view) {
        ImageView imgView = (ImageView) view.findViewById(R.id.plant_list_item_image);
        long plantId = (long) imgView.getTag();
        Intent intent = new Intent(getBaseContext(), PlantDetailActivity.class);
        intent.putExtra(PlantDetailActivity.EXTRA_PLANT_ID, plantId);
        startActivity(intent);
    }


    public void onAddFabClick(View view) {
        Intent intent = new Intent(this, AddPlantActivity.class);
        startActivity(intent);
    }

    @SuppressLint("ShortAlarm")
    public void runAlarmManagerWithDefaultTile20Sec(){
        Log.d(TAG, "runAlarmManagerWithDefaultTile20Sec: ");
          Intent intent = new Intent(getApplicationContext(), PlantWateringService.class);
        intent.setAction(ACTION_UPDATE_PLANT_WIDGETS);
          PendingIntent pending = PendingIntent.getService(getApplicationContext(), 0, intent, 0);
          AlarmManager alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
           alarm.cancel(pending);
          int interval = 1000;
        alarm.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime(),interval, pending);
    }
}
