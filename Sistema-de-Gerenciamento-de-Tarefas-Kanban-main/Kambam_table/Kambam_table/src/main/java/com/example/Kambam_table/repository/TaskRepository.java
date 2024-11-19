package com.example.Kambam_table.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Kambam_table.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

}
