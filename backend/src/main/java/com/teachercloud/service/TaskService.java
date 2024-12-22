package com.teachercloud.service;

import org.springframework.stereotype.Service;

import com.teachercloud.IService.ITaskService;
import com.teachercloud.model.Task;
import com.teachercloud.repository.EntidadRepository;

@Service
public class TaskService extends EntidadService<Task> implements ITaskService {

    public TaskService(EntidadRepository<Task> taskRepository){
        super(taskRepository);
    }

}
