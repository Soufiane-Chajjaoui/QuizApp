package est.projet.quizapp.dtos;

import est.projet.quizapp.entities.Question;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class QuizDTO implements Serializable {
    private Long id;
    private String titre;
    private List<QuestionDTO> questionsDTO;
    public Date createAt;
}
