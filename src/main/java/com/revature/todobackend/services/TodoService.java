package com.revature.todobackend.services;

import java.util.List;

import javax.transaction.Transactional;

import com.revature.todobackend.dao.TodoDao;
import com.revature.todobackend.models.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TodoService {
    
    @Autowired
    private TodoDao todoDao;

    public Todo createTodo(Todo todo){
        return this.todoDao.save(todo);
    }

    public List<Todo> getAll(){
        return this.todoDao.findAll();
    }

    public void deleteTodo(Integer todoId){
        this.todoDao.deleteById(todoId);
    }
}
