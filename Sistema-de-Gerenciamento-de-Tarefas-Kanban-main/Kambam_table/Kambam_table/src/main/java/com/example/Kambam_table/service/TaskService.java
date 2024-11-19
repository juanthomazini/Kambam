package com.example.Kambam_table.service;


import com.example.Kambam_table.model.Task;
import com.example.Kambam_table.model.TaskStatus;
import com.example.Kambam_table.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> listAll(){
        return taskRepository.findAll(Sort.by(Sort.Direction.ASC, "status"));
    }

    public Task moveTask(int taskId){
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        TaskStatus status = task.getStatus();
        int nextOrdinal = status.ordinal() + 1;

        if (nextOrdinal < TaskStatus.values().length){
            TaskStatus nextStatus = TaskStatus.values()[nextOrdinal];
            task.setStatus(nextStatus);
        }
        else {
            throw new RuntimeException("A tarefa já está concluída e não pode ser movida para outro status");
        }

        return taskRepository.save(task);
    }


    public Task updateTask(int taskId, Task task){
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if (optionalTask.isPresent()){
            Task updatedTask = optionalTask.get();
            updatedTask.setTitle(task.getTitle());
            updatedTask.setDescription(task.getDescription());
            updatedTask.setPriority(task.getPriority());
        }
        return taskRepository.save(task);
    }

    public Task saveTask(Task task){
        return taskRepository.save(task);
    }

    public void deleteById(int id){
        taskRepository.deleteById(id);
    }


}
