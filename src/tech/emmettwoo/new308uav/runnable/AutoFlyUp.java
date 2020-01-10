package tech.emmettwoo.new308uav.runnable;

import tech.emmettwoo.new308uav.ControlPage;
import tech.emmettwoo.new308uav.util.ToastUtils;

//未实现的功能
public class AutoFlyUp implements Runnable {
	@Override
	public void run() {
		ToastUtils.showNewToast(ControlPage.self, "无人机自动起飞");
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