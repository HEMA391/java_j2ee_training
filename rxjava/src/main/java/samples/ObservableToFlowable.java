package samples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.TestSubscriber;

public class ObservableToFlowable {

	public static void main(String[] args) {
		thenAllValuesAreBufferedAndReceived();		
	}

	public static <T> void thenAllValuesAreBufferedAndReceived() {
		List testList = new ArrayList<>();
		testList.add(10);
		System.out.println("Integers in list"+testList.toString());	
		@SuppressWarnings("unchecked")
		Observable<T> observable = Observable.fromIterable(testList);
		
		@SuppressWarnings("unchecked")
		TestSubscriber<Integer> testSubscriber = (TestSubscriber<Integer>) observable
				.toFlowable(BackpressureStrategy.BUFFER).observeOn(Schedulers.computation()).test();
		testSubscriber.awaitTerminalEvent();
		
		
		List<Integer> receivedInts = testSubscriber.getEvents().get(0).stream().mapToInt(object -> (int) object).boxed()
				.collect(Collectors.toList());
		System.out.println("Integers received"+receivedInts.toString());
	}

}
