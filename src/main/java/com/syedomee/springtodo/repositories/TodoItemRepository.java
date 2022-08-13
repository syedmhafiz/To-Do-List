package com.syedomee.springtodo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.syedomee.springtodo.models.TodoItem;

public interface TodoItemRepository extends CrudRepository<TodoItem, Long> {
    
}
