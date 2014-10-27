package com.tutecentral.navigationdrawer;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.practitioner.arjunprakhar.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Maina extends Activity {
	private TextView responseTextView;
	String s = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ma);
		if(netwrkChk())
			{this.responseTextView = (TextView) this
					.findViewById(R.id.responseTextView);
			new GetAllDataTask().execute(new ApiConnector());
			}
		else
		{
			Toast.makeText(getApplicationContext(), "Please Connect to Internet",Toast.LENGTH_LONG).show();
	        
		}
	}

	public void setTextToTextView(JSONArray jsonArray) {

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject json = null;
			try {
				json = jsonArray.getJSONObject(i);
				s = s + "Name:" + json.getString("NAME") + "\n" + "Address:"
						+ json.getString("ADDRESS") + "\n" + "Number:"
						+ json.getString("NUMBER") + "\n\n";
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		this.responseTextView.setText(s);
	}

	private class GetAllDataTask extends
			AsyncTask<ApiConnector, Long, JSONArray> {

		@Override
		protected JSONArray doInBackground(ApiConnector... params) {
			// TODO Auto-generated method stub
			return params[0].GetAllData();
		}

		@Override
		protected void onPostExecute(JSONArray result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			setTextToTextView(result);
		}

	}
	private boolean netwrkChk()
	{Context ctx=getBaseContext();
		ConnectivityManager conMgr = (ConnectivityManager) ctx
    .getSystemService(Context.CONNECTIVITY_SERVICE);
		 NetworkInfo i = conMgr.getActiveNetworkInfo();
		  if (i == null)
		    return false;
		  if (!i.isConnected())
		    return false;
		  if (!i.isAvailable())
		    return false;
		  return true;
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	  Intent i=new Intent(Maina.this,MainActivity.class);
	  startActivity(i);
	}
}