package est.projet.quizapp.repositories;

import est.projet.quizapp.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepoQuiz extends JpaRepository<Quiz , Long> {
    List<Quiz> findByOrderByCreateAtDesc();
}
