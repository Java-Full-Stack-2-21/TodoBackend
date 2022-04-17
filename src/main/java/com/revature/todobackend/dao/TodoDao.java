package com.revature.todobackend.dao;

import com.revature.todobackend.models.Todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoDao extends JpaRepository<Todo, Integer> {
}
