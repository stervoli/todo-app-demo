package com.ikons.todo.web.rest;

import com.ikons.todo.entity.TodoEntity;
import com.ikons.todo.service.TodoService;
import com.ikons.todo.web.vm.TodoVM;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController("api/todo")
public class TodoResource {

    private final TodoService todoService;

    public TodoResource(TodoService todoService) {
        this.todoService = todoService;
    }
    @PostMapping(path = "/create")
    public ResponseEntity<TodoEntity> createTodo(@RequestBody TodoVM todoVM) {
        TodoEntity entity = this.todoService.createTodo(todoVM.getTitle(), todoVM.getDescr());
        return ResponseEntity.ok(entity);
    }
    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap model) {

        model.put("todos", todoService.getTodosById(0L));
        // model.put("todos", service.retrieveTodos(name));
        return "list-todos";
    }

}
