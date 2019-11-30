package exceptions;

public class ApiException extends RuntimeException {
    private final int statusCode;

    public ApiException(int statusCode) {
        this.statusCode = statusCode;
    }

    public ApiException(String s, int statusCode) {
        super(s);
        this.statusCode = statusCode;
    }

    public ApiException(String s, Throwable throwable, int statusCode) {
        super(s, throwable);
        this.statusCode = statusCode;
    }

    public ApiException(Throwable throwable, int statusCode) {
        super(throwable);
        this.statusCode = statusCode;
    }

    public ApiException(String s, Throwable throwable, boolean b, boolean b1, int statusCode) {
        super(s, throwable, b, b1);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
