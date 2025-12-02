package com.Tasker.Tasker.service;

import com.Tasker.Tasker.service.dto.UsersDto;

public interface UsersService {
    UsersDto findByEmail(String email);
}