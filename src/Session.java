import java.io.Serializable;

public class Session implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String einheit;
    private int menge;

    public Session(String name, String einheit, int menge) {

        setName(name);
        setEinheit(einheit);
        setMenge(menge);

    }

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

    @Override
    public String toString() {
        return String.format("%s %s", getName(), getEinheit());
    }
}
