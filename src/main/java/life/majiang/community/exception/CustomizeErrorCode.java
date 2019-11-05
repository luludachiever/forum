package life.majiang.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode{

    QUESTION_NOT_FOUND("Your Question Doesnt Exist, Try Another One");
    private String message;
   @Override
   public String getMessage() {
       return message;
   }


   CustomizeErrorCode(String message) {
       this.message = message;
   }


}
