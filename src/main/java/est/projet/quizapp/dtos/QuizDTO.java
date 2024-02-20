package est.projet.quizapp.dtos;

import est.projet.quizapp.entities.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class QuizDTO {
    private Long id;
    private String titre;
    private List<Question> questions;
    private Date createAt;
}
