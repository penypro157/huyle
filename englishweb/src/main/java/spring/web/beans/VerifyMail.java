package spring.web.beans;

public class VerifyMail extends Mail {
    private String randomString;

    public String getRandomString() {
        return randomString;
    }

    public void setRandomString(String randomString) {
        this.randomString = randomString;
    }

    public VerifyMail(String reciver, String randomString) {
        super.setReciver(reciver);
        super.setSubject("Acctive acount");
        this.randomString = randomString;
    }

    @Override
     String getContent() {
        String tempory="Click here to active your account" +
                "<a href=\""+randomString+"\"></a>";
        return tempory;
    }
}
