import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestStatic2 {

	private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(
			1, 10, 500, TimeUnit.MILLISECONDS,
			new ArrayBlockingQueue<Runnable>(25));

	public static synchronized void aaa(int a) {
		System.out.println(a + " start - " + Thread.currentThread().getId());
		System.out.println(a + " .... - "+ Thread.currentThread().getId());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(a + " end - "+ Thread.currentThread().getId());
	}

	public static void main(String[] args) {
		for (int i = 0; i < 33; i++) {
			final int a = i;
			executor.execute(new Runnable() {
				public void run() {
					aaa(a);
				}
			});
		}
	}

}
