package wzg;

import java.net.InetAddress;
import java.net.Socket;
//�ͻ���
public class TalkClient {

	public static void main(String[] args) {
		try {
			Socket socket=new Socket(InetAddress.getLocalHost(),10086);
			System.out.println("�����ӵ�������");
			new ReceiverThread(socket).start();
			new SendThread(socket).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
