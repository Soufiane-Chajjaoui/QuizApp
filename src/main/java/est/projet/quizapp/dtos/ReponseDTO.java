package est.projet.quizapp.dtos;

import est.projet.quizapp.entities.Question;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
public class ReponseDTO {
    private Long id ;
    private String rep ;
    private boolean isCorrect;
    private Question question;
    private Date createAt;

}
