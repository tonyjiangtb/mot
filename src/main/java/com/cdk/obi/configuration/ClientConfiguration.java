package com.cdk.obi.configuration;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cdk.obi.service.MOTInterface;

//@Configuration
public class ClientConfiguration {
    @Bean(name = "client")
    public Object generateProxy() {
        return proxyFactoryBean().create();
    }

    @Bean
    public JaxWsProxyFactoryBean proxyFactoryBean() {
        JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
        proxyFactory.setServiceClass(MOTInterface.class);
        proxyFactory.setAddress("http://localhost:8081/services/baeldung");
        return proxyFactory;
    }
}