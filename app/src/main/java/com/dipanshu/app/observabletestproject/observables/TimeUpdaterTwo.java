package com.dipanshu.app.observabletestproject.observables;

import android.os.Handler;


import com.dipanshu.app.observabletestproject.util.Utility;

import java.util.ArrayList;

/**
 * Created by Dipanshu on 25-12-2017.
 *
 * Using my custom Observable class @MyObservable.
 */

public class TimeUpdaterTwo implements MyObservable {

    private static TimeUpdaterTwo INSTANCE = null;
    private ArrayList<MyObserver> mObservers;
    private String spendTime;

    private TimeUpdaterTwo(){
        mObservers = new ArrayList<>();
    }

    public static TimeUpdaterTwo getInstance()
    {
        if( INSTANCE == null )
            INSTANCE = new TimeUpdaterTwo();

        return INSTANCE;
    }

    public void updatedTime(final long postsDate) {
        final Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                spendTime = Utility.getDateDifference(postsDate);
                notifyObservers();
                handler.postDelayed(this, 30000);
            }
        };

        handler.postDelayed(runnable, 30000);
    }

    @Override
    public void addObserver(MyObserver myObserver) {
        if(!mObservers.contains(myObserver)) {
            mObservers.add(myObserver);
        }
    }

    @Override
    public void deleteObserver(MyObserver myObserver) {
        if(mObservers.contains(myObserver)) {
            mObservers.remove(myObserver);
        }
    }

    @Override
    public void notifyObservers() {
        for (MyObserver observer: mObservers) {
            observer.updateChange(spendTime);
        }
    }
}
