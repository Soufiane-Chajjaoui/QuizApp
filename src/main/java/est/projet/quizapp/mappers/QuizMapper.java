package est.projet.quizapp.mappers;

import est.projet.quizapp.dtos.QuizDTO;
import est.projet.quizapp.entities.Quiz;
import est.projet.quizapp.services.QuizService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring" ,  uses = {QuestionMapper.class})
public interface QuizMapper {

    QuizMapper INSTANCE = Mappers.getMapper(QuizMapper.class);
    Quiz fromDTO(QuizDTO quizDTO);
    QuizDTO toEntity(Quiz quiz);

}
