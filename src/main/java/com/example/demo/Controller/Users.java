package com.example.demo.Controller;

import com.example.demo.Entity.Apireponsi;
import com.example.demo.Entity.UsersgioiEntity;
import com.example.demo.Service.serviceUsers;

import com.example.demo.config.HttpResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/user")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Cho phép FE gọi API
public class Users {
    private final serviceUsers serviceUsers1;
    private final HttpResponseUtil httpResponseUtil;

    @GetMapping("/get")
    public ResponseEntity<Apireponsi<List<UsersgioiEntity>>> findAll() {
        try {
            List<UsersgioiEntity> list = serviceUsers1.findAll();
            return httpResponseUtil.okList("list", list);

        } catch (Exception e) {
            return httpResponseUtil.notFound("erorr");
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Apireponsi<String>> deleteById(@PathVariable Long id) {
        try {
            serviceUsers1.deleteUsersgioi(id);
            return httpResponseUtil.ok("Delete thành công user");
        } catch (Exception e) {
            return httpResponseUtil.notFound("erorr");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Apireponsi<UsersgioiEntity>> create(@RequestBody UsersgioiEntity data) {
        try {
            UsersgioiEntity usersgioiEntity = new UsersgioiEntity().builder().
                    username(data.getUsername()).
                    password(data.getPassword()).
                    email(data.getEmail()).
                    phone(data.getPhone()).
                    build();
            serviceUsers1.SaveUsersgioi(usersgioiEntity);
            return httpResponseUtil.created("Create Thanh Cong", usersgioiEntity);

        } catch (Exception e) {
            return httpResponseUtil.notFound("erorr");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Apireponsi<UsersgioiEntity>> update(@RequestBody UsersgioiEntity data, @PathVariable Long id) {
        try {
            UsersgioiEntity user = serviceUsers1.findUsersgioi(id);
            if (user == null) {
                return httpResponseUtil.notFound("User not found");
            }
            user.setUsername(data.getUsername());
            user.setEmail(data.getEmail());
            user.setPhone(data.getPhone());
            user.setPassword(data.getPassword());
            serviceUsers1.SaveUsersgioi(user);
            return httpResponseUtil.created("Update Thanh Cong", user);
        } catch (Exception e) {
            return httpResponseUtil.notFound("erorr");

        }
    }
}
