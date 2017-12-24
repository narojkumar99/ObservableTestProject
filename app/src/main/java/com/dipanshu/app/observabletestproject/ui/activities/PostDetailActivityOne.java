package com.dipanshu.app.observabletestproject.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;


import com.dipanshu.app.observabletestproject.R;
import com.dipanshu.app.observabletestproject.model.Posts;
import com.dipanshu.app.observabletestproject.observables.TimeUpdaterOne;
import com.dipanshu.app.observabletestproject.util.Utility;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Dipanshu on 24-12-2017.
 *
 * In this activity I am using the java.util.Observer api.
 * @TimeUpdaterOne extends java.util.Observer and provides the updates in every minute, and update the spent time.
 */

public class PostDetailActivityOne extends AppCompatActivity implements Observer {

    private TimeUpdaterOne mUserDataRepositoryObservable;
    private TextView text_title;
    private TextView text_description;
    private TextView text_timing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        mUserDataRepositoryObservable = TimeUpdaterOne.getInstance();
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
    public void update(Observable observable, Object arg) {
        if (observable instanceof TimeUpdaterOne) {
            TimeUpdaterOne timeUpdater = (TimeUpdaterOne)observable;
            Log.e("Clock","Time Updated");
            text_timing.setText(timeUpdater.getSpendTime());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUserDataRepositoryObservable.deleteObserver(this);
    }

}
