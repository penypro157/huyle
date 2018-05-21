package spring.web.entity;

public class TrangThai {
    private int role;
    private boolean active;
    private boolean verified;

    public TrangThai(int role, boolean active, boolean verified) {
        this.role = role;
        this.active = active;
        this.verified = verified;
    }

    public TrangThai() {
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}
