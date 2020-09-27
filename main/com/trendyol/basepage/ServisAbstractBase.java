package com.trendyol.basepage;

import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import com.trendyol.utility.log;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public abstract class ServisAbstractBase extends AbstractBase {
	
	protected Response response=null;
	protected OkHttpClient.Builder client =client();
	protected String url= "https://petstore.swagger.io";
	protected String requestBody= null;
	
    private OkHttpClient.Builder client(){
    	OkHttpClient.Builder client = new OkHttpClient.Builder();
    	client.connectTimeout(30, TimeUnit.SECONDS);
    	client.readTimeout(45, TimeUnit.SECONDS);
    	client.writeTimeout(30, TimeUnit.SECONDS);
    	client.hostnameVerifier(new HostnameVerifier() {
			
			@Override
			public boolean verify(String hostname, SSLSession session) {
				
				return true;
			}
		});
    	return client;
    }
	
    abstract public String getSessionId(Response res);
    
    protected Request getService (String url) {
    	return new Request.Builder().url(url).get().addHeader("content-type", "application/json")
    			//.addHeader("cookie", getSessionId(response))
    			.build();
    }
    
	protected String getServices(String url, String service, String serviceName) {
		String body="";
		try {
			Request request = getService(url+service);
			response= client.build().newCall(request).execute();
			body=response.body().string();
			Control(response.isSuccessful(), serviceName + "Basarili " + "<br>" + response.message() + "<br>" + body +"",serviceName + "Basarisiz " + "<br>" + response.message() + "<br>" + body +"");
		}
		catch (Exception e) {
			log.error(e.toString());
		}
		return body;
	}
	
	  protected Request deleteService (String url) {
	    	return new Request.Builder().url(url).delete().addHeader("content-type", "application/json")
	    			//.addHeader("cookie", getSessionId(response))
	    			.build();
	    }
	
	protected String deleteServices(String url, String service, String serviceName) {
		String body="";
		try {
			Request request = deleteService(url+service);
			response= client.build().newCall(request).execute();
			body=response.body().string();
			Control(response.isSuccessful(), serviceName + "Basarili " + "<br>" + response.message() + "<br>" + body +"",serviceName + "Basarisiz " + "<br>" + response.message() + "<br>" + body +"");
		}
		catch (Exception e) {
			log.error(e.toString());
		}
		return body;
	}
	
	public Request postService(String url, String body) {
		requestBody= body;
		return new Request.Builder().url(url).post(RequestBody.create(MediaType.parse("application/json\""), body))
				.addHeader("content-type", "application/json")
    			.build();
	}
	
	protected String postServices(String url, String service,String body, String serviceName) {
		String responsebody="";
		try {
			Request request = postService(url+service,body);
			response= client.build().newCall(request).execute();
			responsebody=response.body().string();
			Control(response.isSuccessful(), serviceName + "Basarili " + "<br><br>" + "Request :" + "<br>" + body +"",serviceName + "Basarisiz " + "<br>" + response.message() + "<br>" + body +"");
		}
		catch (Exception e) {
			log.error(e.toString());
		}
		return responsebody;
	}
	
	public Request putService(String url, String body) {
		requestBody= body;
		return new Request.Builder().url(url).put(RequestBody.create(MediaType.parse("application/json\""), body))
				.addHeader("content-type", "application/json")
    			.build();
	}
	
	protected String putServices(String url, String service,String body, String serviceName) {
		String responsebody="";
		try {
			Request request = putService(url+service,body);
			response= client.build().newCall(request).execute();
			responsebody=response.body().string();
			Control(response.isSuccessful(), serviceName + "Basarili " + "<br><br>" + "Request :" + "<br>" + body +"",serviceName + "Basarisiz " + "<br>" + response.message() + "<br>" + body +"");
		
		}
		catch (Exception e) {
			log.error(e.toString());
		}
		return responsebody;
	}
	
}