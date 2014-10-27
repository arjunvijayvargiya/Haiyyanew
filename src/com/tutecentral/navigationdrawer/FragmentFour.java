package com.tutecentral.navigationdrawer;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import org.practitioner.arjunprakhar.R;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentFour extends Fragment {
private GoogleMap googleMap;
public FragmentFour(){
	
}
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {

	View view = inflater.inflate(R.layout.fragment_layout_four, container,
			false);
	
	
	
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
