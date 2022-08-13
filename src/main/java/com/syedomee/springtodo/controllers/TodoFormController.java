package com.syedomee.springtodo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.syedomee.springtodo.models.TodoItem;
import com.syedomee.springtodo.repositories.TodoItemRepository;

@Controller
public class TodoFormController {
    @Autowired
    private TodoItemRepository todoItemRepository;

    @GetMapping("/create-todo")
    public String showCreateForm(TodoItem todoItem) {
        return "add-todo-item";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        TodoItem todoItem = todoItemRepository.findById(id).
        orElseThrow(() -> new IllegalArgumentException("TodoItem: " + id + " not found"));
        
        model.addAttribute("todo", todoItem);
        return "update-todo-item";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id, Model model) {
        TodoItem todoItem = todoItemRepository.findById(id).
        orElseThrow(() -> new IllegalArgumentException("TodoItem: " + id + " not found"));
        
        todoItemRepository.delete(todoItem);
        return "redirect:/";
    }
}
