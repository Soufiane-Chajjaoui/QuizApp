package est.projet.quizapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;

@Configuration
@EnableCaching
public class CacheConfig {

    @Value("${cache.ttl.Token}")
    private Integer TokenTTL;
    @Value("${cache.ttl.Quiz}")
    private Integer QuizTTL;
    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnection){
        return RedisCacheManager.builder(redisConnection)
                .withCacheConfiguration("Token" , RedisCacheConfiguration.defaultCacheConfig()
                        .entryTtl(Duration.ofMinutes(TokenTTL)))
                .withCacheConfiguration("Quiz" , RedisCacheConfiguration.defaultCacheConfig()
                        .entryTtl(Duration.ofMinutes(QuizTTL)))
                .withCacheConfiguration("Reponses" , RedisCacheConfiguration.defaultCacheConfig()
                        .entryTtl(Duration.ofMinutes(QuizTTL)))
                .build();
    }
}
