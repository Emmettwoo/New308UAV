package tech.emmettwoo.new308uav.runnable;

import java.io.IOException;
import java.io.OutputStream;

import tech.emmettwoo.new308uav.ControlPage;

//�̣߳���������
public class ClientSendData implements Runnable{
	@Override
	public void run() {
		try {
			//ͨ��socket��ȡһ������������䷢��bytesָ��
			//�������ӣ�socket = new Socket("192.168.4.1", 333);
			OutputStream out = ControlPage.socket.getOutputStream();
			out.write(ControlPage.dataController.getData());
			
			//�����˻��������У�����5�������ָ��
			while(ControlPage.stillBoost) {
				Thread.sleep(5);
				out.write(ControlPage.dataController.getData());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}   