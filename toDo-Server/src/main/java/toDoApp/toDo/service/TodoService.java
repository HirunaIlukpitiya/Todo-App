package toDoApp.toDo.service;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import toDoApp.toDo.entity.Todo;
import toDoApp.toDo.repository.TodoRepository;

import java.util.List;
import java.util.Objects;

/**
 * This class represents the service layer for managing Todo objects.
 * It provides methods for retrieving, adding, updating, and deleting Todo items.
 */
@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodo(){
        return todoRepository.findAll();
    }

    public void addTodo(Todo todo) {
        todoRepository.save(todo);
    }

    public void deleteTodo(Long todoId) {
        boolean exists = todoRepository.existsById(todoId);
        if(!exists){
            throw new IllegalStateException(
                    "Item with Id: "+ todoId +" does not exists"
            );
        }
        todoRepository.deleteById(todoId);
    }

    @Transactional
    public void updateTodo(Long todoId, String title, String description) {
        
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new IllegalStateException(
            "Item with Id: "+ todoId +" does not exists"
        ));

        if(title != null && title.length()>0 &&
        !Objects.equals(todo.getTitle(), title)){
            todo.setTitle(title);
        }

        if(description != null && description.length()>0 &&
        !Objects.equals(todo.getDescription(), description)){
            todo.setDescription(description);
        }
    }

    public List<Todo> getTodosByCategory(String category) {
        return todoRepository.findByCategory(category);
    }

    public void DeleteAll() {
        if (todoRepository.count() != 0){
        todoRepository.deleteAll();
        System.out.println("All of the data in the database was deleted");
        }else{
            throw new IllegalStateException("Database is Already Empty");
        }
    }
}
