/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sales.system.frontend.restclient;

import com.mycompany.sales.system.frontend.model.Customer;
import com.mycompany.sales.system.frontend.model.ProductCategory;
import com.mycompany.sales.system.frontend.model.Store;
import com.mycompany.sales.system.frontend.view.StoreView;
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
public interface StoreService {

    @GET("/v1/store")
    Call<List<Store>> findAll(@Header("Authorization") String token);
    
    @POST("/v1/store")
    Call<HttpStatus> save(@Header("Authorization") String token, @Body Store store);
    
    @PATCH("/v1/store")
    Call<HttpStatus> update(@Header("Authorization") String token, @Body Store store);
    
    @DELETE("/v1/store/{id}")
    Call<HttpStatus> delete(@Header("Authorization") String token, @Path("id") int id);

}
