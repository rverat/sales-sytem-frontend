/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sales.system.frontend.restclient;

import com.mycompany.sales.system.frontend.model.Supplier;
import com.mycompany.sales.system.frontend.model.UserSystem;
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
public interface UserService {
    
    @GET("/v1/user")
    Call<List<UserSystem>> findAll(@Header("Authorization") String token);
    
    @POST("/v1/user/login")
    Call<UserSystem> login(@Body UserSystem userSystem);
    
    @POST("/v1/user/logout")
    Call<HttpStatus> logout(@Header("Authorization") String token);
    
    @POST("/v1/user")
    Call<HttpStatus> save(@Header("Authorization") String token, @Body UserSystem userSystem);
    
    @PATCH("/v1/user")
    Call<HttpStatus> update(@Header("Authorization") String token, @Body UserSystem userSystem);
    
    @DELETE("/v1/user/{id}")
    Call<HttpStatus> delete(@Header("Authorization") String token, @Path("id") int id);


}
