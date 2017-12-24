package com.dipanshu.app.observabletestproject.observables;

/**
 * Created by Dipanshu on 25-12-2017.
 */

public interface MyObservable {
    void addObserver(MyObserver myObserver);
    void deleteObserver(MyObserver myObserver);
    void notifyObservers();
}
