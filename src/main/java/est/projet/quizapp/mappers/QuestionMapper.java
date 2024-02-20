package est.projet.quizapp.mappers;

import est.projet.quizapp.dtos.QuestionDTO;
import est.projet.quizapp.entities.Question;
import org.mapstruct.Mapper;

@Mapper
public interface QuestionMapper {

    Question fromQuestionDTO(QuestionDTO questionDTO);
    QuestionDTO fromQuestion(Question question);
}
