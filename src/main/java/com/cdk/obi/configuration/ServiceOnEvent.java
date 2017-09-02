package com.cdk.obi.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

import com.cdk.obi.service.ThreadPoolDaemon;

//@Configuration
public class ServiceOnEvent implements ApplicationListener {
	public ServiceOnEvent() {
		System.out.println("ServiceOnevent created");
	}

	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ContextClosedEvent) {
			ApplicationContext rootcontext = ((ContextClosedEvent) event).getApplicationContext();
			//run twice here ,for servlet context can still getbean from its parent
			ThreadPoolDaemon pool = (ThreadPoolDaemon) rootcontext.getBean("UploadPool");
			if (pool != null) {
				pool.Stop();
			}
			
		}
		System.out.println("--------!!!!----------" + event.toString());
	}
}
