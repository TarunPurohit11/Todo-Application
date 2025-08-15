package com.app.todo.controllers;

import com.app.todo.entity.Task;
import com.app.todo.services.TaskServiceImpl;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskServiceImpl taskService;

    @GetMapping
    public String getAllTask(Model model){
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "index";
    }

    @PostMapping
    public String createTask(@RequestParam String title){
        taskService.addTask(title);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable int id){
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable int id){
        taskService.toggleTask(id);
        return "redirect:/";
    }
}
