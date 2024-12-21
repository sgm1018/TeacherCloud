package com.teachercloud.service;

import com.teachercloud.IService.IEntidadService;
import com.teachercloud.model.Entidad;
import com.teachercloud.repository.EntidadRepository;
import com.teachercloud.repository.utils.RItem;
import com.teachercloud.repository.utils.RList;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;



@Service
public class EntidadService<T extends Entidad> implements IEntidadService<T> {

    protected final JpaRepository<T, Long> repository;
    
    public EntidadService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    @Override
    public RList<T> GetAll() {
        List<T> data = repository.findAll();
        if (data.isEmpty()) {
            return new RList<T>(1, "Empty Data", data);
        } else {
            return new RList<T>(0, "Ok", data);
        }
    }

    @Override
    public RItem<T> GetById(Long id) {
        T data = repository.findById(id).orElse(null);
        if (data == null) {
            return new RItem<T>(1, "Empty Data", data);
        } else {
            return new RItem<T>(0, "Ok", data);
        }
    }

    @Override
    public RItem<T> add(T entity) {
        if (entity.getId() != null && repository.existsById(entity.getId())) {
            return new RItem<T>(1, "Entity already exists", null);  
        }else{
            T data = repository.save(entity);
            return new RItem<T>(0, "Ok", data);
        }
    }

    @Override
    public RItem<T> remove(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return new RItem<T>(0, "Ok", null);
        } else {
            return new RItem<T>(1, "Entity not found", null);
        }
    }

    @Override
    public RItem<T> update(T entity) {
        if (repository.existsById(entity.getId())) {
            T data = repository.save(entity);
            return new RItem<T>(0, "Ok", data);
        } else {
            return new RItem<T>(1, "Entity not found", null);
        }
    }



}