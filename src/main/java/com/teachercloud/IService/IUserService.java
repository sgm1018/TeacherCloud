package com.teachercloud.IService;

import com.teachercloud.model.User;
import com.teachercloud.repository.utils.RItem;

public interface IUserService extends IEntidadService<User> {

    RItem<User> findByEmail(String email);

}
