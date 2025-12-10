package com.Tasker.Tasker.service;

import java.util.List;

import com.Tasker.Tasker.service.dto.TableDto;
import com.Tasker.Tasker.service.dto.UsersDto;

public interface TableService {
    TableDto findById(String id);
    List<TableDto> findAllByUserId(String id);
    void delete(String id);
    TableDto save(TableDto dto, UsersDto user);
}