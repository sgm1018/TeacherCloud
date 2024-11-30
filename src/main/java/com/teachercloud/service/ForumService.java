package com.teachercloud.service;

import com.teachercloud.IService.IForumService;
import com.teachercloud.model.Forum;
import com.teachercloud.repository.ForumRepository;

public class ForumService extends EntidadService<Forum> implements IForumService {

    public ForumService(ForumRepository forumRepository){
        super(forumRepository);
    }

}
