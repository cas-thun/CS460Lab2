package com.example.swipevideotest;

import android.os.Bundle;
import android.provider.MediaStore;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /**
     * Runs the program
     * @param savedInstanceState gets the instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        final ViewPager2 videoViewPager = findViewById(R.id.videoViewPager);

        List<VideoItem> videoItemList = new ArrayList<>();
        VideoItem videoSnow = new VideoItem();
        videoSnow.videoURL = "https://firebasestorage.googleapis.com/v0/b/swipevideolab2.appspot.com/o/20240226_194904.mp4?alt=media&token=81bfbbff-5e44-447a-a955-b2fecdb004e7";
        videoSnow.videoTitle = "Snow";
        videoSnow.videoDescription = "Snowfall in Ellensburg";
        videoSnow.videoID = "ID: 0000001";
        videoItemList.add(videoSnow);

        VideoItem videoSnow2 = new VideoItem();
        videoSnow2.videoURL = "https://firebasestorage.googleapis.com/v0/b/swipevideolab2.appspot.com/o/20240226_194904.mp4?alt=media&token=81bfbbff-5e44-447a-a955-b2fecdb004e7";
        videoSnow2.videoTitle = "More Snow";
        videoSnow2.videoDescription = "Snowfall at CWU";
        videoSnow2.videoID = "ID: 0000002";
        videoItemList.add(videoSnow2);

        VideoItem videoSnow3 = new VideoItem();
        videoSnow3.videoURL = "https://firebasestorage.googleapis.com/v0/b/swipevideolab2.appspot.com/o/20240226_194904.mp4?alt=media&token=81bfbbff-5e44-447a-a955-b2fecdb004e7";
        videoSnow3.videoTitle = "Even More Snow";
        videoSnow3.videoDescription = "Snowfall at the Dugmore parking lot";
        videoSnow3.videoID = "ID: 0000003";
        videoItemList.add(videoSnow3);

        VideoItem videoSnow4 = new VideoItem();
        videoSnow3.videoURL = "https://firebasestorage.googleapis.com/v0/b/swipevideolab2.appspot.com/o/20240226_194904.mp4?alt=media&token=81bfbbff-5e44-447a-a955-b2fecdb004e7";
        videoSnow3.videoTitle = "Even More Snow";
        videoSnow3.videoDescription = "Snowfall at the Dugmore parking lot";
        videoSnow3.videoID = "ID: 0000004";
        videoItemList.add(videoSnow4);


        videoViewPager.setAdapter(new VideoAdapter(videoItemList));
    }
}