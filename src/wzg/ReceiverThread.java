package wzg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
//接收线程
public class ReceiverThread extends Thread{
	Socket socket=null;
	public ReceiverThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			//创建输入流
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true){
				//从对方读取一行字符串
				String str=in.readLine();
				if(str==null)	break;
				System.out.println("接收到："+str);
				if(str.equals("end"))	break;
			}
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			System.out.println("谈话结束");
			System.exit(0);//结束程序
		}
	}
}
