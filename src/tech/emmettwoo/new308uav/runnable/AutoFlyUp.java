package tech.emmettwoo.new308uav.runnable;

import tech.emmettwoo.new308uav.ControlPage;
import tech.emmettwoo.new308uav.util.ToastUtils;

public class AutoFlyUp implements Runnable {
	@Override
	public void run() {
		ToastUtils.showToast("���˻��Զ����");
		for(int speed = ControlPage.speedController.getSpeed(); speed <= 650; speed+=10){
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