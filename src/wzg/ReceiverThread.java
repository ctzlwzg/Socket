package wzg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
//�����߳�
public class ReceiverThread extends Thread{
	Socket socket=null;
	public ReceiverThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			//����������
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true){
				//�ӶԷ���ȡһ���ַ���
				String str=in.readLine();
				if(str==null)	break;
				System.out.println("���յ���"+str);
				if(str.equals("end"))	break;
			}
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			System.out.println("̸������");
			System.exit(0);//��������
		}
	}
}
