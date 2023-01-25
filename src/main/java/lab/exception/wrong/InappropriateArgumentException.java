package lab.exception.wrong;

/**
 * 메서드 전달인자가 잘못됐음을 의미하는 exception
 *
 * @author fixalot
 * @since 2022-11-15
 */
public class InappropriateArgumentException extends InappropriateStateException {

    public InappropriateArgumentException() {}

    public InappropriateArgumentException(String message) {
        super(message);
    }

}
