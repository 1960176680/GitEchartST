package com.cn.echartstest;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	WebView webView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.button1).setOnClickListener(this);
		findViewById(R.id.button2).setOnClickListener(this);
		findViewById(R.id.button3).setOnClickListener(this);
		loadFlowHtml();
	}

	/**
	 * 加载网页部分
	 */
	void loadFlowHtml()
	{
		webView = (WebView) findViewById(R.id.webview);
		// 设置WebView属性，能够执行JavaScript脚本
		webView.getSettings().setJavaScriptEnabled(true);
		//设置可以访问文件
		webView.getSettings().setAllowFileAccess(true);
		//设置可使用cookie
		CookieManager.getInstance().setAcceptCookie(true);
		//去a input标签边框
		webView.getSettings().setNeedInitialFocus(false);
		//加载js访问控件
		webView.addJavascriptInterface(this, "SurveyUtil");
		//设置捕捉js事件
		webView.setWebChromeClient(new WebChromeClientSelf(this));
		//设置背景为透明
		webView.setBackgroundColor(getResources().getColor(android.R.color.transparent));
		//加载wap页面
		webView.loadUrl("file:///android_asset/www/survey_result.html");
		
		handler.post(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				webView.loadUrl("javascript:refreshView("+7+");");
			}
		});
	}

	Handler handler = new Handler();
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button1:
			//加载wap页面
			webView.loadUrl("file:///android_asset/www/survey_result.html");
			
			handler.post(new Runnable() {				
				@Override
				public void run() {
					webView.loadUrl("javascript:refreshView("+7+");");
				}
			});
			break;
		case R.id.button2:
			webView.loadUrl("file:///android_asset/www/flow_use_now_report.html");
			handler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					webView.loadUrl("javascript:refershView(['2014-02-01','2014-02-02','2014-02-03','2014-02-04','2014-02-05','2014-02-06','2014-02-07','2014-02-08','2014-02-09','2014-02-10'],[80,20,10,75,100,200,100,800,20,59]);");
				}
			});	
			break;
		case R.id.button3:
			webView.loadUrl("file:///android_asset/www/flow_use_three_report.html");
			handler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub					
					webView.loadUrl("javascript:refershView(['一月','二月','三月','四月'],[200,800,400,500],[100,900,20,300]);");
				}
			});	
			break;
		default:
			break;
		}
		
	}

	
	public void getCheckDetail(final int flowIndex)
	{
		handler.post(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "您选择的是饼图块坐标"+flowIndex,Toast.LENGTH_SHORT).show();
				//刷新数据接口
				webView.loadUrl("javascript:refreshView("+flowIndex+");");
			}
		});
		
	} 
}
