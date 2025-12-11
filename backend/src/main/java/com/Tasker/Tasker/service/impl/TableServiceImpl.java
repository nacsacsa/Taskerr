package com.Tasker.Tasker.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tasker.Tasker.data.entity.tableEntity;
import com.Tasker.Tasker.data.entity.usersEntity;
import com.Tasker.Tasker.data.repository.tableRepository;
import com.Tasker.Tasker.data.repository.usersRepository;
import com.Tasker.Tasker.service.TableService;
import com.Tasker.Tasker.service.dto.TableDto;
import com.Tasker.Tasker.service.dto.UsersDto;

@Service
public class TableServiceImpl implements TableService {

    @Autowired
    tableRepository repo;
    
    @Autowired
    usersRepository userRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public TableDto findById(String id) {
    	tableEntity entity = repo.findById(id);
        return mapper.map(entity, TableDto.class);
    }

	@Override
	public List<TableDto> findAllByUserId(String id) {
		List<tableEntity> entity = repo.findAllByUser_id(id);
        return mapper.map(entity, new TypeToken<List<TableDto>>(){}.getType());
	}

	@Override
	public void delete(String id) {
		tableEntity entity = repo.findById(id);
		entity.setUser(null);
		repo.deleteById(entity.getId());
		
	}

	@Override
	public TableDto save(TableDto dto, UsersDto user) {
		tableEntity table = mapper.map(dto, tableEntity.class);
        usersEntity users = userRepo.findByEmail(user.getEmail());
        table.setUser(users);
        table = repo.save(table);
        return mapper.map(table, TableDto.class);
	}

}