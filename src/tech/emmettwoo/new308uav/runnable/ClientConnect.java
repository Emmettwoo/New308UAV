package tech.emmettwoo.new308uav.runnable;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import tech.emmettwoo.new308uav.ControlPage;

//线程：连接无人机
public class ClientConnect implements Runnable{
	@Override
	public void run() {
		try {
			//新建socket隧道连接到无人机网关后台端口333
			ControlPage.socket = new Socket("192.168.4.1", 333);
			
			//通过socket获取一个输出流以输出控制指令
			OutputStream out = ControlPage.socket.getOutputStream();
			//发送连接指令"GEC\r\n"，成功控制无人机
			out.write("GEC\r\n".getBytes());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
