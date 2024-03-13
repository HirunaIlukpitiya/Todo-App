package toDoApp.toDo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import toDoApp.toDo.entity.TodoUser;
import toDoApp.toDo.repository.TodoUserRepository;

@Service
public class TodoUserService {

    private final TodoUserRepository todoUserRepository;

    public TodoUserService(TodoUserRepository todoUserRepository) {
        this.todoUserRepository = todoUserRepository;

    }

    public List<TodoUser> getUser() {
        return todoUserRepository.findAll();
    }

    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) {
                TodoUser todoUser = todoUserRepository.findByEmail(email);
                return new org.springframework.security.core.userdetails.User(
                        todoUser.getEmail(),
                        todoUser.getPassword(),
                        new ArrayList<>()
                );
            }
        };
    }

}
