package toDoApp.toDo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import toDoApp.toDo.entity.TodoUser;
import toDoApp.toDo.service.TodoUserService;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping (path = "api/v1/User")
@RestController
public class TodoUserController {


    private final TodoUserService userService;

    public TodoUserController(TodoUserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<TodoUser> getUser() {
        return userService.getUser();
    }

    @PostMapping(path = "/signup")
    public void addTodoUser(@RequestBody TodoUser todoUser) {
        userService.addUser(todoUser);        
    }
    
    

}
