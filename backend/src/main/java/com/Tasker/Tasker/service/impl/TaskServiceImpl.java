package com.Tasker.Tasker.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tasker.Tasker.data.entity.tableEntity;
import com.Tasker.Tasker.data.entity.taskEntity;
import com.Tasker.Tasker.data.repository.tableRepository;
import com.Tasker.Tasker.data.repository.taskRepository;
import com.Tasker.Tasker.service.TaskService;
import com.Tasker.Tasker.service.dto.TableDto;
import com.Tasker.Tasker.service.dto.TaskDto;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    taskRepository repo;
    
    @Autowired
    tableRepository Tablerepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public TaskDto findById(String id) {
    	taskEntity entity = repo.findById(id);
        return mapper.map(entity, TaskDto.class);
    }

	@Override
	public List<TaskDto> findAllByTableId(String id) {
		List<taskEntity> entity = repo.findAllByTable_id(id);
		return mapper.map(entity, new TypeToken<List<TaskDto>>(){}.getType());
	}

	@Override
	public List<TaskDto> findAllBytaskDone() {
		List<taskEntity> entity = repo.findAllBytask_done(true);
		return mapper.map(entity, new TypeToken<List<TaskDto>>(){}.getType());
	}

	@Override
	public void delete(String id) {
		taskEntity entity = repo.findById(id);
		entity.setTable(null);
		repo.deleteById(entity.getId());
		
	}

	@Override
	public TaskDto save(TaskDto dto, TableDto table) {
		taskEntity task = mapper.map(dto, taskEntity.class);
		tableEntity tabl = Tablerepo.findById(table.getId().toString());
		task.setTable(tabl);
		task = repo.save(task);
        return mapper.map(task, TaskDto.class);
	}
}