/**
 * 
 */
package com.cn.echartstest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.webkit.JsResult;
import android.webkit.WebView;

/**
 * å¯¹ç??é¡?JSè¿?è¡?å¤????ï¼???????å·²å??alertï¼?confirmè¿?è¡?å¤????
 * @author Kaven
 * 2011-2-22
 */
public class WebChromeClientSelf extends android.webkit.WebChromeClient {
	Context context;
	//å®?ä¹????ç¤ºä¿¡???
	Map<String, String> msTitle=new HashMap<String, String>();
	
	
	private void replaceMap(Map<String, String> map){
		Set<String> elSet=map.keySet();
		for(String el :elSet){
			msTitle.put(el, map.get(el));
		}
	}
	public WebChromeClientSelf(Context ctx){
		super();
		this.context=ctx;
		msTitle.put("alert", "æ¸©é¦¨???ç¤?");
		msTitle.put("confirm", "ç¡?è®¤æ??ä½?");
		msTitle.put("Prompt", "è¾???¥ä¿¡???æ¡?");
	}
	public WebChromeClientSelf(Context ctx,Map<String,String> map){
		this.context=ctx;
		replaceMap(map);
	}
	@Override
	public boolean onJsAlert(WebView view, String url, String message,
			JsResult result) {
		// TODO Auto-generated method stub
		//???å»ºä??ä¸?Builder??¥æ?¾ç¤ºç½?é¡µä¸­???å¯¹è??æ¡?
		Builder builder = new Builder(this.context);
		builder.setTitle(msTitle.get("alert"));
		builder.setMessage(message);
		final JsResult nresult=result;
		builder.setPositiveButton(android.R.string.ok,
				new AlertDialog.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						//??¹å?»ç¡®å®???????ä¹????,ç»§ç»­??§è??ç½?é¡µä¸­??????ä½?
						nresult.confirm();
					}
				});
		builder.setCancelable(false);
		builder.create();
		builder.show();
		return true;
	};
	public boolean onJsConfirm(WebView view, String url, String message,
			final JsResult result) 
	{
		Builder builder = new Builder(this.context);
		builder.setTitle(msTitle.get("confirm"));
		builder.setMessage(message);
		builder.setPositiveButton(android.R.string.ok,
				new AlertDialog.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						result.confirm();
					}
				});
		builder.setNegativeButton(android.R.string.cancel,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						result.cancel();
					}
				});
		builder.setCancelable(false);
		builder.create();
		builder.show();
		return true;
	};
	
}
