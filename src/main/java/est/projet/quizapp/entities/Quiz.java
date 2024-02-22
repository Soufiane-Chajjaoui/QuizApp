package est.projet.quizapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;

    @OneToMany(mappedBy = "quiz" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<Question> questions;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "createAt" , nullable = false , updatable = false)
    private Date createAt;

}
