package com.Tasker.Tasker.service;

import com.Tasker.Tasker.service.dto.TaskDto;

public interface TaskService {
    TaskDto findById(String email);
}