package com.teachercloud.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teachercloud.model.Entidad;


@Primary
public interface EntidadRepository<T extends Entidad> extends JpaRepository<T, Long> {
    
}

