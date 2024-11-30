package com.teachercloud.IService;

import com.teachercloud.model.Entidad;
import com.teachercloud.repository.utils.RItem;
import com.teachercloud.repository.utils.RList;

public interface IEntidadService<T extends Entidad> {

    RList<T> GetAll();

    RItem<T> GetById(Long id);

    RItem<T> add(T entity);

    RItem<T> remove(Long id);

    RItem<T> update(T entity);


}
