package com.sunlife.designpatterns;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;
import com.sunlife.designpatterns.Singleton;

public class SingletonTest {
	private static final int THREAD_POOL_SIZE = 200;
	private static final int TASK_COUNT = 2_000_000;
	private static final int INSTANCE_COUNT = 1;

	@Before
	public void setup() {
		// 
	}
	
	@Test
	public void multithreadCreatedInstanceShouldBeOne() {
		ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
		Set<Singleton> instanceSet = Collections.synchronizedSet(new HashSet<>());

		long startNanoseconds = System.nanoTime();
		// Submits the tasks by executor
		for (int i = 0; i < TASK_COUNT; i++) {
			executor.submit(() -> instanceSet.add(Singleton.getInstance()));
		}
		
		// Calculate how many nanoseconds consumed to execute all tasks
		long elapsed = System.nanoTime() - startNanoseconds;

		System.out.println("Elapsed Nanoseconds = " + elapsed);
		// The size of instanceSet should be one because we should have only one instance
		Assert.assertEquals(INSTANCE_COUNT, instanceSet.size());
	}
		 	
}
