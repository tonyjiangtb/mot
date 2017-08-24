package com.cdk.obi.soapif;

import javax.jws.*;

@WebService(endpointInterface="org.apache.cxf.quoteReporter",
   targetNamespace="http://cxf.apache.org",
   portName="StockQuotePort",
   serviceName="StockQuoteReporter"
)
public class StockQuoteReporter implements QuoteReporter
{
  public String getQuote(String ticker)
  {
	  return "shit";
  }
}
