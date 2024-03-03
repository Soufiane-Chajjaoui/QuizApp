package est.projet.quizapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@Builder @AllArgsConstructor @NoArgsConstructor
public class Token implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String token;
    private boolean loggedout;
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private User user;
}
