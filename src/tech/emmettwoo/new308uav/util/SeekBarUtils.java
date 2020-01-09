package tech.emmettwoo.new308uav.util;

import tech.emmettwoo.new308uav.ControlPage;
import tech.emmettwoo.new308uav.R;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class SeekBarUtils {
	private SeekBar seekBar = null;
	public void initSeekBar() {
    	seekBar = (SeekBar) ControlPage.self.findViewById(R.id.speedSeekBar);
    	seekBar.setMax(1000);
    	ControlPage.seekBarUtils.updateSeekBar();
    	
    	seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
    		@Override
    		public void onStopTrackingTouch(SeekBar seekBar){
    			;
    		}
    		
    		@Override
    		public void onStartTrackingTouch(SeekBar seekBar){
    			;
    		}
    		
    		@Override
    		public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
    			ControlPage.speedController.setSpeed(progress);
    			ControlPage.dataController.dataUpdate(3, ControlPage.speedController.getSpeed());
    			ControlPage.textViewUtils.updateSeekBarText();
    		}
    	});
    }
	
	public void updateSeekBar() {
		seekBar.setProgress(ControlPage.speedController.getSpeed());
		ControlPage.textViewUtils.updateSeekBarText();
	}
}
