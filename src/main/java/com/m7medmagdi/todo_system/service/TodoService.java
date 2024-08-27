package com.m7medmagdi.todo_system.service;


import com.m7medmagdi.todo_system.Repo.TodoRepository;
import com.m7medmagdi.todo_system.dto.TodoDto;
import com.m7medmagdi.todo_system.entity.Todo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ModelMapper modelMapper;


    /**
     * Adds a new TODO item.
     *
     * @param todoDto The DTO containing the details of the TODO item to be added.
     * @return The added TODO item as a DTO.
     */
    public TodoDto AddTodo(TodoDto todoDto){
        Todo todo = modelMapper.map(todoDto, Todo.class);
        todoRepository.save(todo);
        return modelMapper.map(todo, TodoDto.class);
    }
    /**
     * Retrieves a TODO item by its ID.
     *
     * @param id The ID of the TODO item to retrieve.
     * @return The TODO item as a DTO.
     * @throws RuntimeException if the TODO item is not found.
     */
    public TodoDto getTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TODO not found."));
        return modelMapper.map(todo, TodoDto.class);
    }

    /**
     * Retrieves all TODO items.
     *
     * @return A list of all TODO items as DTOs.
     */
    public List<TodoDto> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();

        return todos.stream().map((todo) -> modelMapper.map(todo, TodoDto.class))
                .collect(Collectors.toList());
    }


    /**
     * Updates an existing TODO item.
     *
     * @param id The ID of the TODO item to update.
     * @param todoDto The DTO containing the updated details of the TODO item.
     * @return The updated TODO item as a DTO.
     * @throws RuntimeException if the TODO item is not found.
     */
    public TodoDto updateTodo(Long id, TodoDto todoDto) {
        // Retrieve the existing Todo from the database
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TODO not found."));

        // Map the updated properties from TodoDto to the existing Todo
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setDone(todoDto.isDone());

        // Save the updated Todo back to the repository
        Todo updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDto.class);
    }
    public void deleteTodo(Long id) {
        // Check Todo
        if (!todoRepository.existsById(id)) {
            throw new RuntimeException("TODO not found.");
        }

        // Delete Todo
        todoRepository.deleteById(id);
    }

}
