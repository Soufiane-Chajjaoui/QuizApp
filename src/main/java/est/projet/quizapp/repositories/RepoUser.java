package est.projet.quizapp.repositories;

import est.projet.quizapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepoUser extends JpaRepository<User , Long > {
    Optional<User> findByUsername(String username);
}
