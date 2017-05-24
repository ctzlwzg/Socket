package wzg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
//发送线程
public class SendThread extends Thread{
	Socket socket=null;
	public SendThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			//创建键盘输入流
			BufferedReader wt=new BufferedReader(new InputStreamReader(System.in));
			//创建与对方的输出流
			PrintWriter out=new PrintWriter(socket.getOutputStream());
			while(true){
				String str=wt.readLine();
				out.println(str);//把字符串发给对方程序
				out.flush();//刷空输出流
				if(str.equals("end"))	break;
			}
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			System.exit(0);
		}
	}
}
