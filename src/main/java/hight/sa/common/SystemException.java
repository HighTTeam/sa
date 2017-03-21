package hight.sa.common;

/**
 * Created by neron.liu on 21/03/2017.
 */
public class SystemException extends Exception {

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public static SystemException of(String message) {
        return new SystemException(message);
    }

    public static SystemException of(String message, Throwable cause) {
        return new SystemException(message, cause);
    }

}
