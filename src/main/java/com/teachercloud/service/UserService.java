package com.teachercloud.service;

import com.teachercloud.IService.IUserService;
import com.teachercloud.model.User;
import com.teachercloud.repository.EntidadRepository;

public class UserService extends EntidadService<User> implements IUserService {

    public UserService(EntidadRepository<User> userRepository){
        super(userRepository);
    }

}
