package est.projet.quizapp.repositories;

import est.projet.quizapp.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TokenRepo extends JpaRepository<Token , Long> {

    @Query("SELECT t FROM Token t WHERE t.user.id = :id AND t.loggedout = false")
    List<Token> findAllValidTokenUser(Long id);


    Optional<Token> findByToken(String token);
}
