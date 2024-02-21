package est.projet.quizapp.mappers;

import est.projet.quizapp.dtos.ReponseDTO;
import est.projet.quizapp.entities.Reponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring" , uses = {QuestionMapper.class})
public interface ReponseMapper {
    ReponseMapper INSTANCE = Mappers.getMapper(ReponseMapper.class);
    Reponse fromDTO(ReponseDTO reponseDTO);
    ReponseDTO toEntity(Reponse reponse);
}
