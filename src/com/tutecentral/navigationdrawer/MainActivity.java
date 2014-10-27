package com.tutecentral.navigationdrawer;

import java.util.ArrayList;
import java.util.List;
import org.practitioner.arjunprakhar.R;


import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.pushbots.push.Pushbots;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.text.InputFilter.LengthFilter;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	CustomDrawerAdapter adapter;

	List<DrawerItem> dataList;
	private static final String PUSHBOTS_APPLICATION_ID = "543950b21d0ab1e9798b458f";
	private static final String SENDER_ID = "181170534325";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 Pushbots.init(this, SENDER_ID,PUSHBOTS_APPLICATION_ID);
        //mapCreator();
		// Initializing
		
		dataList = new ArrayList<DrawerItem>();
		mTitle = mDrawerTitle = getTitle();
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		// Add Drawer Item to dataList
		dataList.add(new DrawerItem("Home", R.drawable.ic_action_storage));
		dataList.add(new DrawerItem("Police Station", R.drawable.ic_action_new));
		//dataList.add(new DrawerItem("HomeAid", R.drawable.ic_action_about));
		dataList.add(new DrawerItem("MyGroups", R.drawable.ic_action_import_export));
		dataList.add(new DrawerItem("Settings", R.drawable.ic_action_settings));
		//dataList.add(new DrawerItem("Books Appointments", R.drawable.ic_action_good));
		//dataList.add(new DrawerItem("My Appointments", R.drawable.ic_action_good));
		dataList.add(new DrawerItem("Feedback", R.drawable.ic_action_paste));
		dataList.add(new DrawerItem("Exit", R.drawable.ic_action_back));
		

		adapter = new CustomDrawerAdapter(this, R.layout.custom_drawer_item,
				dataList);

		mDrawerList.setAdapter(adapter);

		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}
		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {
			SelectItem(0);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void SelectItem(int possition) {

		Fragment fragment = null;
		Bundle args = new Bundle();
		switch (possition) {
		case 0:
			fragment = new FragmentOne();
			
			
			
			break;
			
			
		case 1:
			fragment = new FragmentTwo();
			
			break;
		
		case 2:
			fragment = new FragmentFour();
			
			break;
		case 3:
			fragment = new FragmentFive();
			
			break;
		
			
		case 4:
			final Intent _Intent = new Intent(android.content.Intent.ACTION_SEND);
	         _Intent.setType("text/html");
	         _Intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{ getString(R.string.mail_feedback_email) });
	         _Intent.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(R.string.mail_feedback_subject));
	         _Intent.putExtra(android.content.Intent.EXTRA_TEXT, getString(R.string.mail_feedback_message));
	         startActivity(Intent.createChooser(_Intent, getString(R.string.title_send_feedback)));
			
		case 5:
			android.os.Process.killProcess(android.os.Process.myPid());
	        System.exit(1);
	        break;
			
		
			
		default:
			break;
		}

		fragment.setArguments(args);
		FragmentManager frgManager = getFragmentManager();
		frgManager.beginTransaction().replace(R.id.content_frame, fragment)
				.commit();

		mDrawerList.setItemChecked(possition, true);
		setTitle(dataList.get(possition).getItemName());
		mDrawerLayout.closeDrawer(mDrawerList);

	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggles
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// The action bar home/up action should open or close the drawer.
		// ActionBarDrawerToggle will take care of this.
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}

		return false;
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			SelectItem(position);

		}
	}
private void mapCreator(){
	final GoogleMap googleMap;
	googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
	final LatLng bitspilani = new LatLng(17.544860 , 78.571718);
	Marker TP = googleMap.addMarker(new MarkerOptions().position(bitspilani).title("BPHC")); 
	CameraUpdate center = CameraUpdateFactory.newLatLng(bitspilani);
	CameraUpdate zoom = CameraUpdateFactory.zoomTo(18);
	googleMap.moveCamera(center);
	googleMap.animateCamera(zoom);
	
	//determining the location through GPS
	
	LocationManager lm=(LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
	LocationListener listener=new LocationListener() {
		
		@Override
		public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onProviderEnabled(String arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onProviderDisabled(String arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onLocationChanged(Location loc) {
			// TODO Auto-generated method stub
			final float lati = (float)loc.getLatitude();
			final float longi  = (float)loc.getLongitude();
			final LatLng pos = new LatLng(lati , longi);
			Marker userMarker = googleMap.addMarker(new MarkerOptions().position(pos).title("YOU"));
			
		}
	};
	
	lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
	
	//SAVING THE LAST LOCATION
	String locationprevious = LocationManager.NETWORK_PROVIDER;
	Location last = lm.getLastKnownLocation(locationprevious);
}
}
