package com.teachercloud.service;

import com.teachercloud.IService.IEventService;
import com.teachercloud.model.Event;
import com.teachercloud.repository.EntidadRepository;

public class EventService extends EntidadService<Event> implements IEventService {

    public EventService(EntidadRepository<Event> eventRepository){
        super(eventRepository);
    }

}