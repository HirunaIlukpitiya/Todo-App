package toDoApp.toDo.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import toDoApp.toDo.entity.TodoUser;
import toDoApp.toDo.repository.TodoUserRepository;

@Service
public class TodoUserService {

    private final PasswordEncoder passwordEncoder;
    private final TodoUserRepository userRepository;

    public TodoUserService(TodoUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public List<TodoUser> getUser() {
        return userRepository.findAll();
    }

    public void addUser(TodoUser todoUser) {
        TodoUser userExists = userRepository.findByEmail(todoUser.getEmail());

        if (userExists != null) {
            throw new IllegalStateException("Email already exists");
        } else if (todoUser.getFirstName().isEmpty() || todoUser.getLastName().isEmpty()
                || todoUser.getEmail().isEmpty() || todoUser.getPassword().isEmpty()) {
            throw new IllegalStateException("Please fill in all fields");
        }

        String encodedPassword = passwordEncoder.encode(todoUser.getPassword());
        todoUser.setPassword(encodedPassword);
        userRepository.save(todoUser);
    }

}
