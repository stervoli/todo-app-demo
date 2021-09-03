package com.ikons.todo.service;

import com.ikons.todo.entity.Status;
import com.ikons.todo.entity.TodoEntity;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    TodoEntity createTodo(final String title, final String descr);
    void changeStatus(final TodoEntity entity, final Status newStatus);
    void updateDescription(final String descr);
    void updateTitle(final String title);
    //shtuar vete
    Optional<TodoEntity> getTodosById(Long id);
}
