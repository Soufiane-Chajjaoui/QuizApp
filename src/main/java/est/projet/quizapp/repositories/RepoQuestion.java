package est.projet.quizapp.repositories;

import est.projet.quizapp.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoQuestion extends JpaRepository<Question , Long> {
}
