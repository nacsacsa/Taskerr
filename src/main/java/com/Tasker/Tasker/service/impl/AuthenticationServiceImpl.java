package com.Tasker.Tasker.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Tasker.Tasker.data.entity.roleEntity;
import com.Tasker.Tasker.data.entity.usersEntity;
import com.Tasker.Tasker.data.repository.roleRepository;
import com.Tasker.Tasker.data.repository.usersRepository;
import com.Tasker.Tasker.service.AuthenticationService;
import com.Tasker.Tasker.service.JwtService;
import com.Tasker.Tasker.service.dto.LoginDto;
import com.Tasker.Tasker.service.dto.RegistrationDto;

import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    usersRepository repo;
    @Autowired
    roleRepository jogRepo;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    AuthenticationManager manager;

    @Autowired
    JwtService jwtService;

    @Override
    public String registration(RegistrationDto dto) {
        usersEntity felhasznaloEntity = modelMapper.map(dto, usersEntity.class);
        felhasznaloEntity.setPassword(encoder.encode(felhasznaloEntity.getPassword()));
        roleEntity jog = jogRepo.findByName("FELHASZNALO");
        if (jog != null) {
            felhasznaloEntity.setRoles(Set.of(jog));
        } else {
            jog = new roleEntity(null, "FELHASZNALO");
            jog = jogRepo.save(jog);
            felhasznaloEntity.setRoles(Set.of(jog));
        }

        felhasznaloEntity = repo.save(felhasznaloEntity);

        return jwtService.generateToken(felhasznaloEntity);

    }

    @Override
    public String login(LoginDto dto) {
        manager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getEmail(),dto.getPassword())
        );
        var user = repo.findByEmail(dto.getEmail());
        return jwtService.generateToken(user);
    }
}