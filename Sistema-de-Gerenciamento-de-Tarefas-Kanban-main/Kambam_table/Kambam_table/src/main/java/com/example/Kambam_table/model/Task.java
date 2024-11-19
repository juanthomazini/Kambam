package com.example.Kambam_table.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column(nullable = false)
    private LocalDate creationDate;

    @Column
    private LocalDate deadline;

    @Enumerated(EnumType.STRING)
    @Column
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    @Column
    private TaskPriority priority;

    public Task() {
        this.creationDate = LocalDate.now();
        this.status = TaskStatus.TODO;
    }

    public Task(String title, String description, LocalDate deadline, TaskPriority priority) {
        this();
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }
}
