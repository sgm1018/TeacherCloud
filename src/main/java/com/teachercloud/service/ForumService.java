package com.teachercloud.service;

import org.springframework.stereotype.Service;

import com.teachercloud.IService.IForumService;
import com.teachercloud.model.Forum;
import com.teachercloud.repository.EntidadRepository;

@Service
public class ForumService extends EntidadService<Forum> implements IForumService {

    public ForumService(EntidadRepository<Forum> forumRepository){
        super(forumRepository);
    }

}
