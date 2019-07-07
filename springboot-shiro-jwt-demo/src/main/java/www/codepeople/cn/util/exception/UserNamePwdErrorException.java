package www.codepeople.cn.util.exception;

public class UserNamePwdErrorException extends MyException {

    private static final UserNamePwdErrorException userNamePwdErrorException = new UserNamePwdErrorException();

    private UserNamePwdErrorException() {
        super("账号或者密码错误!");
    }

    public static final UserNamePwdErrorException build(){
        return userNamePwdErrorException;
    }
}
