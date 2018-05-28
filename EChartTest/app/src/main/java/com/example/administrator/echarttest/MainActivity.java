package com.example.administrator.echarttest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView= ((WebView) findViewById(R.id.webView));
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        //设置WebView属性，能够执行Javascript脚本

        //设置可以访问文件
        settings.setAllowFileAccess(true);
        //设置支持缩放
        settings.setBuiltInZoomControls(true);
//        webView.loadUrl("file:"+ File.separator+"android_asset"+File.separator+"bar1.html");

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
        BarTest1 barTest1=new BarTest1();
        barTest1.test(webView);
    }
}
