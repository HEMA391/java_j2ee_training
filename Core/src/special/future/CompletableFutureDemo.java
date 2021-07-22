package special.future;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class CompletableFutureDemo {

	public static void main(String[] args) {

		CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(new Supplier<String>() {
			@Override
			public String get() {
				return test1();
			}
		});
		CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(new Supplier<String>() {
			@Override
			public String get() {
				return test2();
			}
		});
		CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(cf1, cf2);
		try {
			// This combines both the cf1 and cf2 to complete. If anyone fails, it throws
			// exception
			combinedFuture.get();
		} catch (Exception e) {

			System.out.print("Exception: " + e.toString());
		}

		// Now get the results from both the cf
		String string1 = cf1.join();
		String string2 = cf2.join();
		System.out.print(string1 + " " + string2);
	}

	private static String test1() {
		return "Hello";
	}

	private static String test2() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "World";
	}

}
