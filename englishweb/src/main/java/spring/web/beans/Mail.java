package spring.web.beans;

public abstract class Mail {
    private String reciver;
    private String subject;
    public Mail(String reciver, String subject) {
        this.reciver = reciver;
        this.subject = subject;
    }

    public String getReciver() {
        return reciver;
    }

    public void setReciver(String reciver) {
        this.reciver = reciver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Mail() {
    }


    abstract String getContent();

}
