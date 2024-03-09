package toDoApp.toDo.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Todo")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getTodo(){
        return todoService.getTodo();
    }

    @PostMapping
    public void addNewTodo(@RequestBody Todo todo){
        todoService.addTodo(todo);
    }

    @DeleteMapping(path = "{todoId}")
    public void deleteTodo(@PathVariable ("todoId") Long todoId){
        todoService.deleteTodo(todoId);
    }


}
