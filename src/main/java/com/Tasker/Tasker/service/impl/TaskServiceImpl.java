package com.Tasker.Tasker.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tasker.Tasker.data.entity.taskEntity;
import com.Tasker.Tasker.data.repository.taskRepository;
import com.Tasker.Tasker.service.TaskService;
import com.Tasker.Tasker.service.dto.TaskDto;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    taskRepository repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public TaskDto findById(String id) {
    	taskEntity entity = repo.findById(id);
        return mapper.map(entity, TaskDto.class);
    }

	@Override
	public TaskDto findByTable_id(String id) {
		taskEntity entity = repo.findByTable_id(id);
        return mapper.map(entity, TaskDto.class);
	}

	@Override
	public TaskDto findBytask_done() {
		taskEntity entity = repo.findBytask_done(true);
        return mapper.map(entity, TaskDto.class);
	}
}