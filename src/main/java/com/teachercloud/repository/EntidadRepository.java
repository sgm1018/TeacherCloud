package com.teachercloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teachercloud.model.Entidad;

public interface EntidadRepository<T extends Entidad> extends JpaRepository<T, Long> {
}

