package com.trendyol.test.services.petstore;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.trendyol.actions.services.PetStoreAction;
import com.trendyol.base.ServicesAbstractTest;


public class GetInventory extends ServicesAbstractTest {
	PetStoreAction ps;
@BeforeMethod
public void Before (Method method) {
	ps=new PetStoreAction();
}

@Test
public void getUserByUserName()  {

ps.getInventory();
}

}