package com.Tasker.Tasker.service.dto;

import java.util.List;
import java.util.Objects;

public class TableDto {

    private Long id;
    private UsersDto user;
    private String name;
    private List<TaskDto> tasks;

    public TableDto() {
    }

    public TableDto(Long id, UsersDto user, String name, List<TaskDto> tasks) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.tasks = tasks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsersDto getUser() {
        return user;
    }

    public void setUser(UsersDto user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskDto> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDto> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableDto that = (TableDto) o;
        return Objects.equals(id, that.id) &&
               Objects.equals(user, that.user) &&
               Objects.equals(name, that.name) &&
               Objects.equals(tasks, that.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, name, tasks);
    }
}
