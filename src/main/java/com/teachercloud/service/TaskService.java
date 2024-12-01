package com.teachercloud.service;

import com.teachercloud.IService.ITaskService;
import com.teachercloud.model.Task;
import com.teachercloud.repository.EntidadRepository;

public class TaskService extends EntidadService<Task> implements ITaskService {

    public TaskService(EntidadRepository<Task> taskRepository){
        super(taskRepository);
    }

}
