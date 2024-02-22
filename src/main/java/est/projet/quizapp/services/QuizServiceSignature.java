package est.projet.quizapp.services;

import est.projet.quizapp.dtos.QuestionDTO;
import est.projet.quizapp.dtos.QuizDTO;
import est.projet.quizapp.dtos.ReponseDTO;

import java.util.List;
import java.util.Optional;

public interface QuizServiceSignature {

    Optional<QuizDTO> addQuiz(QuizDTO quizDTO);
    Optional<Boolean> deleteQuiz(Long id);
    Optional<QuizDTO> getQuiz(Long id);
    Optional<List<QuizDTO>> getQuizzes();
    Optional<QuizDTO> updateQuiz(QuizDTO quizDTO);
    Optional<List<QuestionDTO>> getQuestions(Long id);
    Optional<QuestionDTO> addQuestion(QuestionDTO questionDTO);
    Optional<Boolean> deleteQuestion(Long id);
    Optional<QuestionDTO> getQuestion(Long id);
    Optional<QuestionDTO> updateQuestion(QuestionDTO questionDTO);
    Optional<ReponseDTO> addReponse(ReponseDTO reponseDTO);
    Optional<ReponseDTO> updateReponse(ReponseDTO reponseDTO);
    Optional<Boolean> deleteResponse(Long id);

    Optional<List<ReponseDTO>> getReponseByQuestion(Long id);

    Optional<ReponseDTO> getReponse(Long id);
}
