package com.dipanshu.app.observabletestproject.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;


import com.dipanshu.app.observabletestproject.R;
import com.dipanshu.app.observabletestproject.model.Posts;
import com.dipanshu.app.observabletestproject.util.Utility;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Dipanshu on 24-12-2017.
 *
 * In this activity I am using @Timer class in the ui thread to update the spent time in every minute.
 */

public class PostDetailActivityThree extends AppCompatActivity {

    private TextView text_title;
    private TextView text_description;
    private TextView text_timing;
    private long postDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        text_title = findViewById(R.id.text_title);
        text_description = findViewById(R.id.text_description);
        text_timing = findViewById(R.id.text_timing);

        showPostDetails();
    }

    private void showPostDetails() {
        Bundle bundle = getIntent().getExtras();
        Posts posts = bundle.getParcelable("POST");
        String title = posts.getTitle();
        String description = posts.getDescription();
        String timestamp = posts.getTimestamp();

        text_title.setText(title);
        text_description.setText(description);
        postDate = Utility.timeInMillis(timestamp);
        text_timing.setText(Utility.getDateDifference(postDate));

    }

    public void onResume(){
        super.onResume();
        try {
            Timer timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.e("Clock","Time Updated");
                            text_timing.setText(Utility.getDateDifference(postDate));
                        }
                    });
                }
            };
            timer.schedule(timerTask, 30000, 30000);
        } catch (IllegalStateException e){
            Log.i("Clock", "resume error");
        }
    }

}
