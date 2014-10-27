package com.tutecentral.navigationdrawer;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import org.practitioner.arjunprakhar.R;
import org.practitioner.arjunprakhar.T1;
import org.practitioner.arjunprakhar.T2;
import org.practitioner.arjunprakhar.T3;
import org.practitioner.arjunprakhar.T4;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentThree extends Fragment {

	

	public FragmentThree() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_layout_three, container,
				false);
		ImageButton ib1=(ImageButton) view.findViewById(R.id.t1);
		ImageButton ib2=(ImageButton) view.findViewById(R.id.t2);
		ImageButton ib3=(ImageButton) view.findViewById(R.id.t3);
		ImageButton ib4=(ImageButton) view.findViewById(R.id.t4);
		ib1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getActivity(),T1.class);
				startActivity(i);
				getActivity().overridePendingTransition(R.layout.from_middle, R.layout.to_middle); 
			}
		});
ib2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getActivity(),T2.class);
				startActivity(i);
				getActivity().overridePendingTransition(R.layout.from_middle, R.layout.to_middle); 
			}
		});
ib3.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i=new Intent(getActivity(),T3.class);
		startActivity(i);
		getActivity().overridePendingTransition(R.layout.from_middle, R.layout.to_middle); 
	}
});
ib4.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i=new Intent(getActivity(),T4.class);
		startActivity(i);
		getActivity().overridePendingTransition(R.layout.from_middle, R.layout.to_middle); 
	}
});
		
		
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
