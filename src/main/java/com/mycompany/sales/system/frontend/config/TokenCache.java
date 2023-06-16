/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sales.system.frontend.config;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 *
 * @author ro
 */

@Component
public class TokenCache {
    
    private static final Map<String, String> tokenCache = new HashMap<>();
    
    public static void saveToken(String token) {
        System.out.println("save token : " + token);
        tokenCache.put("token", token);
    }
    
   public static String getToken() {
        System.out.println("get token : " + tokenCache.get("token"));
        return tokenCache.get("token");
    }
}
