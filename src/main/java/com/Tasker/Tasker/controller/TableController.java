package com.Tasker.Tasker.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.Tasker.Tasker.service.TableService;
import com.Tasker.Tasker.service.UsersService;
import com.Tasker.Tasker.service.dto.TableDto;
import com.Tasker.Tasker.service.dto.UsersDto;

import org.springframework.security.core.Authentication;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TableController {

    @Autowired
    TableService tableService;

    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptions(){
        return ResponseEntity.ok().build();
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('FELHASZNALO')")
    public TableDto createTable(@RequestBody TableDto tableDto, Authentication authentication) {

        String email = authentication.getName();
        UsersDto user = usersService.findByEmail(email);

        if (user == null) {
            throw new RuntimeException("Felhasználó nem található.");
        }

        return tableService.save(tableDto, user);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('FELHASZNALO')")
    public void deleteTable(@RequestParam String id, Authentication authentication) {

        TableDto existing = tableService.findById(id);
        String email = authentication.getName();
        UsersDto user = usersService.findByEmail(email);

        if (!existing.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Más felhasználó tábláját nem lehet törölni!");
        }

        tableService.delete(id);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('FELHASZNALO')")
    public TableDto updateTable(@RequestBody TableDto tableDto, Authentication authentication) {

        if (tableDto.getId() == null) {
            throw new RuntimeException("A frissítéshez szükséges a tábla azonosítója.");
        }

        String email = authentication.getName();
        UsersDto user = usersService.findByEmail(email);

        TableDto existing = tableService.findById(tableDto.getId().toString());

        if (!existing.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Más felhasználó tábláját nem lehet módosítani!");
        }

        return tableService.save(tableDto, user);
    }


    @GetMapping("/get/user")
    @PreAuthorize("hasRole('FELHASZNALO')")
    public List<TableDto> findByUserId(@RequestParam Authentication authentication) {
    	String email = authentication.getName();
    	UsersDto user = usersService.findByEmail(email);
    	
        return tableService.findAllByUserId(user.getId().toString());
    }
}