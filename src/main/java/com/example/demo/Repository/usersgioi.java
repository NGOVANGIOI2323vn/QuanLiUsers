package com.example.demo.Repository;


import com.example.demo.Entity.UsersgioiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usersgioi extends JpaRepository<UsersgioiEntity, Long> {
}
