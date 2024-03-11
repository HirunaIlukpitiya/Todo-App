package toDoApp.toDo.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

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
    

}
