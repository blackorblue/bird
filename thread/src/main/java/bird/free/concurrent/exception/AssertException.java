package bird.free.concurrent.exception;

/**
 * @author: zhouziyan
 * @review:
 * @Date: 2019/6/14 10:45
 */
public class AssertException extends RuntimeException {

    private final String MSG;

    public AssertException(String msg) {
        this.MSG = msg;
    }



}
