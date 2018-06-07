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
        String tempory="<b>Welcome to Social website, Thanks for your registering account. \n</>" +
                "Click here to active your account " +
                "<a href=\"http://localhost:8080/active?code="+randomString+"\">"+randomString+"</a>";
        return tempory;
    }
}
