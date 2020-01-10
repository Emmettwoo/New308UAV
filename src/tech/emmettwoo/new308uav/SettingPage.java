package tech.emmettwoo.new308uav;

import tech.emmettwoo.new308uav.util.ToastUtils;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SettingPage extends Activity{
	protected void onCreate(Bundle savedInstanceState)
	{		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		
		Button btnSetting = (Button) findViewById(R.id.btnSetting);
		btnSetting.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(SettingPage.this , ControlPage.class); 	
				startActivity(i); 
			}
		});
		
		Button saveDirectionData = (Button) findViewById(R.id.saveDirectionData);
		saveDirectionData.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	ControlPage.dataController.directionDataSave();
	        	ToastUtils.showNewToast(SettingPage.this, "航向俯仰等参数已保存");
	        	Intent i = new Intent(SettingPage.this , ControlPage.class); 	
				startActivity(i);
	        }
	    });
		
		Button readDirectionData = (Button) findViewById(R.id.readDirectionData);
		readDirectionData.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	ControlPage.dataController.directionDataRead();
	        	ToastUtils.showNewToast(SettingPage.this, "航向俯仰等参数已读取");
	        	Intent i = new Intent(SettingPage.this , ControlPage.class); 	
				startActivity(i);
	        }
	    });

		Button stepOver5 = (Button) findViewById(R.id.stepOver5);
		stepOver5.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	ControlPage.dataController.setStepOver(5);
	        	ToastUtils.showNewToast(SettingPage.this, "步进已设置为5");
	        	Intent i = new Intent(SettingPage.this , ControlPage.class); 	
				startActivity(i);
	        }
	    });
	    
		Button stepOver10 = (Button) findViewById(R.id.stepOver10);
		stepOver10.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	ControlPage.dataController.setStepOver(10);
	        	ToastUtils.showNewToast(SettingPage.this, "步进已设置为10");
	        	Intent i = new Intent(SettingPage.this , ControlPage.class); 	
				startActivity(i);
	        }
	    });
		
		Button stepOver25 = (Button) findViewById(R.id.stepOver25);
		stepOver25.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	ControlPage.dataController.setStepOver(25);
	        	ToastUtils.showNewToast(SettingPage.this, "步进已设置为25");
	        	Intent i = new Intent(SettingPage.this , ControlPage.class); 	
				startActivity(i);
	        }
	    });
		
		Button stepOver50 = (Button) findViewById(R.id.stepOver50);
		stepOver50.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	ControlPage.dataController.setStepOver(50);
	        	ToastUtils.showNewToast(SettingPage.this, "步进已设置为50");
	        	Intent i = new Intent(SettingPage.this , ControlPage.class); 	
				startActivity(i);
	        }
	    });
		
		Button btnAutoUp = (Button) findViewById(R.id.btnAutoUp);
		btnAutoUp.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	ToastUtils.showNewToast(SettingPage.this, "未实现的功能");
	        }
	    });
		
		Button btnAutoDown = (Button) findViewById(R.id.btnAutoDown);
		btnAutoDown.setOnClickListener(new View.OnClickListener() {
			@Override
	        public void onClick(View v) {
				ToastUtils.showNewToast(SettingPage.this, "未实现的功能");
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
