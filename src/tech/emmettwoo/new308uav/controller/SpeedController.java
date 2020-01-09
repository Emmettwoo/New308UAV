package tech.emmettwoo.new308uav.controller;

import tech.emmettwoo.new308uav.ControlPage;

public class SpeedController {
	//��ǰ�ٶȣ�����ʱ��ʼ����
	private int currentSpeed = 0;
	//�ή�ٵĲ������ݲ�֧���޸ģ�
	private int stepOver = 50;
	
	
	//���캯������ʼ���ٶȣ���д�룩
	public SpeedController(int speed) {
		currentSpeed = speed;
	}
	
	//���ٺͽ���
	public void sppedUp() {
		//�ٶȲ��ɳ���1000
		if((currentSpeed+stepOver) <= 1000)
			currentSpeed+=stepOver;
		else 
			currentSpeed = 1000;
		//�����µ�(�ٶ�)����д��
		ControlPage.dataController.dataUpdate(3, currentSpeed);
	}
	
	public void sppedDown() {
		//�ٶȲ��ɵ���0
		if((currentSpeed-stepOver) >= 0)
			currentSpeed-=stepOver;
		else 
			currentSpeed = 0;
		//�����µ�(�ٶ�)����д��
		ControlPage.dataController.dataUpdate(3, currentSpeed);
	}
	
	
	//getter & setter
	public void setSpeed(int speed) {
		//�ٶȲ��ɳ���1000�����0
		if(speed >= 0 && speed <= 1000)
			currentSpeed = speed;
		//�����µ�(�ٶ�)����д��
		ControlPage.dataController.dataUpdate(3, currentSpeed);
	}
	
	public int getSpeed() {
		return currentSpeed;
	}
	
	public int getStepOver() {
		return stepOver;
	}

	public void setStepOver(int stepOver) {
		this.stepOver = stepOver;
	}
}
