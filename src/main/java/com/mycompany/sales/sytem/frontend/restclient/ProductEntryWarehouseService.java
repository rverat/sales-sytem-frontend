/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sales.sytem.frontend.restclient;

import com.mycompany.sales.sytem.frontend.model.Customer;
import com.mycompany.sales.sytem.frontend.model.ProductCategory;
import com.mycompany.sales.sytem.frontend.model.ProductEntryWarehouse;
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
public interface ProductEntryWarehouseService {

    @GET("/product-entry-warehouse")
    Call<List<ProductEntryWarehouse>> getAll();
    
    @POST("/product-entry-warehouse")
    Call<HttpStatus> save(@Body ProductEntryWarehouse productEntryWarehouse);
    
    @PATCH("/product-entry-warehouse")
    Call<HttpStatus> update(@Body ProductEntryWarehouse productEntryWarehouse);
    
    @DELETE("/product-entry-warehouse/{id}")
    Call<HttpStatus> delete(@Path("id") int id);

}
