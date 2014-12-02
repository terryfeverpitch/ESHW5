package com.simple.map;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MapView extends WebView {
	private String MAP_URL = "file:///android_asset/map.html";
	private boolean loaded = false;
	private WebViewClient client = new WebViewClient() {
		@Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {          
			MapActivity.progressdialog.setTitle("Loading");
			MapActivity.progressdialog.setMessage(url + "is loading");
			MapActivity.progressdialog.show();    
        }
		
		@Override
	    public boolean shouldOverrideUrlLoading(WebView view, String url) {
	        return shouldOverrideUrlLoading(view, url);
	    }
		
		@Override  
		public void onPageFinished(WebView view, String url) {
			MapView.this.loaded = true;
			initMap();
			MapActivity.progressdialog.dismiss();
		}
	};
	
	public MapView(final Context context, final AttributeSet attrs) {
		super(context, attrs);
		getSettings().setJavaScriptEnabled(true);
		setWebViewClient(client);
		loadUrl(MAP_URL);
	}
	
	public void initMap() {
		// 25.074378, 121.661085 = home
		// 25.073260, 121.663002 = 八方雲集
		loadUrl("javascript:initMap(25.074378, 121.661085)");
	}
	
	public void gotoMap() {
		String str = "221新北市汐止區建成路160巷8號";
		loadUrl("javascript:goto('"+ str + "')");
	}

	public boolean isReady() {
		return this.loaded;
	}
}
