package toDoApp.toDo.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(path = "api/v1/Todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getTodo() {
        return todoService.getTodo();
    }

    @PostMapping
    public void addNewTodo(@RequestBody Todo todo) {
        todoService.addTodo(todo);
    }

    @DeleteMapping(path = "{todoId}")
    public void deleteTodo(@PathVariable("todoId") Long todoId) {
        todoService.deleteTodo(todoId);
    }

    @PutMapping(path = "{todoId}")
    public void updateTodo(@PathVariable("todoId") Long todoId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description) {
                todoService.updateTodo(todoId,title,description);
    }

}
