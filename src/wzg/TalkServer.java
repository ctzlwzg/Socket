package wzg;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
//�����
public class TalkServer {

	public static void main(String[] args) {
		Socket socket=null;
		try {
			ServerSocket server=new ServerSocket(10086);
			System.out.println("���������...");
			socket=server.accept();
			new ReceiverThread(socket).start();
			new SendThread(socket).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
