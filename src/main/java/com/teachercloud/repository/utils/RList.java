package com.teachercloud.repository.utils;

import java.util.List;

import com.teachercloud.model.Entidad;

public record RList<T extends Entidad>(int result, String msg, List<T> value) {

    public RList(List<T> lista) {
        this(0, "Ok", lista);
    }
}
