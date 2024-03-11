package toDoApp.toDo.User;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class TodoUserService {

    private final TodoUserRepository userRepository;

    public TodoUserService(TodoUserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<TodoUser> getUser() {
        return userRepository.findAll();
    }



}
