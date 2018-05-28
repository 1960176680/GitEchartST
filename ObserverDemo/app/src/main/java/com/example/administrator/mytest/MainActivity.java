package com.example.administrator.mytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 被观察的角色
        AndroidWeekly androidWeekly = new AndroidWeekly();
// 观察者
        Coder mrsimple = new Coder("mr.simple");
        Coder coder1 = new Coder("coder-1");
        Coder coder2 = new Coder("coder-2");
        Coder coder3 = new Coder("coder-3");
// 将观察者注册到可观察对象的观察者列表中
        androidWeekly.addObserver(mrsimple);
        androidWeekly.addObserver(coder1);
        androidWeekly.addObserver(coder2);
        androidWeekly.addObserver(coder3);
// 发布消息
        androidWeekly.postNewPublication("新的一期AndroidWeekly 来啦!");
    }
}
