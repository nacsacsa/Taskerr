package com.Tasker.Tasker.service;

import java.util.List;

import com.Tasker.Tasker.service.dto.TableDto;
import com.Tasker.Tasker.service.dto.TaskDto;

public interface TaskService {
    TaskDto findById(String id);
    List<TaskDto> findAllByTableId(String id);
    List<TaskDto> findAllBytaskDone();
    void delete(String id);
    TaskDto save(TaskDto dto, TableDto user);
}