package com.nando.demo_park_api.web.dto;

import lombok.*;

 @NoArgsConstructor @AllArgsConstructor @ToString
public class UsuarioCreateDTO {

    private String username;
    private String password;

     public String getUsername() {
         return username;
     }

     public void setUsername(String username) {
         this.username = username;
     }

     public String getPassword() {
         return password;
     }

     public void setPassword(String password) {
         this.password = password;
     }
 }
