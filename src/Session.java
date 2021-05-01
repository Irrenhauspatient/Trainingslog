import java.io.Serializable;

public class Session implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String einheit;
    private int menge;
    private String date;
    private String time;

    public Session(String name, String einheit) {

        setName(name);
        setEinheit(einheit);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEinheit() {
        return einheit;
    }

    public void setEinheit(String einheit) {
        this.einheit = einheit;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s", getName(), getMenge(), getEinheit());
    }
}
