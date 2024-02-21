package est.projet.quizapp.Exceptions;

public class EntityNotFound extends RuntimeException{

    public EntityNotFound() {
    }

    public EntityNotFound(String message) {
        super(message);
    }
}
