

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
/**
 * 工具类：将一字符串转成MD5值
 * 
 * */
public class MD5Util {

	public final static String MD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	public final static Boolean isNull(String s) {
		return (s == null || "null".equals(s.toLowerCase()) || s.length() == 0);
	}
	public final static Boolean isNotNull(String s) {
		return (s != null && !"null".equals(s.toLowerCase()) && s.length() > 0);
	}
	
	public final static List<String> getRemoveSomeItem(List<String> list, String s) {
		if (list != null && list.size() > 0 && MD5Util.isNotNull(s)) {
			for ( int i = 0; i < list.size(); i++) {
				String item = list.get(i);
				if (s.equals(item)) {
					list.remove(i);
					i --;
				}
			}
		}
		return list;
	}
	
	public final static List<String> getRemoveSomeItem(List<String> list, List<String> sublist) {
		List<String> lresult = new ArrayList<String>();
		if (list != null && list.size() > 0 && sublist != null && sublist.size() > 0) {
			for (String itemtemp : list) {
				int iflag = 1;
				for (String item : sublist) {
					if (MD5Util.isNotNull(item) && item.equals(itemtemp)) {
						iflag = 1;
						break;
					} else {
						iflag = 0;
					}
				}
				if (iflag == 0) {
					lresult.add(itemtemp);
				}
			}
		}
		return lresult;
	}
    public static void main(String[] args) {

        System.out.println(MD5Util.MD5("http://gigaom.com/2014/02/15/5-things-everyone-should-know-about-hadoop/"));
        System.out.println(MD5Util.MD5("www.test2.com"));
        System.out.println(MD5Util.MD5("www.test3.com"));

    }
}
