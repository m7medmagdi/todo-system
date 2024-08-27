package com.m7medmagdi.todo_system.controller;


import com.m7medmagdi.todo_system.dto.TodoDto;
import com.m7medmagdi.todo_system.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class ToDOController {
    private TodoService todoService;

    /**
     * Creates a new TODO item.
     *
     * @param todoDto The DTO containing the details of the TODO item to be created.
     * @return A ResponseEntity containing the created TODO item and a CREATED status.
     */
    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto) {
        TodoDto savedTodo = todoService.AddTodo(todoDto);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    /**
     * Retrieves all TODO items.
     *
     * @return A ResponseEntity containing a list of all TODO items and an OK status.
     */
    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos() {
        return ResponseEntity.ok(todoService.getAllTodos());
    }

    /**
     * Retrieves a TODO item by its ID.
     *
     * @param todoId The ID of the TODO item to retrieve.
     * @return A ResponseEntity containing the requested TODO item and an OK status.
     * @throws RuntimeException if the TODO item is not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long todoId) {
        return new ResponseEntity<>(todoService.getTodo(todoId), HttpStatus.OK);
    }

    /**
     * Updates an existing TODO item.
     *
     * @param id The ID of the TODO item to update.
     * @param todoDto The DTO containing the updated details of the TODO item.
     * @return A ResponseEntity containing the updated TODO item and an OK status.
     * @throws RuntimeException if the TODO item is not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<TodoDto> updateTodo(
            @PathVariable("id") Long id,
            @RequestBody TodoDto todoDto) {
        TodoDto updatedTodo = todoService.updateTodo(id, todoDto);
        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

    /**
     * Deletes a TODO item by its ID.
     *
     * @param id The ID of the TODO item to delete.
     * @return A ResponseEntity with a NO CONTENT status.
     * @throws RuntimeException if the TODO item is not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteTodo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
