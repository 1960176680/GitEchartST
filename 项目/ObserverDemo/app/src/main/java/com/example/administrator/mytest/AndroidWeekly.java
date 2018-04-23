package com.example.administrator.mytest;

import java.util.Observable;

/**
 * AndroidWeekly 这个网站是被观察者,它有更新所有的观察者(这里是程序员) 都会接到
 相应的通知.
 *
 * @author mrsimple
 */

public class AndroidWeekly extends Observable {


    public void postNewPublication(String content) {
// 标识状态或者内容发生改变
        setChanged();
// 通知所有观察者
        notifyObservers(content);
    }
}

