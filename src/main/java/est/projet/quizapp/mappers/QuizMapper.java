package est.projet.quizapp.mappers;

import est.projet.quizapp.dtos.QuizDTO;
import est.projet.quizapp.entities.Quiz;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring" ,  uses = {QuestionMapper.class})
public interface QuizMapper {

    QuizMapper INSTANCE = Mappers.getMapper(QuizMapper.class);
    @Mapping(source = "createAt" , target = "createAt", ignore = true)
    Quiz fromDTO(QuizDTO quizDTO);
    QuizDTO fromEntity(Quiz quiz);

}
