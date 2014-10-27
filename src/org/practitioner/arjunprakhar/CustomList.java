package org.practitioner.arjunprakhar;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String> {

	private final Activity context;
	private final String[] name;
	private final Double[] rating;
	private final Double[] min;
	
	public CustomList(Activity context,	String[] name, Double[] rating,Double[] min) {
	super(context, R.layout.hospital_item, name);
	this.context = context;
	this.name = name;
	this.rating = rating;
	this.min = min;
	}
	@Override
	public View getView(int position, View view, ViewGroup parent) {
	LayoutInflater inflater = context.getLayoutInflater();
	View rowView= inflater.inflate(R.layout.hospital_item, null, true);
	TextView hospitalName = (TextView) rowView.findViewById(R.id.hospital_name);
	TextView rate = (TextView) rowView.findViewById(R.id.ratings);
	TextView price = (TextView) rowView.findViewById(R.id.min);
	
	hospitalName.setText(name[position]);
	rate.setText(Double.toString(rating[position]));
	price.setText(Double.toString(min[position]));
	return rowView;
	}

}
