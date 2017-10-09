

public class PostMain {

	public static void main(String[] args) {
		
		PostMain o = new PostMain();
		
		System.out.println(o.getClass().getClassLoader());
		System.out.println(o.getClass().getClassLoader().getParent());
		System.out.println(o.getClass().getClassLoader().getParent().getParent());
	}

}
