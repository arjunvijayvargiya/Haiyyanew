package com.tutecentral.navigationdrawer;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.practitioner.arjunprakhar.R;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class TrackMe extends Activity {
	GoogleMap googleMap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_track_me);
		mapCreator();
		
	
		GPSTracker gpsTracker = new GPSTracker(this);
		if (gpsTracker.canGetLocation())
		{
			final LatLng current = new LatLng(gpsTracker.latitude ,gpsTracker.longitude);
			Marker TP2 = googleMap.addMarker(new MarkerOptions().position(current).title("me")); 
			double x=gpsTracker.latitude;
			double y=gpsTracker.longitude;  
			
		}
	     	else
		{
			gpsTracker.showSettingsAlert();
		}
		
		}
		
		
		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.track_me, menu);
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
private void mapCreator(){
		
		googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.maptrackme)).getMap();
		final LatLng bitspilani = new LatLng(17.544860 , 78.571718);
		Marker TP = googleMap.addMarker(new MarkerOptions().position(bitspilani).title("BPHC")); 
		CameraUpdate center = CameraUpdateFactory.newLatLng(bitspilani);
		CameraUpdate zoom = CameraUpdateFactory.zoomTo(18);
		googleMap.moveCamera(center);
		googleMap.animateCamera(zoom);
		googleMap.setMyLocationEnabled(true);
		googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
	    //17.542004, 78.576366 medical centre	
		
	}
}
