package com.Tasker.Tasker.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "table")
public class tableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private usersEntity user;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "table")
    private List<taskEntity> tasks;

    public tableEntity() {}

    public tableEntity(Long id, usersEntity user, String name, List<taskEntity> tasks) {
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

    public usersEntity getUser() {
        return user;
    }

    public void setUser(usersEntity user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<taskEntity> getTask() {
        return tasks;
    }

    public void setTask(List<taskEntity> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        tableEntity that = (tableEntity) o;
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
