package com.teachercloud.service;

import com.teachercloud.IService.IEventService;
import com.teachercloud.model.Event;
import com.teachercloud.repository.EventRepository;

public class EventService extends EntidadService<Event> implements IEventService {

    public EventService(EventRepository eventRepository){
        super(eventRepository);
    }

}
