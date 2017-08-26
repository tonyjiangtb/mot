package com.cdk.obi.configuration;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

//@Configuration
public class ServiceOnEvent implements ApplicationListener{
	public ServiceOnEvent(){
		System.out.println("ServiceOnevent created");
	}
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("--------!!!!----------"+event.toString());
	}
}
