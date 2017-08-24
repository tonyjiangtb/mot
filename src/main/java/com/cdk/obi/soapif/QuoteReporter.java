package com.cdk.obi.soapif;

import javax.jws.*;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name="quoteUpdater",
   targetNamespace="http://cxf.apache.org",
   wsdlLocation="http://somewhere.com/quoteExampleService?wsdl")
public interface QuoteReporter
{
	  @WebMethod(operationName="getStockQuote")
	  @RequestWrapper(targetNamespace="http://demo.mycompany.com/types",
	     className="java.lang.String")
	  @ResponseWrapper(targetNamespace="http://demo.mycompany.com/types",
	     className="java.lang.String") //org.eric.demo.Quote
	  @WebResult(targetNamespace="http://demo.mycompany.com/types",
	     name="updatedQuote")
  public String getQuote(@WebParam(name="ticker") String ticker);
}
