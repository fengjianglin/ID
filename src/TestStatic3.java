import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TestStatic3 {
	public static List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());

	public static void inc() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
		}
		list.add(0);
		System.out.println("运行结果:Counter.count=" + list.size());
	}

	public static void main(String[] args) {

	 AtomicInteger mSequenceGenerator = new AtomicInteger();
		while(true){
			System.out.println(mSequenceGenerator.getAndAdd(10000000));
		}
	}
}
