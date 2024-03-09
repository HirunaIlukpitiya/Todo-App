package toDoApp.toDo.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
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
}
