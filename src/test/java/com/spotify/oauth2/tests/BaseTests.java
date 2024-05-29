package com.spotify.oauth2.tests;

import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTests {
    @BeforeMethod
    public void printThread(Method method){
        System.out.println("STARTING TEST: " + method.getName());
        System.out.println("THREAD ID: " + Thread.currentThread().threadId());
    }
}
