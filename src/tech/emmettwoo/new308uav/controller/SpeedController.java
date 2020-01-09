package tech.emmettwoo.new308uav.controller;

import tech.emmettwoo.new308uav.ControlPage;

public class SpeedController {
	//当前速度（构造时初始化）
	private int currentSpeed = 0;
	//提降速的步进（暂不支持修改）
	private int stepOver = 50;
	
	
	//构造函数（初始化速度，不写入）
	public SpeedController(int speed) {
		currentSpeed = speed;
	}
	
	//提速和降速
	public void sppedUp() {
		//速度不可超过1000
		if((currentSpeed+stepOver) <= 1000)
			currentSpeed+=stepOver;
		else 
			currentSpeed = 1000;
		//将更新的(速度)数据写入
		ControlPage.dataController.dataUpdate(3, currentSpeed);
	}
	
	public void sppedDown() {
		//速度不可低于0
		if((currentSpeed-stepOver) >= 0)
			currentSpeed-=stepOver;
		else 
			currentSpeed = 0;
		//将更新的(速度)数据写入
		ControlPage.dataController.dataUpdate(3, currentSpeed);
	}
	
	
	//getter & setter
	public void setSpeed(int speed) {
		//速度不可超过1000或低于0
		if(speed >= 0 && speed <= 1000)
			currentSpeed = speed;
		//将更新的(速度)数据写入
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
