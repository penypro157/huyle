package spring.web.entity;

public class TrangThaiBanBe {
    public   static final int request =1;
    public  static final int invite=0;
    private boolean befriend =false;
    private boolean pending =false;
    private int type;

    public TrangThaiBanBe(boolean befriend, boolean pending, int type) {
        this.befriend = befriend;
        this.pending = pending;
        this.type = type;
    }

    public TrangThaiBanBe() {
    }


    public boolean isBefriend() {
        return befriend;
    }

    public void setBefriend(boolean befriend) {
        this.befriend = befriend;
    }

    public boolean isPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
