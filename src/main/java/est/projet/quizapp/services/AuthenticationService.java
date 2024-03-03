package est.projet.quizapp.services;

import est.projet.quizapp.Exceptions.EntityExisted;
import est.projet.quizapp.Exceptions.EntityNotFound;
import est.projet.quizapp.dtos.AuthenticateRequest;
import est.projet.quizapp.dtos.AuthenticationResponse;
import est.projet.quizapp.dtos.RegisterRequest;
import est.projet.quizapp.entities.Token;
import est.projet.quizapp.entities.User;
import est.projet.quizapp.repositories.RepoUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final RepoUser repoUser;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final TokenCacheService tokenCacheService;
    private final AuthenticationManager authenticationManager;

    public Optional<AuthenticationResponse> register(RegisterRequest registerRequest){
        if (repoUser.findByUsername(registerRequest.getUsername()).isPresent()){
            throw new EntityExisted(registerRequest.getUsername() + " has already registered");
        }
        User user = new User();
        user.setCompleteName(registerRequest.getCompleteName());
        user.setUsername(registerRequest.getUsername());
        user.setSex(registerRequest.getSex());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        user.setRole(registerRequest.getRole());

        user = repoUser.save(user);

        String jwt = jwtService.generateToken(user);
        saveUserToken(jwt, user);
        return Optional.ofNullable(AuthenticationResponse.builder().token(jwt).build());
    }


    public  AuthenticationResponse authenticate(AuthenticateRequest userRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userRequest.getUsername(),
                        userRequest.getPassword()
                )
        );
        User user = repoUser.findByUsername(userRequest.getUsername()).orElseThrow(() -> new EntityNotFound("User Not Found"));
        String token = jwtService.generateToken(user);
        revokeTokens(user);
        saveUserToken(token , user);
        return AuthenticationResponse.builder().token(token).build();
    }

    private void revokeTokens(User user) {
        List<Token> tokens = tokenCacheService.findAllValidTokenUser(user.getId());
        if (tokens.isEmpty())
            return;
        tokens.stream().forEach(token -> {
            token.setLoggedout(true);
        });
        tokenCacheService.saveAll(tokens);
    }


    private void saveUserToken(String jwt, User user) {
        Token token = Token.builder()
                .loggedout(false)
                .token(jwt)
                .user(user)
                .build();
        tokenCacheService.save(token);
    }


}
