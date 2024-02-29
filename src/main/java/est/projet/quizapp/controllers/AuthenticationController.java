package est.projet.quizapp.controllers;

import est.projet.quizapp.dtos.AuthenticateRequest;
import est.projet.quizapp.dtos.AuthenticationResponse;
import est.projet.quizapp.dtos.RegisterRequest;
import est.projet.quizapp.dtos.ResponseModel;
import est.projet.quizapp.entities.User;
import est.projet.quizapp.services.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthenticationController {
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.of(authenticationService.register(registerRequest));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticateRequest userRequest){
        return ResponseEntity.ok(authenticationService.authenticate(userRequest));
    }
}
