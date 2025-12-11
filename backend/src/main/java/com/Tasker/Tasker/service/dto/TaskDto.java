package com.Tasker.Tasker.service.dto;

import java.util.Objects;

public class TaskDto {

    private Long id;
    private TableDto table;
    private String taskName;
    private Boolean taskDone;
    private String taskDescription;

    public TaskDto() {
    }

    public TaskDto(Long id, TableDto table, String taskName, Boolean taskDone, String taskDescription) {
        this.id = id;
        this.table = table;
        this.taskName = taskName;
        this.taskDone = taskDone;
        this.taskDescription = taskDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TableDto getTable() {
        return table;
    }

    public void setTable(TableDto table) {
        this.table = table;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Boolean getTaskDone() {
        return taskDone;
    }

    public void setTaskDone(Boolean taskDone) {
        this.taskDone = taskDone;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDto that = (TaskDto) o;
        return Objects.equals(id, that.id) &&
               Objects.equals(table, that.table) &&
               Objects.equals(taskName, that.taskName) &&
               Objects.equals(taskDone, that.taskDone) &&
               Objects.equals(taskDescription, that.taskDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, table, taskName, taskDone, taskDescription);
    }
}