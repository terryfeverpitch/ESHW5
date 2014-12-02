package com.simple.map;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MapActivity extends Activity {
	private MapView map_mv_map;
	private Button map_btn_search;
	
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
					map_mv_map.gotoMap();
			}
		});
		// LatLng(25.074389, 121.661089) -> TTU
		// 25.073599, 121.661790  -> ¨ý¤@µf
		//map_mv_map.loadUrl("javascript:initmap('"+ latitude + "','" + longitude+"')");
//		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0, MapActivity.this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
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
