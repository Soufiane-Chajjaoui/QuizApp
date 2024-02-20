package est.projet.quizapp.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Quiz {
    @Id
    private Long id;
    private String titre;

    @OneToMany(mappedBy = "quiz" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<Question> questions;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "createAt" , nullable = false , updatable = false)
    private Date createAt;

}
