package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@Builder
@Table(name = "users_gioi")
@AllArgsConstructor
public class UsersgioiEntity {
    public UsersgioiEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
@NotBlank(message = "khong de trong ")
    private String username;
    @NotBlank(message = "khong de trong ")
    private String password;
    @NotBlank(message = "khong de trong ")
    private String email;
    @NotBlank(message = "khong de trong ")
    private String phone;
}
