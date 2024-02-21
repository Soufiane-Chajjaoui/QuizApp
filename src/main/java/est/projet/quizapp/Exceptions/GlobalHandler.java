package est.projet.quizapp.Exceptions;


import est.projet.quizapp.dtos.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(EntityExisted.class)
    public ResponseEntity<ResponseModel> existEntity(EntityExisted e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseModel.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(e.getMessage())
                .error(e.getLocalizedMessage())
                .build());
    }
    @ExceptionHandler(EntityNotFound.class)
    public  ResponseEntity<ResponseModel> notFoundEntity(EntityNotFound e){
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ResponseModel.builder()
                        .status(HttpStatus.BAD_REQUEST)
                        .message(e.getMessage())
                        .error(e.getLocalizedMessage())
                        .build());
    }
}
