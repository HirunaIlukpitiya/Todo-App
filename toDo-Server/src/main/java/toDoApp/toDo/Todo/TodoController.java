package toDoApp.toDo.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * The TodoController class handles HTTP requests related to Todo operations.
 */
@RestController
@RequestMapping(path = "api/v1/Todo")
public class TodoController {

    private final TodoService todoService;

    /**
     * Constructs a new TodoController with the specified TodoService.
     * 
     * @param todoService the TodoService to be used
     */
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    /**
     * Retrieves a list of all Todo items.
     * 
     * @return a list of Todo items
     */
    @GetMapping
    public List<Todo> getTodo() {
        return todoService.getTodo();
    }

    /**
     * Adds a new Todo item.
     * 
     * @param todo the Todo item to be added
     */
    @PostMapping
    public void addNewTodo(@RequestBody Todo todo) {
        todoService.addTodo(todo);
    }

    /**
     * Deletes a Todo item with the specified ID.
     * 
     * @param todoId the ID of the Todo item to be deleted
     */
    @DeleteMapping(path = "{todoId}")
    public void deleteTodo(@PathVariable("todoId") Long todoId) {
        todoService.deleteTodo(todoId);
    }

    /**
     * Updates a Todo item with the specified ID.
     * 
     * @param todoId      the ID of the Todo item to be updated
     * @param title       the new title of the Todo item (optional)
     * @param description the new description of the Todo item (optional)
     */
    @PutMapping(path = "{todoId}")
    public void updateTodo(@PathVariable("todoId") Long todoId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description) {
        todoService.updateTodo(todoId, title, description);
    }

}
