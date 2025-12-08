package com.Tasker.Tasker.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tasker.Tasker.data.entity.tableEntity;
import com.Tasker.Tasker.data.repository.tableRepository;
import com.Tasker.Tasker.service.TableService;
import com.Tasker.Tasker.service.dto.TableDto;

@Service
public class TableServiceImpl implements TableService {

    @Autowired
    tableRepository repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public TableDto findById(String id) {
    	tableEntity entity = repo.findById(id);
        return mapper.map(entity, TableDto.class);
    }
}