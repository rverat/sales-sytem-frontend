/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sales.sytem.frontend.restclient;

import com.mycompany.sales.sytem.frontend.model.Customer;
import com.mycompany.sales.sytem.frontend.model.ProductCategory;
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
public interface SaleDetailService {

    @GET("/v1/sale-detail")
    Call<List<SaleDetail>> findAll(@Header("Authorization") String token);

    @GET("/v1/sale-detail/{saleId}")
    Call<List<SaleDetail>> getSaleDetails(@Header("Authorization") String token, @Path("saleId") int saleId);
    
    @GET("/v1/sale-detail/{saleDetailId}")
    Call<SaleDetail> getSaleDetail(@Header("Authorization") String token, @Path("saleDetailId") int saleDetailId);
    
    @POST("/v1/sale-detail")
    Call<HttpStatus> save(@Header("Authorization") String token, @Body SaleDetail saleDetail);
    
    @PATCH("/v1/sale-detail")
    Call<HttpStatus> update(@Header("Authorization") String token, @Body SaleDetail saleDetail);
    
    @DELETE("/v1/sale-detail/{id}")
    Call<HttpStatus> delete(@Header("Authorization") String token, @Path("id") int id);

    @PATCH("/v1/sale-detail/{saleId}")
    public Call<HttpStatus> cancelSale(String token, @Path("saleId") int saleId);

}
