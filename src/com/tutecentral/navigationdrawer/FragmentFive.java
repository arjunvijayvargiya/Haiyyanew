package com.tutecentral.navigationdrawer;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import org.practitioner.arjunprakhar.R;
import org.practitioner.arjunprakhar.Setting;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;

public class FragmentFive extends Fragment {

	
	public FragmentFive(){
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_layout_five, container,
				false);
		
		Intent i = new Intent(getActivity(),Setting.class);
		startActivity(i);
		return view;
	}
	public void onDestroyView() 
	{ 
		super.onDestroyView(); 
	 

	}

	public void onBackPressed() {
		android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
	}
		
	
	
	
	
	
}
