package com.teachercloud.service;

import org.springframework.stereotype.Service;

import com.teachercloud.IService.IUserService;
import com.teachercloud.model.User;
import com.teachercloud.repository.EntidadRepository;
import com.teachercloud.repository.UserRepository;
import com.teachercloud.repository.utils.RItem;

@Service
public class UserService extends EntidadService<User> implements IUserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        super(userRepository);
        this.userRepository = userRepository;
    }



    public RItem<User> findByEmail(String email) {
        var datos = userRepository.findByEmail(email);
        if (datos == null) {
            return new RItem<User>(-1, "No se encontró el usuario con el email: " + email, null);
        }
        return new RItem<User>(0, "Usuario encontrado", datos);
    }

}
