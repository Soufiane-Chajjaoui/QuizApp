package est.projet.quizapp.mappers;

import est.projet.quizapp.dtos.ReponseDTO;
import est.projet.quizapp.entities.Reponse;
import org.mapstruct.Mapper;

@Mapper
public interface ReponseMapper {
    Reponse fromResponseDTO(ReponseDTO reponseDTO);
    ReponseDTO fromReponse(Reponse reponse);
}
