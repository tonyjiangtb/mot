package com.cdk.obi.configuration;
import com.cdk.obi.service.*;
import javax.xml.ws.Endpoint;


import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.cxf.Bus;

@Configuration
public class ServiceConfiguration {
    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), new MOTInterfaceImpl());
        //http://localhost:8081/services
        endpoint.publish("/MOTServiceUpload");
        return endpoint;
    }
    @Bean(name="UploadPool")
    public ThreadPoolDaemon SetDaemon() {
    	ThreadPoolDaemon threadPool= new ThreadPoolDaemon();
    	
    	threadPool.Start(new String[]{"lala"});
    	for (int i = 0; i < 100; i++) {
			Runnable worker = new UploadWorkerThread("" + i);
			threadPool.Submit(worker);
		}
		return threadPool;
    }
    @Bean
    public ServiceOnEvent SetEvent() {
    	return new ServiceOnEvent();
    }
}