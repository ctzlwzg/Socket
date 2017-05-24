package wzg;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
//服务端
public class TalkServer {

	public static void main(String[] args) {
		Socket socket=null;
		try {
			ServerSocket server=new ServerSocket(10086);
			System.out.println("服务端启动...");
			socket=server.accept();
			new ReceiverThread(socket).start();
			new SendThread(socket).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
