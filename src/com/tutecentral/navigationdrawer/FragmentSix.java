package com.tutecentral.navigationdrawer;

import org.practitioner.arjunprakhar.Appointment;
import org.practitioner.arjunprakhar.R;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentSix extends Fragment {

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		setHasOptionsMenu(true);
		View view=inflater.inflate(R.layout.fragment_layout_six,container, false);
		Intent i=new Intent(getActivity(),Appointment.class);
		startActivity(i);
		getActivity().finish();
		
		return view;
	}
	
	@Override
	public void onDestroyView() 
	{
		super.onDestroyView(); 
       
	    
	   
	}
	
	
	
	
	
}
