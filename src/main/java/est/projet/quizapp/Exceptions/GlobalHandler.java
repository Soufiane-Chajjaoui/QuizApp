package est.projet.quizapp.Exceptions;


import est.projet.quizapp.dtos.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.security.SignatureException;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED) //Unauthorized if the credentials are invalid
    public ProblemDetail handleAuthenticationException(AuthenticationException e){
        if (e instanceof BadCredentialsException){
            ProblemDetail errorDetails = ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED , e.getMessage());
            errorDetails.setProperty("access_denied_reason" , e.getMessage());
            return errorDetails;
        }
        return null;
    }
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ProblemDetail handleAccessDeniedException(AccessDeniedException e){
        ProblemDetail errorDetails = ProblemDetail.forStatusAndDetail(HttpStatus.FORBIDDEN , e.getMessage());
        errorDetails.setProperty("access_denied_reason" , "You are Not Authorize for this Resources");
        return errorDetails;
    }

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
