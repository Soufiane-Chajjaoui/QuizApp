package est.projet.quizapp.repositories;

import est.projet.quizapp.entities.Question;
import est.projet.quizapp.entities.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepoQuestion extends JpaRepository<Question , Long> {
    List<Question> findByQuizId(Long id);
}
