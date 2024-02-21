package est.projet.quizapp.Exceptions;

public class EntityExisted extends RuntimeException{

    public EntityExisted() {
    }

    public EntityExisted(String message) {
        super(message);
    }
}
