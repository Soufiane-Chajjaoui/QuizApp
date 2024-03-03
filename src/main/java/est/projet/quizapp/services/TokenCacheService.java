package est.projet.quizapp.services;

import est.projet.quizapp.entities.Token;
import est.projet.quizapp.repositories.TokenRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenCacheService {

    private final TokenRepo tokenRepo;

    @Cacheable(value = "Token", key = "#token " , unless = "#result?.isLoggedout()")
    public Optional<Token> findBytoken(String token) {
        return tokenRepo.findByToken(token);
    }

    public void save(Token token){
        tokenRepo.save(token);
    }

    public List<Token> findAllValidTokenUser(Long id){
        return tokenRepo.findAllValidTokenUser(id);
    }

    public void saveAll(List<Token> tokenList){
        tokenRepo.saveAll(tokenList);
    }



}
