package com.revature.todobackend.controllers;

import java.util.List;

import com.revature.todobackend.models.JsonResponse;
import com.revature.todobackend.models.Todo;
import com.revature.todobackend.services.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public JsonResponse getAll(){
        return new JsonResponse(true, "retrieving all todos", this.todoService.getAll());

    }

    @PostMapping
    public JsonResponse createOne(@RequestBody Todo todo){
        return new JsonResponse(true, "created todo", this.todoService.createTodo(todo));
    }

    @DeleteMapping("{todoId}")
    public JsonResponse deleteOne(@PathVariable Integer todoId){
        this.todoService.deleteTodo(todoId);
        return new JsonResponse(true, "delete todo with id " + todoId + " if it existed", null);
    }
}
