package com.dipanshu.app.observabletestproject.observables;

import android.os.Handler;


import com.dipanshu.app.observabletestproject.util.Utility;

import java.util.Observable;

/**
 * Created by Dipanshu on 24-12-2017.
 *
 * Using java.util.Observable class.
 */

public class TimeUpdaterOne extends Observable {

    private static TimeUpdaterOne INSTANCE = null;
    private String spendTime;

    public static TimeUpdaterOne getInstance()
    {
        if( INSTANCE == null )
            INSTANCE = new TimeUpdaterOne();

        return INSTANCE;
    }

    public void updatedTime(final long postsDate) {
        final Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                spendTime = Utility.getDateDifference(postsDate);
                setChanged();
                notifyObservers();
                handler.postDelayed(this, 30000);
            }
        };

        handler.postDelayed(runnable, 30000);
    }

    public String getSpendTime() {
        return spendTime;
    }
}
