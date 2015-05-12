import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.UnknownHostException;
import java.util.Arrays;


public class Test01 {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		
		//获取本机InterAdress的实例
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("计算机名:" + address.getHostName());
		System.out.println("IP地址：" + address.getHostAddress());
		byte[] bytes = address.getAddress();//获取字节数组形式IP地址
		System.out.println("字节数组形式的IP地址：" + Arrays.toString(bytes));
		System.out.println(address);//直接输出InetAddress对象
		
		//根据机器名获取InetAddress实例
		InetAddress  address2 = InetAddress.getByName("gannyee-PC");
		System.out.println("计算机名:" + address2.getHostName());
		System.out.println("IP地址：" + address2.getHostAddress());
		
		//根据IP地址获取InetAddress实例
		InetAddress  address3 = InetAddress.getByName("169.254.207.238");
		System.out.println("计算机名:" + address3.getHostName());
		System.out.println("IP地址：" + address3.getHostAddress());
	}
	

}
