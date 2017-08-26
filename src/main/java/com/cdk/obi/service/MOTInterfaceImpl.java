package com.cdk.obi.service;

import javax.jws.WebService;

@WebService(endpointInterface = "com.cdk.obi.service.MOTInterface")
public class MOTInterfaceImpl implements MOTInterface {
    private int counter;

    public String hello(String name) {
        return "Hello " + name + "!";
    }

    public String register(Student student) {
        counter++;
        return student.getName() + " is registered student number " + counter;
    }

	@Override
	public String RegisterDealer(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String LoginDealer(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String AsyncUpload(String ServiceRecords) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String AsyncGetResults(String job) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Upload(String ServiceRecords) {
		// TODO Auto-generated method stub
		return null;
	}
}