package wzg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
//·¢ËÍÏß³Ì
public class SendThread extends Thread{
	Socket socket=null;
	public SendThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			BufferedReader wt=new BufferedReader(new InputStreamReader(System.in));
			PrintWriter out=new PrintWriter(socket.getOutputStream());
			while(true){
				String str=wt.readLine();
				out.println(str);
				out.flush();
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
