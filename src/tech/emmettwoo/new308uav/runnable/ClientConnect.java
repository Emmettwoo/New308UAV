package tech.emmettwoo.new308uav.runnable;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import tech.emmettwoo.new308uav.ControlPage;

//�̣߳��������˻�
public class ClientConnect implements Runnable{
	@Override
	public void run() {
		try {
			//�½�socket������ӵ����˻����غ�̨�˿�333
			ControlPage.socket = new Socket("192.168.4.1", 333);
			
			//ͨ��socket��ȡһ����������������ָ��
			OutputStream out = ControlPage.socket.getOutputStream();
			//��������ָ��"GEC\r\n"���ɹ��������˻�
			out.write("GEC\r\n".getBytes());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
