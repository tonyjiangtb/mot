package com.cdk.obi.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class ThreadPoolDaemon  {

	private ExecutorService executor = null;

	public ThreadPoolDaemon() {
		System.out.println("daemon created");
	}

	public void Submit(Runnable worker) {
		executor.execute(worker);
	}

	public void Start(String[] args) {
		if (executor == null) {
			executor = Executors.newFixedThreadPool(20);
		}
	}

	public void Stop() {
		if (executor != null) {
			executor.shutdown();
			while (!executor.isTerminated()) {
			}
			executor = null;
			System.out.println("Finished all threads");
		}
	}


}
