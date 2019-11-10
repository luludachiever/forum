package life.majiang.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode{

    QUESTION_NOT_FOUND(2001,"Your Question Doesnt Exist, Try Another One"),
    TARGET_PARAM_NOT_FOUND(2002,"Need to choose the question to comment"),
    NOT_LOGIN(2003, "need to log in to comment"),
    ;
    private Integer code;
    private String message;
    @Override
    public Integer getCode() {
        return code;
    }
   @Override
   public String getMessage() {
       return message;
   }


   CustomizeErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
   }


}
