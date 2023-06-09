/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sales.system.frontend.restclient;

import com.mycompany.sales.system.frontend.model.Product;
import java.util.List;
import org.springframework.http.HttpStatus;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 *
 * @author ro
 */
public interface ProductService {

    @GET("/v1/products")
    Call<List<Product>> findAll(@Header("Authorization") String token);
    
    @GET("/v1/products/{id}")
    Call<Product> findById(@Header("Authorization") String token, @Path("id") int id);
    
    @POST("/v1/products")
    Call<HttpStatus> save(@Header("Authorization") String token, @Body Product product);
    
    @PATCH("/v1/products")
    Call<HttpStatus> update(@Header("Authorization") String token, @Body Product product);
    
    @DELETE("/v1/products/{id}")
    Call<HttpStatus> delete(@Header("Authorization") String token, @Path("id") int id);

}
