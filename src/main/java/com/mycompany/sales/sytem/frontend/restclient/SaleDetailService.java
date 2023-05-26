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
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 *
 * @author ro
 */
public interface SaleDetailService {

    @GET("/sale-detail")
    Call<List<SaleDetail>> getAll();

    @GET("/sale-detail/{saleId}")
    Call<List<SaleDetail>> getSaleDetails(@Path("saleId") int saleId);
    
    @POST("/sale-detail")
    Call<HttpStatus> save(@Body SaleDetail saleDetail);
    
    @PATCH("/sale-detail")
    Call<HttpStatus> update(@Body SaleDetail saleDetail);
    
    @DELETE("/sale-detail/{id}")
    Call<HttpStatus> delete(@Path("id") int id);

}
