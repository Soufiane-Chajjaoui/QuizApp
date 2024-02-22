package est.projet.quizapp.dtos;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class QuestionDTO {
    private Long id ;
    private String content;
    private Date createAt;
    private List<ReponseDTO> responsesDTO;
    public QuizDTO quizDTO;
}
