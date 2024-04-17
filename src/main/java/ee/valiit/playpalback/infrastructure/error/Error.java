package ee.valiit.playpalback.infrastructure.error;

import lombok.Getter;

@Getter
public enum Error {
    // 403
    INCORRECT_CREDENTIALS("Vale kasutajanimi või parool", 403001),
    USER_EXISTS("Kasutajanimi on juba kasutusel", 403002);
    private final String message;
    private final int errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
