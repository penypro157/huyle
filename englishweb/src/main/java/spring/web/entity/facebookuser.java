package spring.web.entity;

public class facebookuser {
    private String name;
    private String id;

    public facebookuser(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public facebookuser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
