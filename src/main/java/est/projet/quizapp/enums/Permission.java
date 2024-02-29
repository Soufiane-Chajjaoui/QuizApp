package est.projet.quizapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_DELETE("admin:delete"),
    ADMIN_CREATE("admin:create");

    @Getter
    private final String permission;
}
