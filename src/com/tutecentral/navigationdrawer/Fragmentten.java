package com.tutecentral.navigationdrawer;

import org.practitioner.arjunprakhar.MYBooks;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragmentten extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Intent i = new Intent(getActivity(),MYBooks.class);
		startActivity(i);
		return super.onCreateView(inflater, container, savedInstanceState);
	}
}
