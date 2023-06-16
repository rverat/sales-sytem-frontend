/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sales.system.frontend.restclient;

import com.mycompany.sales.system.frontend.model.Supplier;
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
public interface SupplierService {

    @GET("/v1/supplier")
    Call<List<Supplier>> findAll(@Header("Authorization") String token);
    
    @POST("/v1/supplier")
    Call<HttpStatus> save(@Header("Authorization") String token, @Body Supplier supplier);
    
    @PATCH("/v1/supplier")
    Call<HttpStatus> update(@Header("Authorization") String token, @Body Supplier supplier);
    
    @DELETE("/v1/supplier/{id}")
    Call<HttpStatus> delete(@Header("Authorization") String token, @Path("id") int id);

}
