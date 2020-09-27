package com.trendyol.actions.services;

import com.trendyol.commons.services.PetStoreLibrary;

public class PetStoreAction extends PetStoreLibrary  {
	public <T> PetStoreAction(){
		super();
	}

	public void getUserByUserName() {
	getServices(url, "/v2/user/burak", "getUserByUserName");
	}
	
	public void getOrderId() {
	getServices(url, "/v2/store/order/1", "getOrderId");
	}
	
	public void getInventory() {
	getServices(url, "/v2/store/inventory", "getInventory");
	}
	
	public void getStatus() {
		getServices(url, "/v2/pet/findByStatus?status=available", "getStatus");
		}
	
	public void deleteUpdateAnExistinPet() {
	deleteServices(url, "/v2/store/order/1", "deleteUpdateAnExistinPet");
	}
	
	public void postCreateWhiteList () {
		String body= "[{\"id\": 0,\"username\": \"burak\",\"firstName\":\"string\",\"lastName\":\"string\",\"email\":\"string\",\"password\": \"burak\",\"phone\": \"string\",\"userStatus\": 0}]";
		postServices(url, "/v2/user/createWithList", body, "postCreateWhiteList");
	}
	
	public void postPlaceAnOrderForAPet () {
		String body= "{\"id\": 1,\"petId\": 0,\"quantity\": 0,\"shipDate\": \"2020-08-16T21:18:52.569Z\",\"status\": \"placed\",\"complete\": true}";
		postServices(url, "/v2/store/order", body, "postPlaceAnOrderForAPet");
	}
	
	public void putUpdateAnExistinPet () {
		String body= "{\"id\": 0,\"category\": {\"id\": 0,\"name\": \"string\"},\"name\": \"doggie\",\"photoUrls\": [\"string\"],\"tags\": [{\"id\": 0,\"name\": \"string\"}],\"status\": \"available\"}";
		putServices(url, "/v2/pet", body, "putUpdateAnExistinPet");
	}
}