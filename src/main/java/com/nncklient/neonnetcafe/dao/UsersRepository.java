package com.nncklient.neonnetcafe.dao;

import com.nncklient.neonnetcafe.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
