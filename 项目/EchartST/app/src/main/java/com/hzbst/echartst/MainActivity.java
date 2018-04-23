package com.hzbst.echartst;  
  
import android.app.Activity;  
import android.os.Bundle;  
import android.view.View;  
import android.view.View.OnClickListener;  
import android.webkit.WebView;  
import android.webkit.WebViewClient;  
import android.widget.Button;  
  
public class MainActivity extends Activity implements OnClickListener{  
    private Button linechart_bt;  
    private Button barchart_bt;  
    private Button piechart_bt;  
    private WebView chartshow_wb;  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
        initView();  
    }  
    /** 
     * 初始化页面元素 
     */  
    private void initView(){  
        linechart_bt=(Button)findViewById(R.id.linechart_bt);  
        barchart_bt=(Button)findViewById(R.id.barchart_bt);  
        piechart_bt=(Button)findViewById(R.id.piechart_bt);  
        linechart_bt.setOnClickListener(this);  
        barchart_bt.setOnClickListener(this);  
        piechart_bt.setOnClickListener(this);  
        chartshow_wb=(WebView)findViewById(R.id.chartshow_wb);  
        //进行webwiev的一堆设置  
        //开启本地文件读取（默认为true，不设置也可以）  
        chartshow_wb.getSettings().setAllowFileAccess(true);  
        //开启脚本支持  
        chartshow_wb.getSettings().setJavaScriptEnabled(true);  
        chartshow_wb.loadUrl("file:///android_asset/echart/myechart.html");  
    }  
    @Override  
    public void onClick(View v) {  
        switch (v.getId()) {  
        case R.id.linechart_bt:  
            chartshow_wb.loadUrl("javascript:createChart('line',[89,78,77]);");   
            break;  
        case R.id.barchart_bt:  
            chartshow_wb.loadUrl("javascript:createChart('bar',[89,78,77]);");   
            break;  
        case R.id.piechart_bt:  
            chartshow_wb.loadUrl("javascript:createChart('pie',[89,78,77]);");   
            break;  
            default:  
            break;  
        }  
    }  
          
}  