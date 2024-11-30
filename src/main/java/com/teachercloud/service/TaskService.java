package com.teachercloud.service;

import com.teachercloud.IService.ITaskService;
import com.teachercloud.model.Task;
import com.teachercloud.repository.TaskRepository;

public class TaskService extends EntidadService<Task> implements ITaskService {

    public TaskService(TaskRepository taskRepository){
        super(taskRepository);
    }

}
