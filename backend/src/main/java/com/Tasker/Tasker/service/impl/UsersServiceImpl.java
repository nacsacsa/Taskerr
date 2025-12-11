package com.Tasker.Tasker.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tasker.Tasker.data.entity.usersEntity;
import com.Tasker.Tasker.data.repository.usersRepository;
import com.Tasker.Tasker.service.UsersService;
import com.Tasker.Tasker.service.dto.UsersDto;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    usersRepository repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public UsersDto findByEmail(String email) {
        usersEntity entity = repo.findByEmail(email);
        return mapper.map(entity, UsersDto.class);
    }
}