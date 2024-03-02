package est.projet.quizapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
