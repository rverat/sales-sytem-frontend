/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sales.sytem.frontend.restclient;

import com.mycompany.sales.sytem.frontend.model.Customer;
import com.mycompany.sales.sytem.frontend.model.ProductCategory;
import com.mycompany.sales.sytem.frontend.model.Supplier;
import com.mycompany.sales.sytem.frontend.view.SupplierView;
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
public interface SupplierService {

    @GET("/supplier")
    Call<List<Supplier>> getAll();
    
    @POST("/supplier")
    Call<HttpStatus> save(@Body Supplier supplier);
    
    @PATCH("/supplier")
    Call<HttpStatus> update(@Body Supplier supplier);
    
    @DELETE("/supplier/{id}")
    Call<HttpStatus> delete(@Path("id") int id);

}
