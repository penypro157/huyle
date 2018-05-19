package spring.web.entity;

public class Main {
    private float temp;
    private int hudimity;
    private int pressure;
    private float temp_min;
    private float temp_max;
    private float sea_level;
    private float grnd_level;

    public Main() {
    }

    public Main(float temp, int hudimity, int pressure, float temp_min, float temp_max, float sea_level, float grnd_level) {
        this.temp = temp;
        this.hudimity = hudimity;
        this.pressure = pressure;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.sea_level = sea_level;
        this.grnd_level = grnd_level;
    }

    public float getSea_level() {
        return sea_level;
    }

    public void setSea_level(float sea_level) {
        this.sea_level = sea_level;
    }

    public float getGrnd_level() {
        return grnd_level;
    }

    public void setGrnd_level(float grnd_level) {
        this.grnd_level = grnd_level;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public int getHudimity() {
        return hudimity;
    }

    public void setHudimity(int hudimity) {
        this.hudimity = hudimity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }

    public float getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }
}
