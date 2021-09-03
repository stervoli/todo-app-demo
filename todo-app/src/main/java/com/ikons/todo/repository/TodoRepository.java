package com.ikons.todo.repository;

import com.ikons.todo.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
    //kodi i shtuar vete me metoden findByid
    List<TodoEntity> findByid(Long id);
}
