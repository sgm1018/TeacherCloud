package com.teachercloud.service;

import org.springframework.stereotype.Service;

import com.teachercloud.IService.IUserService;
import com.teachercloud.model.User;
import com.teachercloud.repository.EntidadRepository;

@Service
public class UserService extends EntidadService<User> implements IUserService {

    public UserService(EntidadRepository<User> userRepository){
        super(userRepository);
    }

}
