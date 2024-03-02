package est.projet.quizapp;

import est.projet.quizapp.dtos.AuthenticationResponse;
import est.projet.quizapp.dtos.RegisterRequest;
import est.projet.quizapp.services.AuthenticationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import static est.projet.quizapp.enums.Role.ADMIN;
import static est.projet.quizapp.enums.Role.USER;
import static est.projet.quizapp.enums.Sex.MALE;
import static est.projet.quizapp.enums.Sex.MAN;

@SpringBootApplication
@EnableCaching
public class QuizAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuizAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AuthenticationService authenticationService){
        return args -> {
            RegisterRequest admin = RegisterRequest.builder().sex(MAN).role(ADMIN)
                    .completeName("soufian").username("soufian-ch22")
                    .password("soufian").build();
            System.out.println(authenticationService.register(admin).orElseGet(()-> new AuthenticationResponse(null , "User Already Exist")).getToken());
//            RegisterRequest user = RegisterRequest.builder().Sex(MALE).Role(USER)
//                    .CompleteName("kawtar").Username("kawtar")
//                    .Password("kawtar").build();
//            System.out.println(authenticationService.register(user).getToken());
        };
    }

}
