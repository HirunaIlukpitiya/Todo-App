package toDoApp.toDo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import toDoApp.toDo.Model.request.SigninRequest;
import toDoApp.toDo.Model.request.SignupRequest;
import toDoApp.toDo.Model.response.JwtAuthenticationResponse;
import toDoApp.toDo.service.AuthService;

@RestController
@RequestMapping(path = "api/v1/auth")
@AllArgsConstructor
public class AuthController {

    private AuthService authService;

    @PostMapping(path = "/signup")
    public ResponseEntity<JwtAuthenticationResponse> SignUpUser(@RequestBody SignupRequest request) {
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping(path = "/signin")
    public ResponseEntity<JwtAuthenticationResponse> SignInUser(@RequestBody SigninRequest request) {
        return ResponseEntity.ok(authService.signin(request));
    }
    
}
