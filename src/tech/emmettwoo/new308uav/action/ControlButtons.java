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
	    			ToastUtils.showExistToast(ControlPage.self, "�ٶ��Ѵ����ֵ");
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
	    			ToastUtils.showExistToast(ControlPage.self, "�ٶ��Ѵ���Сֵ");
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
	        	ToastUtils.showNewToast(ControlPage.self, "���˻����������ӳɹ�");
	        }
	    });
		
		Button btnBoost = (Button)ControlPage.self.findViewById(R.id.btnBoost);
		btnBoost.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	//�����˻����������������ӣ�����������÷�������Ч
	    		if(ControlPage.stillBoost){
	    			ToastUtils.showNewToast(ControlPage.self, "����������");
	    		} else if(ControlPage.socket==null) {
	    			ToastUtils.showNewToast(ControlPage.self, "δ���ӵ����˻�");
	    		} else {
	    			//���� ѭ���������� Ϊ��
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
	        	//��������Ϊ��
	        	ControlPage.dataController.dataUpdate(3, 0);
	        	ControlPage.speedController.setSpeed(0);
	        	
	        	//���� ѭ���������� Ϊ��
	        	ControlPage.stillBoost = false;
	        	ControlPage.seekBarUtils.updateSeekBar();
	        	ToastUtils.showNewToast(ControlPage.self, "����ֹͣ����");
	        	
	        	//�ر�����������ÿ�socket�������ڣ�
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
