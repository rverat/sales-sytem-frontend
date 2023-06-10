/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sales.sytem.frontend.restclient;

import com.mycompany.sales.sytem.frontend.model.Sale;
import com.mycompany.sales.sytem.frontend.model.SaleDetail;
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
public interface SaleService {

    @GET("/v1/sale")
    Call<List<Sale>> findAll(@Header("Authorization") String token);
    
    @POST("/v1/sale")
    Call<HttpStatus> save(@Header("Authorization") String token, @Body List<SaleDetail> saleDetail);
    
    @PATCH("/v1/sale")
    Call<HttpStatus> update(@Header("Authorization") String token, @Body List<SaleDetail> saleDetail);
    
    @PATCH("/v1/sale/{id}")
    Call<HttpStatus> cancelSale(@Header("Authorization") String token, @Path("id") int id);
    
    @DELETE("/v1/sale/{id}")
    Call<HttpStatus> delete(@Header("Authorization") String token, @Path("id") int id);

}
