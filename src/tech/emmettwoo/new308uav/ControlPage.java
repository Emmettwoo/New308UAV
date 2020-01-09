package tech.emmettwoo.new308uav;

import java.net.Socket;

import tech.emmettwoo.new308uav.action.ControlButtons;
import tech.emmettwoo.new308uav.controller.DataController;
import tech.emmettwoo.new308uav.controller.SpeedController;

import tech.emmettwoo.new308uav.util.SeekBarUtils;
import tech.emmettwoo.new308uav.util.TextViewUtils;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ControlPage extends Activity{
	public static Activity self = null;
	public static DataController dataController = new DataController();
	public static SpeedController speedController = new SpeedController(200);
	public static TextViewUtils textViewUtils = new TextViewUtils();
	public static SeekBarUtils seekBarUtils = new SeekBarUtils();
	public static boolean stillBoost = false;
	public static Socket socket;
	private ControlButtons controlButtons = new ControlButtons();
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        self = this;
        seekBarUtils.initSeekBar();
        dataController.directionDataRead();
        controlButtons.ControlButtonListener();
    }
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
