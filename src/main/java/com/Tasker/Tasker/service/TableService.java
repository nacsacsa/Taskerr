package com.Tasker.Tasker.service;

import com.Tasker.Tasker.service.dto.TableDto;

public interface TableService {
    TableDto findById(String id);
    TableDto findByUser_id(String id);
}