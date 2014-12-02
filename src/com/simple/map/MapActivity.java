package com.simple.map;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MapActivity extends Activity {
	private MapView map_mv_map;
	private Button map_btn_search;
	private Button map_btn_gotoschool;
	
	public static ProgressDialog progressdialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		progressdialog = new ProgressDialog(this);
		progressdialog.setTitle("Loading");
		progressdialog.setMessage("map is loading");
		progressdialog.show();
		
		map_mv_map = (MapView) findViewById(R.id.map_mv_map);
		map_btn_search = (Button) findViewById(R.id.map_btn_search);
		map_btn_search.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(map_mv_map.isReady())
					map_mv_map.goSearch();
			}
		});
		
		map_btn_gotoschool = (Button) findViewById(R.id.map_btn_gotoschool);
		map_btn_gotoschool.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(map_mv_map.isReady()) {
					if(map_mv_map.getCurrentPlace() == MapView.HOME_CODE) {
						map_btn_gotoschool.setText("家");
						map_mv_map.gotoPlace(MapView.SCHOOL_CODE);
					}
					else if(map_mv_map.getCurrentPlace() == MapView.SCHOOL_CODE) {
						map_btn_gotoschool.setText("學校");
						map_mv_map.gotoPlace(MapView.HOME_CODE);
					}
				}	
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}
/*	// for GPS update
	@Override
	public void onLocationChanged(Location location) {
		Double longitude = location.getLongitude() ;
		Double latitude = location.getLatitude() ;
		locationManager.removeUpdates(MapActivity.this);
		map_wv_map.loadUrl("javascript:initmap('"+ latitude + "','"+longitude+"')");
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}
*/
}
