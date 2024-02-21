package est.projet.quizapp.mappers;

import est.projet.quizapp.dtos.QuestionDTO;
import est.projet.quizapp.entities.Question;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring" , uses = {QuizMapper.class , ReponseMapper.class})
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);
    Question fromDTO(QuestionDTO questionDTO);

    QuestionDTO toEntity(Question question);
}
