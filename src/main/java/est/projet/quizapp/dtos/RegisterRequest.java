package est.projet.quizapp.dtos;

import est.projet.quizapp.enums.Role;
import est.projet.quizapp.enums.Sex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data @AllArgsConstructor @NoArgsConstructor
public class RegisterRequest {
    private String completeName;
    private Sex sex;
    private Role role;
    private String username;
    private String password;
}
