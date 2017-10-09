package location;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class Secret {
	public static void main(String[] args) {
		try {
			int CID = 0xb088;
			int LAC = 0x4194;
			URL url = new URL("http://www.google.com/glm/mmap");
			System.out.println("connectting ");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			System.out.println("connectted");
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			OutputStream outStream = conn.getOutputStream();
			DataOutputStream os = new DataOutputStream(outStream);
			os.writeShort(21);
			os.writeLong(0);
			os.writeUTF("ch");
			os.writeUTF("Android");
			os.writeUTF("4.0.3");
			os.writeUTF("cellphone");
			os.writeByte(27);
			os.writeInt(0);
			os.writeInt(0);
			os.writeInt(3);
			os.writeUTF("");
			os.writeInt(CID); // CELL-ID
			os.writeInt(LAC); // LAC
			os.writeInt(0);
			os.writeInt(0);
			os.writeInt(0);
			os.writeInt(0);
			System.out.println(os);
			os.flush();
			os.close();
			InputStream in = new BufferedInputStream(conn.getInputStream());
			DataInputStream dis = new DataInputStream(in);
            // Read some prior data
            dis.readShort();
            dis.readByte();
            int errorCode = dis.readInt();
            if (errorCode == 0) {
                    double lat = (double) dis.readInt() / 1000000D;
                    double lng = (double) dis.readInt() / 1000000D;
                    System.out.println("lat="+lat);
                    System.out.println("lng="+lng);
                    dis.readInt();
                    dis.readInt();
                    dis.readUTF();
                   
                   
            }else
			System.out.println("11111");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			 System.out.println("222222");
		}
	}
}
