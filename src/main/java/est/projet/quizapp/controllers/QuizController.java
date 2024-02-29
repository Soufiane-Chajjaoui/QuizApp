package est.projet.quizapp.controllers;

import est.projet.quizapp.Exceptions.EntityNotFound;
import est.projet.quizapp.dtos.QuestionDTO;
import est.projet.quizapp.dtos.QuizDTO;
import est.projet.quizapp.dtos.ReponseDTO;
import est.projet.quizapp.dtos.ResponseModel;
import est.projet.quizapp.services.QuizServiceSignature;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/quiz")
@AllArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class QuizController {

    public QuizServiceSignature quizService;
    @PostMapping
    public ResponseEntity<?> saveQuiz(@RequestBody QuizDTO quiz){

        return  ResponseEntity.of(quizService.addQuiz(quiz));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseModel> deleteQuiz(@PathVariable Long id){
        if (quizService.deleteQuiz(id).isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(
                ResponseModel.builder().message("Has been Deleted").status(HttpStatus.OK).build());
        throw new EntityNotFound("Quiz Not Found");
    }

    @PutMapping
    public ResponseEntity<?> updateQuiz(@RequestBody QuizDTO quizDTO){
        return ResponseEntity.of(quizService.updateQuiz(quizDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getQuiz(@PathVariable Long id){
        return ResponseEntity.of(quizService.getQuiz(id));
    }

    @GetMapping
    public ResponseEntity<?> getQuizzes(){
        return ResponseEntity.of(quizService.getQuizzes());
    }
    @GetMapping("/{id}/questions")
    public ResponseEntity<List<QuestionDTO>> getQuestions(@PathVariable Long id){
        return ResponseEntity.of(quizService.getQuestions(id));
    }

    @PostMapping("/questions")
    public ResponseEntity<?> addQuestion(@RequestBody QuestionDTO questionDTO){
        return ResponseEntity.of(quizService.addQuestion(questionDTO));
    }
    @DeleteMapping("/questions/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long id) {
        if (quizService.deleteQuestion(id).isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(
                    ResponseModel.builder().message("Has been Deleted").status(HttpStatus.OK).build());
        throw new EntityNotFound("Quiz Not Found");
    }
    @GetMapping("/questions/{id}")
    public ResponseEntity<?> getQuestion(@PathVariable Long id){
        return ResponseEntity.of(quizService.getQuestion(id));
    }
    @PutMapping("/questions")
    public ResponseEntity<?> updateQuestion(@RequestBody QuestionDTO questionDTO){
        if (quizService.updateQuestion(questionDTO).isPresent()){
            return ResponseEntity.ok(ResponseModel.builder()
                    .status(HttpStatus.OK).message("has been Edit").build());
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @PostMapping("/questions/reponse")
    public ResponseEntity<?> addReponse(@RequestBody ReponseDTO reponseDTO){
        return ResponseEntity.of(quizService.addReponse(reponseDTO));
    }

    @DeleteMapping("/questions/reponse/{id}")
    public ResponseEntity<?> deleteReponse(@PathVariable Long id){
        return ResponseEntity.of(quizService.deleteResponse(id));
    }
    @PutMapping("/questions/reponse")
    public ResponseEntity<?> updateReponse(@RequestBody ReponseDTO reponseDTO){
        return ResponseEntity.of(quizService.updateReponse(reponseDTO));
    }
    @GetMapping("/questions/{id}/reponse")
    public ResponseEntity<?> getReponsesByQuestion(@PathVariable Long id){
        return ResponseEntity.of(quizService.getReponseByQuestion(id));
    }
    @GetMapping("/questions/reponse/{id}")
    public ResponseEntity<?> getReponse(@PathVariable Long id){
        return ResponseEntity.of(quizService.getReponse(id));
    }
}
