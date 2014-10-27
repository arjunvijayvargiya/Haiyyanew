package org.practitioner.arjunprakhar;



import com.pushbots.push.Pushbots;
import com.tutecentral.navigationdrawer.MainActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Splash extends Activity {
	 
	private static final String PUSHBOTS_APPLICATION_ID = "543950b21d0ab1e9798b458f";
	private static final String SENDER_ID = "181170534325";

	
	
	private ProgressBar progressBar;
	 private int progressStatus = 0;
	 private TextView textView;
	 private Handler handler = new Handler();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		Pushbots.init(this, SENDER_ID,PUSHBOTS_APPLICATION_ID);
		  progressBar = (ProgressBar) findViewById(R.id.progressBar1);
	        //textView = (TextView) findViewById(R.id.progressor);
	       // textView.setTypeface(tf);
	        // Start long running operation in a background thread
	        new Thread(new Runnable() {
	           public void run() {
	              while (progressStatus < 100) {
	                 progressStatus += 1;
	          // Update the progress bar and display the 
	                               //current value in the text view
	          handler.post(new Runnable() {
	          public void run() {
	             progressBar.setProgress(progressStatus);
	            // textView.setText(progressStatus+"/"+progressBar.getMax());
	          }
	              });
	              try {
	                 // Sleep for 200 milliseconds. 
	                               //Just to display the progress slowly
	                 Thread.sleep(10);
	                 
	              } catch (InterruptedException e) {
	                 e.printStackTrace();
	              }
	           }
	              Intent i=new Intent(Splash.this,MainActivity.class);
	              startActivity(i);
	              finish();
	        }
	        }).start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
