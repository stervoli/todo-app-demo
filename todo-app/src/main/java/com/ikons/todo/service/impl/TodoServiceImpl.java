package com.ikons.todo.service.impl;

import com.ikons.todo.entity.Status;//shtuar
import com.ikons.todo.entity.TodoEntity;
import com.ikons.todo.repository.TodoRepository;
import com.ikons.todo.service.TodoService;//KUJDES
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    //e kam shtuar vete
   // @Autowired
    //private TodoRepository todoRepository;

    final private TodoRepository repository;

    @Override
    public TodoEntity createTodo(final String title, final String descr) {
        final TodoEntity entity = TodoEntity.builder()
                .description(descr)
                .title(title)
                .createdDate(Instant.now())
                .status(Status.NOT_COMPLETED)
                .build();
        return repository.save(entity);
    }
    /*@Override
    public TodoEntity findOne(Long id) {
        return repository.findById(id);

    }

     */
    @Override
    public void changeStatus(TodoEntity entity, Status newStatus) {
        //kodi me poshte eshte shtuar vete
        final TodoEntity.TodoEntityBuilder ent = TodoEntity.builder()
        .status(Status.newStatus);
         repository.save(entity);
    }

    @Override
    public void updateDescription(String descr) {
           //kodi i shtuar vete
        final TodoEntity.TodoEntityBuilder ent = TodoEntity.builder()
                .description(descr);
    }

    @Override
    public void updateTitle(String title) {
        //kodi me poshte eshte shtuar vete
        final TodoEntity.TodoEntityBuilder ent = TodoEntity.builder()
                .title(title);

    }

    @Override
    public Optional<TodoEntity> getTodosById(Long id) {
        return repository.findById(id);
    }



}
