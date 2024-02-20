package est.projet.quizapp.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
public class Reponse {
    @Id
    private Long id ;
    private String rep ;
    private boolean isCorrect;

    @ManyToOne
    private Question question;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "createAt" , nullable = false , updatable = false)
    private Date createAt;
}
