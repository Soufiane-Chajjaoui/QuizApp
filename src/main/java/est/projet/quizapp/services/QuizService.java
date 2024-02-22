package est.projet.quizapp.services;

import est.projet.quizapp.Exceptions.EntityNotFound;
import est.projet.quizapp.dtos.QuestionDTO;
import est.projet.quizapp.dtos.QuizDTO;
import est.projet.quizapp.dtos.ReponseDTO;
import est.projet.quizapp.entities.Question;
import est.projet.quizapp.entities.Quiz;
import est.projet.quizapp.entities.Reponse;
import est.projet.quizapp.mappers.QuestionMapper;
import est.projet.quizapp.mappers.QuizMapper;
import est.projet.quizapp.mappers.ReponseMapper;
import est.projet.quizapp.repositories.RepoQuestion;
import est.projet.quizapp.repositories.RepoQuiz;
import est.projet.quizapp.repositories.RepoReponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
@AllArgsConstructor
public class QuizService implements QuizServiceSignature{

    //Repositories
    public RepoQuiz repoQuiz ;
    public RepoReponse repoReponse;
    public RepoQuestion repoQuestion;

    //Mappers
    public QuizMapper quizMapper ;
    public QuestionMapper questionMapper;
    public ReponseMapper reponseMapper;


    @Override
    public Optional<QuizDTO> addQuiz(QuizDTO quizDTO){

        return Optional.ofNullable(quizMapper.fromEntity(repoQuiz.save(quizMapper.fromDTO(quizDTO))));
    }
    @Override
    public Optional<Boolean> deleteQuiz(Long id){
        repoQuiz.findById(id).orElseThrow(()-> new EntityNotFound("This Quiz Not Found") );
        repoQuiz.deleteById(id);
        return Optional.of(true);
    }

    @Override
    public Optional<QuizDTO> getQuiz(Long id) {

        return Optional.ofNullable(
                quizMapper.fromEntity(repoQuiz.findById(id)
                        .orElseThrow(()-> new EntityNotFound("Quiz Not found"))));
    }


    @Override
    public Optional<QuizDTO> updateQuiz(QuizDTO quizDTO){
        repoQuiz.findById(quizDTO.getId()).orElseThrow(()->new EntityNotFound( quizDTO.getTitre() +"Not Found"));
        Quiz quiz = quizMapper.fromDTO(quizDTO);
        return Optional.ofNullable(quizMapper.fromEntity(repoQuiz.save(quiz)));
    }

    @Override
    public Optional<List<QuizDTO>> getQuizzes() {
        List<Quiz> quizzes = repoQuiz.findAll();
        return Optional.ofNullable(quizzes.stream().map((q)->
            quizMapper.fromEntity(q)).collect(Collectors.toList()));
    }
    @Override
    public Optional<List<QuestionDTO>> getQuestions(Long id) {

        return Optional.ofNullable(repoQuestion.findByQuizId(id).stream()
                .map(question -> questionMapper.fromEntity(question))
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<QuestionDTO> addQuestion(QuestionDTO questionDTO) {
        Quiz quiz = repoQuiz.findById(questionDTO.getQuizDTO().getId()).orElseThrow(() -> new EntityNotFound("Quiz " + questionDTO.getQuizDTO().getId() + " Not found"));
        Question qEntity = questionMapper.fromDTO(questionDTO);
        qEntity.setQuiz(quiz);
        return Optional.ofNullable(questionMapper.fromEntity(repoQuestion.save(qEntity)));
    }

    @Override
    public Optional<Boolean> deleteQuestion(Long id) {
        try {
            repoQuestion.deleteById(id);
            return  Optional.of(true);
        }catch (Exception e){
            return  Optional.empty();
        }
    }
    @Override
    public Optional<QuestionDTO> updateQuestion(QuestionDTO questionDTO){
        Question question = repoQuestion.findById(questionDTO.getId()).orElseThrow(()->new EntityNotFound("Entity Not Found"));
        question.setContent(questionDTO.getContent());
        return Optional.ofNullable(questionMapper.fromEntity(repoQuestion.save(question)));
    }

    @Override
    public Optional<QuestionDTO> getQuestion(Long id) {
        Question question = repoQuestion.findById(id).orElseThrow(()-> new EntityNotFound("This Question Not Found"));
        return Optional.ofNullable(questionMapper.fromEntity(question));
    }


    @Override
    public Optional<ReponseDTO> addReponse(ReponseDTO reponseDTO){
        Question question = repoQuestion.findById(reponseDTO.getQuestionDTO().getId()).orElseThrow(() -> new EntityNotFound("Quiz " + reponseDTO.getQuestionDTO().getId() + " Not found"));
        Reponse rEntity = reponseMapper.fromDTO(reponseDTO);
        rEntity.setQuestion(question);
        return Optional.ofNullable(reponseMapper.fromEntity(repoReponse.save(rEntity)));
    }

    @Override
    public Optional<ReponseDTO> updateReponse(ReponseDTO reponseDTO) {
        Reponse reponse = repoReponse.findById(reponseDTO.getId()).orElseThrow(()-> new EntityNotFound("Entity not found"));
        reponse.setRep(reponseDTO.getRep());
        return Optional.ofNullable(reponseMapper.fromEntity(repoReponse.save(reponse)));
    }

    @Override
    public Optional<Boolean> deleteResponse(Long id) {
        try {
            repoReponse.deleteById(id);
            return Optional.of(true);
        }catch (Exception e){
            throw new EntityNotFound("Entity not Found To delete");
        }
    }
    @Override
    public Optional<List<ReponseDTO>> getReponseByQuestion(Long id){
        List<Reponse> reponses = repoReponse.findByQuestionId(id).orElseThrow(()->new EntityNotFound("Entity Not Found"));
        return Optional.ofNullable(reponses.stream().map(reponse -> reponseMapper.fromEntity(reponse)).collect(Collectors.toList()));
    }
    @Override
    public Optional<ReponseDTO> getReponse(Long id){
        return Optional.ofNullable(reponseMapper.fromEntity(repoReponse.findById(id).orElseThrow(()-> new EntityNotFound("Entity Not Found"))));
    }
}
