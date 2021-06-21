package unsa.epis.oximetro;

public class Evaluation {
    private int oxygenation;
    private String date;

    public Evaluation(int oxygenation, String date) {
        this.oxygenation = oxygenation;
        this.date = date;
    }

    public int getOxygenation() {
        return oxygenation;
    }

    public String getDate() {
        return date;
    }

    public void setOxygenation(int oxygenation) {
        this.oxygenation = oxygenation;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
