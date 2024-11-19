package com.example.Kambam_table.controller;

import com.example.Kambam_table.model.Task;
import com.example.Kambam_table.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.listAll();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @PutMapping("/tasks/{id}/move")
    public Task moveTask(@PathVariable int id) {
        return taskService.moveTask(id);
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping
    public void deleteTask(@PathVariable int id) {
        taskService.deleteById(id);
    }





}
