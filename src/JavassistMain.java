import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;


public class JavassistMain {

	
	public static void main(String[] args) {
		final ClassPool cp = ClassPool
				.getDefault();
		try{
			CtClass clsb = cp.get("Book");
			CtMethod ctMethod = clsb.getDeclaredMethod("test");
	        ctMethod.setBody("System.out.println(\"----------test\");");
			Book b = (Book)clsb.toClass().newInstance();
			b.test();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
