/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sales.sytem.frontend.config;

import com.mycompany.sales.sytem.frontend.model.UserSystem;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 *
 * @author ro
 */
@Component
public class UserCache {

    private static final Map<String, String> userCache = new HashMap<>();

    public static void saveUser(UserSystem userSystem) {
        userCache.put("id", String.valueOf(userSystem.getId()));
        userCache.put("userName", userSystem.getUserName());
        userCache.put("type", userSystem.getTypeUser());
    }

    public static String getId() {
        return userCache.get("id");
    }

    public static String getUserName() {
        return userCache.get("userName");
    }

    public static String getTypeUser() {
        System.out.println("get token : " + userCache.get("token"));
        return userCache.get("type");
    }

}
