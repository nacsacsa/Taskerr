package com.Tasker.Tasker.data.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "task")
public class taskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private tableEntity table;

    @Column(name = "task_name", nullable = false)
    private String taskName;

    @Column(name = "task_done")
    private Boolean taskDone;

    @Column(name = "task_description")
    private String taskDescription;

    public taskEntity() {
    }

    public taskEntity(Long id, tableEntity table, String taskName, Boolean taskDone, String taskDescription) {
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

    public tableEntity getTable() {
        return table;
    }

    public void setTable(tableEntity table) {
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
        taskEntity that = (taskEntity) o;
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
