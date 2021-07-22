package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {

	public static void main(String[] args) {
		// single thread executor is a single 1 off thread for fire and forget
		ExecutorService executorService=Executors.newSingleThreadExecutor();
		executorService.submit((Runnable) ()-> test());
	}

	public static String test() {
		System.out.print("Hello World");
		return "Hello World";
	}
}
