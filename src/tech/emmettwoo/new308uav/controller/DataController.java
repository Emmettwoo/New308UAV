package tech.emmettwoo.new308uav.controller;

import tech.emmettwoo.new308uav.ControlPage;
import tech.emmettwoo.new308uav.util.ToastUtils;
import android.content.SharedPreferences;

public class DataController {
	//初始化各方向参数和步进
	public byte[] data = new byte[34];
	private int stepOver = 25;
	private int direction5 = 1500;
	private int direction7 = 1500;
	private int direction9 = 1500;
	
	//初始化数据
	public DataController() {
		data[0] = (byte) 0xAA;
		data[1] = (byte) 0xC0;
		data[2] = (byte) 0x1C;	
		
		data[3] = (byte) (200>>8);
		data[4] = (byte) (200&0xff);
		data[5] = (byte) (1500>>8);
		data[6] = (byte) (1500&0xff);
		data[7] = (byte) (1500>>8);
		data[8] = (byte) (1500&0xff);
		data[9] = (byte) (1500>>8);
		data[10] = (byte) (1500&0xff);

		data[31] = (byte) 0x1C;
		data[32] = (byte) 0x0D;
		data[33] = (byte) 0x0A;
	}
	
	//数据更新（传啥更啥，用于速度）
	public void dataUpdate(int position, int value) {
		//每个参数由高八位第八位两个字节组成
		data[position] = (byte) (value>>8);
		data[position+1] = (byte) (value&0xff);
	}
	
	//数据增减（步进改值，用于方向）
	public void dataStepOverUp(int position) {
		switch (position) {
		case 5:
			direction5+=stepOver;
			data[5] = (byte) (direction5>>8);
			data[6] = (byte) (direction5&0xff);
			break;
		case 7:
			direction7+=stepOver;
			data[7] = (byte) (direction7>>8);
			data[8] = (byte) (direction7&0xff);
			break;
		case 9:
			direction9+=stepOver;
			data[9] = (byte) (direction9>>8);
			data[10] = (byte) (direction9&0xff);
			break;
		default:
			break;
		}
	}

	public void dataStepOverDown(int position) {
		switch (position) {
		case 5:
			direction5-=stepOver;
			data[5] = (byte) (direction5>>8);
			data[6] = (byte) (direction5&0xff);
			break;
		case 7:
			direction7-=stepOver;
			data[7] = (byte) (direction7>>8);
			data[8] = (byte) (direction7&0xff);
			break;
		case 9:
			direction9-=stepOver;
			data[9] = (byte) (direction9>>8);
			data[10] = (byte) (direction9&0xff);
			break;
		default:
			break;
		}
	}
	
	public void directionDataSave() {
		SharedPreferences sharedPreferences = ControlPage.self.getSharedPreferences("directionData", ControlPage.MODE_PRIVATE);
    	SharedPreferences.Editor editor = sharedPreferences.edit();
    	
    	editor.putInt("direction5", direction5);
    	editor.putInt("direction7", direction7);
    	editor.putInt("direction9", direction9);
    	
    	editor.commit();
    	ToastUtils.showNewToast(ControlPage.self, "保存成功");
	}
	
	public void directionDataRead() {
		SharedPreferences sharedPreferences = ControlPage.self.getSharedPreferences("directionData", ControlPage.MODE_PRIVATE);
    	direction5 = sharedPreferences.getInt("direction5", 1500);
    	direction7 = sharedPreferences.getInt("direction7", 1500);
    	direction9 = sharedPreferences.getInt("direction9", 1500);
    	ControlPage.textViewUtils.updateSeekBarText();
	}
	
	//getter & setter
	public int getStepOver() {
		return stepOver;
	}

	public void setStepOver(int stepOver) {
		this.stepOver = stepOver;
	}

	public int getDirection5() {
		return direction5;
	}

	public void setDirection5(int direction5) {
		this.direction5 = direction5;
	}

	public int getDirection7() {
		return direction7;
	}

	public void setDirection7(int direction7) {
		this.direction7 = direction7;
	}

	public int getDirection9() {
		return direction9;
	}

	public void setDirection9(int direction9) {
		this.direction9 = direction9;
	}
	
	public byte[] getData() {
		return data;
	}
}
