import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.UnknownHostException;
import java.util.Arrays;


public class Test01 {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		
		//��ȡ����InterAdress��ʵ��
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("�������:" + address.getHostName());
		System.out.println("IP��ַ��" + address.getHostAddress());
		byte[] bytes = address.getAddress();//��ȡ�ֽ�������ʽIP��ַ
		System.out.println("�ֽ�������ʽ��IP��ַ��" + Arrays.toString(bytes));
		System.out.println(address);//ֱ�����InetAddress����
		
		//���ݻ�������ȡInetAddressʵ��
		InetAddress  address2 = InetAddress.getByName("gannyee-PC");
		System.out.println("�������:" + address2.getHostName());
		System.out.println("IP��ַ��" + address2.getHostAddress());
		
		//����IP��ַ��ȡInetAddressʵ��
		InetAddress  address3 = InetAddress.getByName("169.254.207.238");
		System.out.println("�������:" + address3.getHostName());
		System.out.println("IP��ַ��" + address3.getHostAddress());
	}
	

}
