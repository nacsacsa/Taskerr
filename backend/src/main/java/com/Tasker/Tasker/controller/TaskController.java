package com.Tasker.Tasker.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.Tasker.Tasker.service.TableService;
import com.Tasker.Tasker.service.TaskService;
import com.Tasker.Tasker.service.UsersService;
import com.Tasker.Tasker.service.dto.TableDto;
import com.Tasker.Tasker.service.dto.TaskDto;
import com.Tasker.Tasker.service.dto.UsersDto;

import org.springframework.security.core.Authentication;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    TableService tableService;
    
    @Autowired
    TaskService taskService;

    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptions(){
        return ResponseEntity.ok().build();
    }

    @PostMapping("/task/create")
    @PreAuthorize("hasRole('USER')")
    public TaskDto createTask(@RequestBody TaskDto taskDto, Authentication authentication) {
    	String email = authentication.getName();
        UsersDto user = usersService.findByEmail(email);

        if (taskDto.getTable() == null || taskDto.getTable().getId() == null) {
            throw new RuntimeException("Table is required!");
        }

        TableDto table = tableService.findById(taskDto.getTable().getId().toString());

        if (!table.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Cannot edit others table!");
        }

        return taskService.save(taskDto, table);
    }

    @DeleteMapping("/task/delete")
    @PreAuthorize("hasRole('USER')")
    public void deleteTask(@RequestParam String id, Authentication authentication) {

        TaskDto existing = taskService.findById(id);
        String email = authentication.getName();
        UsersDto user = usersService.findByEmail(email);

        if (!existing.getTable().getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Cannot delete others task!");
        }

        taskService.delete(id);
    }

    @PutMapping("/task/update")
    @PreAuthorize("hasRole('USER')")
    public TaskDto updateTask(@RequestBody TaskDto taskDto, Authentication authentication, String tableId) {

        if (taskDto.getId() == null) {
            throw new RuntimeException("Task Id needed!");
        }

        String email = authentication.getName();
        UsersDto user = usersService.findByEmail(email);
        TableDto table = tableService.findById(tableId);

        TaskDto existing = taskService.findById(taskDto.getId().toString());

        if (!existing.getTable().getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Cannot modify others task!");
        }

        return taskService.save(taskDto, table);
    }


    @GetMapping("/task/table")
    @PreAuthorize("hasRole('USER')")
    public List<TaskDto> findByTableId(@RequestParam String Id, Authentication authentication) {
    	String email = authentication.getName();
    	UsersDto user = usersService.findByEmail(email);
    	TableDto table = tableService.findById(Id);
    	if (!table.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Cannot delete others task!");
        }
        return taskService.findAllByTableId(Id);
    }
}