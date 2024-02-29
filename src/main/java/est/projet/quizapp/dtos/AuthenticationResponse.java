package est.projet.quizapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor @Builder
public class AuthenticationResponse {
    private String token;
    private String message;
}
