package com.dipanshu.app.observabletestproject.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.dipanshu.app.observabletestproject.R;
import com.dipanshu.app.observabletestproject.model.Posts;
import com.dipanshu.app.observabletestproject.observables.MyObserver;
import com.dipanshu.app.observabletestproject.observables.TimeUpdaterTwo;
import com.dipanshu.app.observabletestproject.util.Utility;


/**
 * Created by Dipanshu on 25-12-2017.
 *
 * In this activity I am using my own build Observer name @MyObserver .
 * @TimeUpdaterTwo extends MyObserver and provides the updates in every minute, and update the spent time.
 */

public class PostDetailActivityTwo extends AppCompatActivity implements MyObserver {

    private TimeUpdaterTwo mUserDataRepositoryObservable;
    private TextView text_title;
    private TextView text_description;
    private TextView text_timing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        mUserDataRepositoryObservable = TimeUpdaterTwo.getInstance();
        mUserDataRepositoryObservable.addObserver(this);

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

        long postDate = Utility.timeInMillis(timestamp);

        text_timing.setText(Utility.getDateDifference(postDate));
        mUserDataRepositoryObservable.updatedTime(postDate);
    }

    @Override
    public void updateChange(String spendTime) {
        Log.e("Clock","Time Updated");
        text_timing.setText(spendTime);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUserDataRepositoryObservable.deleteObserver(this);
    }

}
