package tech.emmettwoo.new308uav.runnable;

import java.io.IOException;
import java.io.OutputStream;

import tech.emmettwoo.new308uav.ControlPage;

//线程：发送数据
public class ClientSendData implements Runnable{
	@Override
	public void run() {
		try {
			//通过socket获取一个输出流并对其发送bytes指令
			//冗余连接：socket = new Socket("192.168.4.1", 333);
			OutputStream out = ControlPage.socket.getOutputStream();
			out.write(ControlPage.dataController.getData());
			
			//若无人机保持运行，休眠5毫秒后发送指令
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