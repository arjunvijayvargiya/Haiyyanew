package org.practitioner.arjunprakhar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.tutecentral.navigationdrawer.MainActivity;
import com.tutecentral.navigationdrawer.Maina;

public class Appointment extends Activity {

	ListView list;
	  String[] web = {
	    "Medical Centre",
	      "Medical Centre One",
	      "Apollo",
	     
	  } ;
	  
	  Double[] mRating = {
			    3.5,
			    5.0,
			    4.0,
			    2.0,
			    1.0,
			    2.0,
			    1.0,
			    
			  } ;
	  
	  Double[] mPrice = {
			    350.0,
			    500.0,
			    400.0,
			    200.0,
			    100.0,
			    200.0,
			    150.0,
			    
			  } ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.appointment);
	
	    CustomList adapter = new
	        CustomList(Appointment.this, web, mRating,mPrice);
	    	list=(ListView)findViewById(R.id.list);
	    	TextView emptyTextView = (TextView)
					findViewById(android.R.id.empty);
			list.setEmptyView(emptyTextView);
	        list.setAdapter(adapter);
	        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	                @Override
	                public void onItemClick(AdapterView<?> parent, View view,
	                                        int position, long id) {
	                    Toast.makeText(Appointment.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
	                    Intent intent = new Intent(Appointment.this , DetailsActivity.class);
	                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
	                    startActivity(intent);
	                }
	            });
	  }
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	  Intent i=new Intent(Appointment.this,MainActivity.class);
	  startActivity(i);
	}


}
