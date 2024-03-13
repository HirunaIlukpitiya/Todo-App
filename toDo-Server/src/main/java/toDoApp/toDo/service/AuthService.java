package toDoApp.toDo.service;

import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import toDoApp.toDo.Model.request.SigninRequest;
import toDoApp.toDo.Model.request.SignupRequest;
import toDoApp.toDo.Model.response.JwtAuthenticationResponse;
import toDoApp.toDo.entity.TodoUser;
import toDoApp.toDo.repository.TodoUserRepository;

@Service
public class AuthService {

    private final TodoUserRepository todoUserRepository;
    private final PasswordEncoder PasswordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(TodoUserRepository todoUserRepository,
            PasswordEncoder PasswordEncoder, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.todoUserRepository = todoUserRepository;
        this.authenticationManager = authenticationManager;
        this.PasswordEncoder = PasswordEncoder;
        this.jwtService = jwtService;
    }

    public JwtAuthenticationResponse signup(SignupRequest request) {
        TodoUser userExists = (TodoUser) todoUserRepository.findByEmail(request.getEmail());

        if (userExists != null) {
            throw new IllegalStateException("Email already exists");
        } else if (request.getFirstName().isEmpty() || request.getLastName().isEmpty()
                || request.getEmail().isEmpty() || request.getPassword().isEmpty()) {
            throw new IllegalStateException("Please fill in all fields");
        }
        String encodedPassword = PasswordEncoder.encode(request.getPassword());

        TodoUser newUser = new TodoUser();
        newUser.setFirstName(request.getFirstName());
        newUser.setLastName(request.getLastName());
        newUser.setEmail(request.getEmail());
        newUser.setPassword(encodedPassword);
        todoUserRepository.save(newUser);
        return message("User created successfully");
    }

    private JwtAuthenticationResponse message(String string) {
        return new JwtAuthenticationResponse(string);
    }

    public JwtAuthenticationResponse signin(SigninRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = todoUserRepository.findByEmail(request.getEmail());
        System.out.println("user At authservice : "+user);
        if (user == null) {
            throw new IllegalStateException("User not found");
        }
        var userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                new ArrayList<>());
        var jwt = jwtService.generateToken(userDetails);
        return JwtAuthenticationResponse.builder().token("Bearer " + String.valueOf(jwt)).build();
    }

}
