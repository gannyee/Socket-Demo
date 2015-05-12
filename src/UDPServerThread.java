import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class UDPServerThread extends Thread{
	DatagramPacket packet = null;
	public UDPServerThread(DatagramPacket packet){
		this.packet = packet;
	}


	public void run(){
		/**
		 * 接收客户端发送的数据
		 */
		//1.创建服务器端口DataGramSocket,指定端口
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket(8800);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2.创建数据报，用于接收客户端发送的数据
		byte[] data = new byte[1024];//创建字节数组，指定接收的数据包的大小
		packet = new DatagramPacket(data, data.length);
		//3.接收客户端发送的数据
		System.out.println("*******服务器端已经启动，等待客户端发送数据");
		try {
			socket.receive(packet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//此方法在接受数据之前会一直阻塞
		//4.读取数据
		String info = new String(data,0,packet.getLength());
		System.out.println("我是服务器，客户端说：" + info);
		/**
		 * 向客户端响应
		 */
		//1.定义客户端的地址，端口号，数据
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 = "欢迎您！".getBytes();
		//2.创建数据包，包含响应的信息
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length,address,port);
		//3.响应客户端
		try {
			socket.send(packet2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//4.关闭资源
		socket.close();
	}
}
