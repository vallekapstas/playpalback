package ee.valiit.playpalback.infrastructure.exception;

import lombok.Data;

@Data
public class ForbiddenException extends RuntimeException {
    private final String message;
    private final Integer errorCode;

    public ForbiddenException(String message, Integer errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }
}
