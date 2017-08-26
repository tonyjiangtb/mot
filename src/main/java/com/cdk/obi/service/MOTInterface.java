package com.cdk.obi.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MOTInterface {
    @WebMethod
    String hello(String name);
    String register(Student student);
    String RegisterDealer(String name);
    String LoginDealer(String name, String password);
    String AsyncUpload(String ServiceRecords);
    String AsyncGetResults(String job);
    String Upload(String ServiceRecords);
}