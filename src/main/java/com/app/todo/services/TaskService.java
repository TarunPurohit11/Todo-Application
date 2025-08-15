package com.app.todo.services;

import com.app.todo.entity.Task;

import java.util.List;

public interface TaskService {

    public List<Task> getAllTasks();
    public void addTask(String task);
    public void deleteTask(int id);
    public void toggleTask(int id);

}
