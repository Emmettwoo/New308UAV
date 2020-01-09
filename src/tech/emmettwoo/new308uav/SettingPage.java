package tech.emmettwoo.new308uav;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SettingPage extends Activity{
	private int stepover_temp = 0;
	
	protected void onCreate(Bundle savedInstanceState)
	{		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		stepover_temp = ControlPage.dataController.getStepOver();
		
		Button btnSetting = (Button) findViewById(R.id.btnSetting);
		btnSetting.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(SettingPage.this , ControlPage.class); 	
				startActivity(i); 
			}
		});
		
		Button saveStepOver = (Button) findViewById(R.id.saveStepOver);
		saveStepOver.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	ControlPage.dataController.setStepOver(stepover_temp);
	        }
	    });
		
		Button stepOver5 = (Button) findViewById(R.id.stepOver5);
		stepOver5.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	stepover_temp = 5;
	        }
	    });
	    
		Button stepOver10 = (Button) findViewById(R.id.stepOver10);
		stepOver10.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	stepover_temp = 10;
	        }
	    });
		
		Button stepOver25 = (Button) findViewById(R.id.stepOver25);
		stepOver25.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	stepover_temp = 25;
	        }
	    });
		
		Button stepOver50 = (Button) findViewById(R.id.stepOver50);
		stepOver50.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	stepover_temp = 50;
	        }
	    });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first, menu);
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
