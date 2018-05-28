package com.example.administrator.mytest;

import android.util.Log;

import java.util.Observable;
import java.util.Observer;

/**
 * 程序员是观察者
 *
 * @author mrsimple
 */
public class Coder implements Observer {
    public String name ;
    public Coder(String aName) {
        name = aName ;
    }

    @Override
    public void update(Observable observable, Object arg) {
        Log.i("tag======","Hi, " + name + ", AndroidWeekly 更新啦, 内容: " + arg);
    }
    @Override
    public String toString() {
        return "码农: " + name;
    }
}
