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
		 * ���տͻ��˷��͵�����
		 */
		//1.�����������˿�DataGramSocket,ָ���˿�
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket(8800);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2.�������ݱ������ڽ��տͻ��˷��͵�����
		byte[] data = new byte[1024];//�����ֽ����飬ָ�����յ����ݰ��Ĵ�С
		packet = new DatagramPacket(data, data.length);
		//3.���տͻ��˷��͵�����
		System.out.println("*******���������Ѿ��������ȴ��ͻ��˷�������");
		try {
			socket.receive(packet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//�˷����ڽ�������֮ǰ��һֱ����
		//4.��ȡ����
		String info = new String(data,0,packet.getLength());
		System.out.println("���Ƿ��������ͻ���˵��" + info);
		/**
		 * ��ͻ�����Ӧ
		 */
		//1.����ͻ��˵ĵ�ַ���˿ںţ�����
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 = "��ӭ����".getBytes();
		//2.�������ݰ���������Ӧ����Ϣ
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length,address,port);
		//3.��Ӧ�ͻ���
		try {
			socket.send(packet2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//4.�ر���Դ
		socket.close();
	}
}
