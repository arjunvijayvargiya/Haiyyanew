package com.tutecentral.navigationdrawer;



import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import org.practitioner.arjunprakhar.R;
import org.practitioner.arjunprakhar.Setting;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class GetHelp extends Activity {
	 GoogleMap googleMap;
	 String phsel="";
	 String str[]=null;
	 String phsend[]=null;
	 String messend=null;
	 String phnno[];
	 int value_r = 50;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_get_help);
		mapCreator();
		GPSTracker gpsTracker = new GPSTracker(this);
		
		if (gpsTracker.canGetLocation())
		{
			final LatLng current = new LatLng(gpsTracker.latitude ,gpsTracker.longitude);
			Marker TP2 = googleMap.addMarker(new MarkerOptions().position(current).title("me")); 
			double x=gpsTracker.latitude;
			double y=gpsTracker.longitude;  
			phnno = new String[1];
			phnno[0] = "+919542514041";
			
			
			
			CircleOptions circleOptions = new CircleOptions()
		    .center(current)
		    .radius(value_r *100); // In meters

		// Get back the mutable Circle
		    Circle circle = googleMap.addCircle(circleOptions);
			
		    value_r = Setting.prox;
			
			String city = gpsTracker.getLocality(this);
			

			String postalCode = gpsTracker.getPostalCode(this);
			

			String addressLine = gpsTracker.getAddressLine(this);
			
			messend="I am in danger at "+addressLine+","+city+","+postalCode;
		    
			
			double medlatlon[][]={{17.542004,78.576366},{17.512004,78.566366}};
			
			for(int i=0;i<medlatlon.length;i++)
		   	{ 
		   	  
		   		if((medlatlon[i][0]>(x-50)) && (medlatlon[i][0]<(x+50)))
		   		{
		   			if((medlatlon[i][1]>(y-50)) && (medlatlon[i][1]<(y+50)))
		   			{   final LatLng medicalcentre = new LatLng(medlatlon[i][0] ,medlatlon[i][1]);
		   				  Toast.makeText(getApplicationContext(), "Police station found",Toast.LENGTH_LONG).show();
		   				  Marker TP3 = googleMap.addMarker(new MarkerOptions().position(medicalcentre).title("Hospital Nearest"));
		   				  Polyline line = googleMap.addPolyline(new PolylineOptions()
		  	    	     .add(current,medicalcentre)
		  	    	     .width(5)
		  	    	     .color(Color.RED));
		   				  
		   				//googleMap.addCircle(options)
			            for(int k = 0;k < phnno.length;k++){
			            	SmsManager smsManager = SmsManager.getDefault();
				            smsManager.sendTextMessage(phnno[k], null, messend, null,
				                    null);
			            
			            }
			             try
			             {
			            	 Thread.sleep(3000);
			             }
			             catch(Exception e){
			            	 e.printStackTrace();
			             }
		  	    	      
		   			}
		
		   		}
		      
		    }
		}
	     	else
		{
			gpsTracker.showSettingsAlert();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		else if (id == R.id.mapto) {
			
			
			googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			
			return true;
		}
		else if (id == R.id.satel) {
			googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
			return true;
		}
		  
		return super.onOptionsItemSelected(item);
	}
	private void mapCreator(){
		
		googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
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
	private static String removeLastChar(String str) {
        return str.substring(0,str.length()-1);
    }
	
	
	
}
