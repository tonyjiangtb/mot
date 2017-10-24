package com.cdk.newfunc;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
  
public class HttpClientTest {  
  
	public final static void main(String[] args) throws Exception {
		RequestConfig requestConfig = RequestConfig.custom()  
                .setConnectionRequestTimeout(3000) //从连接池中获取连接的超时时间     
                .setConnectTimeout(3000) //与服务器连接超时时间：httpclient会创建一个异步线程用以创建socket连接，此处设置该socket的连接超时时间  
                .setSocketTimeout(5000) //socket读数据超时时间：从服务器获取响应数据的超时时间  
                .build();  
		
        //CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpClient httpclient = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();
        try {
            HttpGet httpget = new HttpGet("http://www.baidu.com");

            System.out.println("Executing request " + httpget.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                @Override
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
            HttpHost proxy=new HttpHost("31.135.64.76",3128,"HTTP");
            //String responseBody = httpclient.execute(httpget, responseHandler);
            String responseBody=httpclient.execute(proxy,httpget,responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        } catch (Exception e){
        	e.printStackTrace();
        }
        finally {
        
            httpclient.close();
        }
    }
}