package com.example.demo.Service;


import com.example.demo.Entity.UsersgioiEntity;
import com.example.demo.Repository.usersgioi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class serviceUsers {
    private final usersgioi us;

    public List<UsersgioiEntity> findAll() {
        return us.findAll();
    }

    public void deleteUsersgioi(Long id) {
        us.deleteById(id);
    }

    public void SaveUsersgioi(UsersgioiEntity usersgioiEntity) {
        us.save(usersgioiEntity);
    }

    public UsersgioiEntity findUsersgioi(Long id) {
        return us.findById(id).orElse(null);
    }
}
