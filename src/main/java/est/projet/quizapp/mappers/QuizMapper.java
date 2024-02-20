package est.projet.quizapp.mappers;

import est.projet.quizapp.dtos.QuizDTO;
import est.projet.quizapp.entities.Quiz;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuizMapper {

    Quiz fromQuizDTO(QuizDTO quizDTO);
    QuizDTO fromQuiz(Quiz quiz);

}
