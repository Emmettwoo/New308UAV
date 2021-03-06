package tech.emmettwoo.new308uav.action;

import tech.emmettwoo.new308uav.ControlPage;
import tech.emmettwoo.new308uav.R;
import tech.emmettwoo.new308uav.runnable.ClientConnect;
import tech.emmettwoo.new308uav.runnable.ClientSendData;
import tech.emmettwoo.new308uav.util.ToastUtils;
import android.view.View;
import android.widget.Button;

public class ControlButtons {
	
	public void ControlButtonListener() {
		this.powerChangeButtonListener();
		this.speedChangeButtonListener();
		this.directionChangeButtonListener();
	}
	
	private void directionChangeButtonListener() {
		Button button56up = (Button)ControlPage.self.findViewById(R.id.button56up);
		button56up.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	ControlPage.dataController.dataStepOverUp(5);
	        	ControlPage.textViewUtils.updateSeekBarText();
	        }
	    });
		
		Button button56down = (Button)ControlPage.self.findViewById(R.id.button56down);
		button56down.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	ControlPage.dataController.dataStepOverDown(5);
	        	ControlPage.textViewUtils.updateSeekBarText();
	        }
	    });
		
		Button button78up = (Button)ControlPage.self.findViewById(R.id.button78up);
		button78up.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	ControlPage.dataController.dataStepOverUp(7);
	        	ControlPage.textViewUtils.updateSeekBarText();
	        }
	    });
		
		Button button78down = (Button)ControlPage.self.findViewById(R.id.button78down);
		button78down.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	ControlPage.dataController.dataStepOverDown(7);
	        	ControlPage.textViewUtils.updateSeekBarText();
	        }
	    });
		
		Button button90up = (Button)ControlPage.self.findViewById(R.id.button90up);
		button90up.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	ControlPage.dataController.dataStepOverUp(9);
	        	ControlPage.textViewUtils.updateSeekBarText();
	        }
	    });
		
		Button button90down = (Button)ControlPage.self.findViewById(R.id.button90down);
		button90down.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	ControlPage.dataController.dataStepOverDown(9);
	        	ControlPage.textViewUtils.updateSeekBarText();
	        }
	    });
	}

	private void speedChangeButtonListener() {
		Button btnSpeedUp = (Button)ControlPage.self.findViewById(R.id.btnSpeedUp);
		
		btnSpeedUp.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	ControlPage.speedController.sppedUp();
	    		if(ControlPage.speedController.getSpeed()==1000) {
	    			ToastUtils.showExistToast(ControlPage.self, "速度已达最大值");
	    		}
	    		ControlPage.seekBarUtils.updateSeekBar();
	    		
	        }
	    });
		
		Button btnSpeedDown = (Button)ControlPage.self.findViewById(R.id.btnSpeedDown);
		btnSpeedDown.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	ControlPage.speedController.sppedDown();
	    		if(ControlPage.speedController.getSpeed()==0) {
	    			ToastUtils.showExistToast(ControlPage.self, "速度已达最小值");
	    		}
	    		ControlPage.seekBarUtils.updateSeekBar();
	        }
	    });	
	}

	private void powerChangeButtonListener() {
		Button btnConnect = (Button)ControlPage.self.findViewById(R.id.btnConnect);
		btnConnect.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	Thread t = new Thread(new ClientConnect());
	        	t.start();
	        	ToastUtils.showNewToast(ControlPage.self, "无人机快闪则连接成功");
	        }
	    });
		
		Button btnBoost = (Button)ControlPage.self.findViewById(R.id.btnBoost);
		btnBoost.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	//若无人机不在运行且已连接，将上面的设置发送以生效
	    		if(ControlPage.stillBoost){
	    			ToastUtils.showNewToast(ControlPage.self, "已在运行中");
	    		} else if(ControlPage.socket==null) {
	    			ToastUtils.showNewToast(ControlPage.self, "未连接到无人机");
	    		} else {
	    			//设置 循环启动条件 为真
	    			ControlPage.stillBoost = true;
	    			ControlPage.seekBarUtils.updateSeekBar();
	    			Thread t = new Thread(new ClientSendData());
	    			t.start();
	    		}
	        }
	    });
		
		Button btnShutdown = (Button)ControlPage.self.findViewById(R.id.btnShutdown);
		btnShutdown.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	//油门设置为零
	        	ControlPage.dataController.dataUpdate(3, 0);
	        	ControlPage.speedController.setSpeed(0);
	        	
	        	//设置 循环启动条件 为假
	        	ControlPage.stillBoost = false;
	        	ControlPage.seekBarUtils.updateSeekBar();
	        	ToastUtils.showNewToast(ControlPage.self, "正在停止运行");
	        	
	        	//关闭连接隧道并置空socket（若存在）
	        	/*try {
	        		if(socket!=null) {
	        			socket.close();
	        			socket = null;
	        		}		
	    		} catch (IOException e) {
	    			e.printStackTrace();
	    		}*/
	        }
	    });
	}
}
