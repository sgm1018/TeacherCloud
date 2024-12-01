
package com.teachercloud.repository;

import com.teachercloud.model.User;

public interface UserRepository extends EntidadRepository<User> {
    User findByEmail(String email);
}
