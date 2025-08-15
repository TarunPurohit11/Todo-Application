package com.app.todo.services;

import com.app.todo.entity.Task;
import com.app.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;


    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void addTask(String title){
        Task task = new Task();
        task.setTitle(title);
        task.setStatus(false);
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void toggleTask(int id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if(optionalTask.isPresent()){
            Task task = optionalTask.get();
            task.setStatus(!task.isStatus());
            taskRepository.save(task);
        }
        else{
            new IllegalArgumentException("Invalid Task Id");
        }


    }
}
