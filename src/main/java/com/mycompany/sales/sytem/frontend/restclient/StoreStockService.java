/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sales.sytem.frontend.restclient;

import com.mycompany.sales.sytem.frontend.model.Customer;
import com.mycompany.sales.sytem.frontend.model.ProductCategory;
import com.mycompany.sales.sytem.frontend.model.StoreStock;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 *
 * @author ro
 */
public interface StoreStockService {

    @GET("/store-stock")
    Call<List<StoreStock>> findAll(@Header("Authorization") String token);

    @POST("/store-stock")
    Call<HttpStatus> save(@Header("Authorization") String token, @Body StoreStock storeStock);

    @POST("/store-stock/stock")
    Call<StoreStock> findByProductIdAndStoreId(
            @Header("Authorization") String token, 
            @Query("productId") int productId,
            @Query("storeId") int storeId);

    @PATCH("/store-stock")
    Call<HttpStatus> update(@Header("Authorization") String token, @Body StoreStock storeStock);

    @DELETE("/store-stock/{id}")
    Call<HttpStatus> delete(@Header("Authorization") String token, @Path("id") int id);

}
