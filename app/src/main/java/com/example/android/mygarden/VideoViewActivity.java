package com.example.android.mygarden;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

public class VideoViewActivity extends AppCompatActivity {
    private SimpleExoPlayer mExoPlayer;
    private SimpleExoPlayerView mExoPlayerView;

    String url1="https://r2---sn-xguxaxjvh-n8ml.googlevideo.com/videoplayback?ip=188.234.251.138&key=yt6&mt=1540587722&mv=m&ms=au%2Crdu&mm=31%2C29&mn=sn-xguxaxjvh-n8ml%2Csn-n8v7knee&id=o-AD5EBChsaVtBije5dpCitBsPy68FEmXtS_HZ5BDkipYG&signature=B0A406818B7D302DD22C6E0F9A6A402C2083BD75.45316CD60E325A716643A55E4024C4387480D2B1&ratebypass=yes&nh=%2CIgpwcjAyLnN2bzA1KgkxMjcuMC4wLjE&clen=28572186&ipbits=0&initcwndbps=1430000&gir=yes&dur=406.418&itag=18&pl=24&source=youtube&c=WEB&expire=1540609428&mime=video%2Fmp4&lmt=1491871427581582&sparams=clen%2Cdur%2Cei%2Cgir%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cnh%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&ei=NIHTW_B0jtvtBMasg5AN&fvip=17&requiressl=yes&video_id=1GRMM12jGWQ&title=Amelia%27s+Story+-+A+Young+Woman%27s+Cancer+Journey";
    String url2="https://r6---sn-0ox-hqx6.googlevideo.com/videoplayback?ip=200.58.216.126&requiressl=yes&lmt=1536460805853157&itag=43&id=o-AD-zXGdPMYC3wBeNcr5ERchBKgig5srdWd4ElR-QepMu&dur=0.000&source=youtube&key=yt6&mm=31%2C29&mn=sn-0ox-hqx6%2Csn-hp57ynee&ei=LYHTW7GhNKKi7gKK1bPYBg&ms=au%2Crdu&mt=1540587722&pl=21&mv=m&clen=12720383&signature=B935700CA856C43142FBFDFB506AC8B52B4989C7.2434729000C8F6A780E5DA7D88E6D267673A08AF&fvip=3&beids=9466585&gir=yes&c=WEB&sparams=clen%2Cdur%2Cei%2Cgir%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&mime=video%2Fwebm&ratebypass=yes&ipbits=0&initcwndbps=456250&expire=1540609422&video_id=QomoNyfkqvg&title=Dabur+Vatika+Salutes+Female+Cancer+Survivors+-+%23BraveAndBeautiful";
    String url3="https://r5---sn-xuc-cvbd.googlevideo.com/videoplayback?pcm2cms=yes&expire=1540607785&lmt=1328898431135681&ei=yXrTW8_AAaKi7gLQoIawDg&c=WEB&initcwndbps=378750&id=o-AOHaHg-EANhEJTA5ofYnTCObAY2C6gKrg776bmHd4sSF&pl=23&dur=0.000&fvip=5&mime=video%2Fwebm&ms=au%2Crdu&source=youtube&mv=m&mm=31%2C29&ipbits=0&mn=sn-xuc-cvbd%2Csn-cvb7ln7z&itag=43&ip=190.25.222.2&ratebypass=yes&mt=1540586093&clen=15891996&key=yt6&requiressl=yes&gir=yes&sparams=clen%2Cdur%2Cei%2Cgir%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpcm2cms%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&signature=572A7CA467CA280B91566B36CB32CB65A1AB3837.C91D3B3D211D5B6FA975E759DC8760CF68CD94B4&video_id=lRLP7LOu68I&title=Cancer+Survivors+Inspire";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);

        mExoPlayerView= (SimpleExoPlayerView) findViewById(R.id.playerView);


        String videoUrl =url1 ;

        Intent i = getIntent();

        if (i != null) {
            switch (i.getIntExtra("index", 0)) {
                case 0:
                    videoUrl = url1;
                    break;
                case 1:
                    videoUrl = url2;
                    break;
                case 2:
                    videoUrl = url3;
                    break;
                default:
                    videoUrl = url1;
            }
        }

        long position=0;
        // TODO (6): Use the saved instance state to get the position of stored exo player position. If there is no instance state, just set it to 0

        if (savedInstanceState!=null)
        {
            position = savedInstanceState.getLong("video-position");
        }


        initializePlayer(Uri.parse(videoUrl), position);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // TODO (8): Release the player
        releasePlayer();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // TODO (5): Put the position of the exo player to outState using getCurrentPosition
        outState.putLong("video-position", mExoPlayer.getCurrentPosition());

    }


    private void initializePlayer(Uri mediaUri, long position) {

        if (mExoPlayer == null) {

            TrackSelector trackSelector = new DefaultTrackSelector();
            LoadControl loadControl = new DefaultLoadControl();


            mExoPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelector, loadControl);

            // TODO (4): Make the player go to the passed in position using seekTo
            mExoPlayer.seekTo(position);

            mExoPlayerView.setPlayer(mExoPlayer);



            //create playlist
            mExoPlayer.prepare(buildMediaSource());

            mExoPlayer.setPlayWhenReady(false);




        }

    }
    private MediaSource buildMediaSource( ) {
        // these are reused for both media sources we create below

        String userAgent = Util.getUserAgent(this, "SessionActivity");
        MediaSource mediaSource1 = new ExtractorMediaSource(
                Uri.parse(url1),
                new DefaultDataSourceFactory(this, userAgent),
                new DefaultExtractorsFactory(), null, null);

        MediaSource mediaSource2 = new ExtractorMediaSource(
                Uri.parse(url2),
                new DefaultDataSourceFactory(this, userAgent),
                new DefaultExtractorsFactory(), null, null);

        MediaSource mediaSource3 = new ExtractorMediaSource(
                Uri.parse(url2),
                new DefaultDataSourceFactory(this, userAgent),
                new DefaultExtractorsFactory(), null, null);
        return new ConcatenatingMediaSource(mediaSource1, mediaSource2,mediaSource3);
    }

    private void releasePlayer() {

        // TODO (7): If mExoPlayer is not null, stop it, release it and then set it to null

        mExoPlayer.stop();
        mExoPlayer.release();
        mExoPlayer = null;
    }


}
