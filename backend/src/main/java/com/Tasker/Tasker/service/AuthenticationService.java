package com.Tasker.Tasker.service;

import com.Tasker.Tasker.service.dto.LoginDto;
import com.Tasker.Tasker.service.dto.RegistrationDto;

public interface AuthenticationService {
    String registration(RegistrationDto dto);

    String login(LoginDto dto);
}