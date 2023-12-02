package mainpkg;

import java.io.Serializable;


public class Feedback implements Serializable{
    protected String feedbackTextArea;
    protected int userIDTextField;
    protected String usernameTextField1;


    public Feedback(String feedbackTextArea, int userIDTextField, String usernameTextField1) {
        this.feedbackTextArea = feedbackTextArea;
        this.userIDTextField = userIDTextField;
        this.usernameTextField1 = usernameTextField1;

    }

    public String getFeedbackTextArea() {
        return feedbackTextArea;
    }

    public int getUserIDTextField() {
        return userIDTextField;
    }

    public String getUsernameTextField1() {
        return usernameTextField1;
    }
    
}
