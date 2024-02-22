package est.projet.quizapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "createAt" , nullable = false , updatable = false)
    private Date createAt;

    @OneToMany(mappedBy = "question" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private List<Reponse> reponses;

    @ManyToOne
    private Quiz quiz;
}
