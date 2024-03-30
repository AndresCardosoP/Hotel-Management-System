package com.webdevuoit3230.FinalProject.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.webdevuoit3230.FinalProject.model.Task;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    // Display the task submission form
    @GetMapping
    public String displayTaskForm() {
        return "taskForm";
    }

    // Process the task submission form
    @PostMapping
    public String handleTaskSubmission(@RequestParam String taskName, HttpSession session) {
        Task newTask = new Task();
        newTask.setName(taskName);

        // Retrieve or create the list of tasks from the session
        List<Task> taskList = (List<Task>) session.getAttribute("taskList");
        if (taskList == null) {
            taskList = new ArrayList<>();
        }
        taskList.add(newTask);
        session.setAttribute("taskList", taskList);

        return "redirect:/tasks/success"; // Redirect to the success page
    }

    // Display the success page after a task is submitted
    @GetMapping("/success")
    public String displaySuccessPage(HttpSession session) {
        List<Task> taskList = (List<Task>) session.getAttribute("taskList");
        if (taskList == null || taskList.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            for (Task task : taskList) {
                System.out.println("Task: " + task.getName());
            }
        }
        return "taskSuccess"; 
    }
}