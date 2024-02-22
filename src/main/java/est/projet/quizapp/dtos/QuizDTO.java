package est.projet.quizapp.dtos;

import est.projet.quizapp.entities.Question;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
public class QuizDTO {
    private Long id;
    private String titre;
    private List<QuestionDTO> questionsDTO;
    public Date createAt;
}
