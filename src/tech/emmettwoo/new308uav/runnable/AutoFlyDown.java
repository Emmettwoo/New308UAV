package tech.emmettwoo.new308uav.runnable;

import tech.emmettwoo.new308uav.ControlPage;
import tech.emmettwoo.new308uav.util.ToastUtils;

public class AutoFlyDown implements Runnable {
	@Override
	public void run() {
    	ToastUtils.showToast("无人机自动降落");
		for(int speed = ControlPage.speedController.getSpeed(); speed > 0; speed-=10){
			ControlPage.speedController.setSpeed(speed);
			ControlPage.textViewUtils.updateSeekBarText();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}				
	}
}
