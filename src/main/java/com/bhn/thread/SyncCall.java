package com.bhn.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class SyncCall {
	public static void main(String[] args) {
		try {
			ExecutorService e = Executors.newSingleThreadExecutor();

			Future<String> f = e.submit(new Callable<String>() {

				public String call() throws Exception {
					System.out.println(Thread.currentThread().getName()
							+ ":inside callable");
					Thread.sleep(3000);
					System.out.println(Thread.currentThread().getName()
							+ ":inside callable, after sleep");
					return "success";
				}
			});

			try {
				Object o = f.get(2, TimeUnit.SECONDS);
				System.out.println(o);
			} catch (TimeoutException e1) {
				e1.printStackTrace();
				// return to caller after 2 seconds. Executor thread will
				// continue ran to get results
			}

			System.out.println(Thread.currentThread().getName()
					+ ":is future job done?:" + f.isDone());
			Thread.sleep(2000);
			e.shutdown();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
