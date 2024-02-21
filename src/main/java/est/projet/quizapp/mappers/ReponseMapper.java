package est.projet.quizapp.mappers;

import est.projet.quizapp.dtos.ReponseDTO;
import est.projet.quizapp.entities.Reponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring" , uses = {QuestionMapper.class})
public interface ReponseMapper {
    ReponseMapper INSTANCE = Mappers.getMapper(ReponseMapper.class);
    @Mapping(source = "createAt" , target = "createAt", ignore = true)
    Reponse fromDTO(ReponseDTO reponseDTO);
    ReponseDTO toEntity(Reponse reponse);
}
