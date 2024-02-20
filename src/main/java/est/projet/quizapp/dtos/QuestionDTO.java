package est.projet.quizapp.dtos;

import est.projet.quizapp.entities.Quiz;
import est.projet.quizapp.entities.Reponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class QuestionDTO {
    private Long id ;
    private String content;
    private Date createAt;
    private List<Reponse> reponses;
    private Quiz quiz;
}
