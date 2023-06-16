package com.mycompany.sales.system.frontend.restclient.config;


import java.lang.reflect.Method;
import java.util.List;
import retrofit2.Call;
import retrofit2.Response;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ro
 */
public class GenericRestService<T>  {

    private T service;
    private String baseUrl;
    private String methodName;
    private Class<?> responseClass;

    public GenericRestService(T service, String baseUrl, String methodName, Class<?> responseClass) {
        this.service = service;
        this.baseUrl = baseUrl;
        this.methodName = methodName;
        this.responseClass = responseClass;
    }

    public GenericRestService(T service, String baseUrl, String methodName) {
        this.service = service;
        this.baseUrl = baseUrl;
        this.methodName = methodName;
    }
    
        
    public List<?> getAll() throws Exception {
        Method method = service.getClass().getMethod(methodName);
        Call<List<?>> call = (Call<List<?>>) method.invoke(service);
        Response<List<?>> response = call.execute();
        return response.body();
    }

    public void save(Object requestBody) throws Exception {
        Method method = service.getClass().getMethod(methodName);
        Call<List<?>> call = (Call<List<?>>) method.invoke(service);
        call.execute();
    }

    public void delete(int id) throws Exception {
        Method method = service.getClass().getMethod(methodName);
        Call<List<?>> call = (Call<List<?>>) method.invoke(service);
        call.execute();
    }
}
