/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sales.system.frontend.restclient;

import com.mycompany.sales.system.frontend.model.ProductCategory;
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
public interface ProductCategoryService {
    
    @GET("/v1/product-categories")
    Call<List<ProductCategory>> findAll(@Header("Authorization") String token);
    
    @POST("/v1/product-categories")
    Call<HttpStatus> save(@Header("Authorization") String token, @Body ProductCategory productCategory);
    
    @PATCH("/v1/product-categories")
    Call<HttpStatus> update(@Header("Authorization") String token, @Body ProductCategory productCategory);
    
    @DELETE("/v1/product-categories/{id}")
    Call<HttpStatus> delete(@Header("Authorization") String token, @Path("id") int id);

}
