package est.projet.quizapp.repositories;

import est.projet.quizapp.entities.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoReponse extends JpaRepository<Reponse , Long> {
}
