package com.nncklient.neonnetcafe.service;

import com.nncklient.neonnetcafe.dao.UsersRepository;

import com.nncklient.neonnetcafe.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository theUsersRepository){
        usersRepository = theUsersRepository;
    }

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }
}
