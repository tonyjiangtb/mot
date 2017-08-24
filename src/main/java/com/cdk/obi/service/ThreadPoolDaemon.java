package com.cdk.obi.service;

import javax.xml.ws.Endpoint;
import org.apache.cxf.jaxws.EndpointImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.cdk.obi.soapif.StockQuoteReporter;

@Configuration
public class ThreadPoolDaemon {

	ThreadPoolDaemon(){
		System.out.println("daemon created");
	}


	    @Bean
	    public Endpoint endpoint() {
	        //EndpointImpl endpoint = new EndpointImpl(null, new BaeldungImpl());
	    	EndpointImpl endpoint = new EndpointImpl(null, new BaeldungImpl());
	    	//StockQuoteReporter endpoint =new StockQuoteReporter();
	        endpoint.publish("http://localhost:8081/services/baeldung");
	        return endpoint;
	    }

}
