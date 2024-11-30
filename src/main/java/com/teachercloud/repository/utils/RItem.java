package com.teachercloud.repository.utils;


import com.teachercloud.model.Entidad;

public record RItem<T extends Entidad>(int result, String msg, T value) {

    public RItem(T value) {
        this(0, "Ok", value);
    }
}