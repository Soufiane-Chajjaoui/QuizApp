package est.projet.quizapp.repositories;

import est.projet.quizapp.entities.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepoReponse extends JpaRepository<Reponse , Long> {
    Optional<List<Reponse>> findByQuestionId(Long id);
}
