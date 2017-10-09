
public class TestStatic {
	public static void main(String[] args) {
		
		String s = "http://geek.csdn.net/news/detail/43590";
		
		String id = MD5Util.MD5(s) +"_1_IPHONE_APP";
		System.out.println(id);
	}
}
