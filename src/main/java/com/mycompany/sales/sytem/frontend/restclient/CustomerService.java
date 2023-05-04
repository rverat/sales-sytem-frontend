/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sales.sytem.frontend.restclient;

import com.mycompany.sales.sytem.frontend.model.Customer;
import java.util.List;
import org.springframework.http.HttpStatus;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 *
 * @author ro
 */
public interface CustomerService {

    @GET("/customer")
    Call<List<Customer>> getAll();
    
    @POST("/customer")
    Call<HttpStatus> save(@Body Customer customer);
    
    @PATCH("/customer")
    Call<HttpStatus> update(@Body Customer customer);
    
    @DELETE("/customer/{id}")
    Call<HttpStatus> delete(@Path("id") int id);

}
