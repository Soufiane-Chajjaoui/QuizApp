package est.projet.quizapp.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Question {
    @Id
    private Long id;
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "createAt" , nullable = false , updatable = false)
    private Date createAt;
    @OneToMany
    private List<Reponse> reponses;
    @ManyToOne
    private Quiz quiz;
}
