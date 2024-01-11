package beans;



public class diagno {

    private int id;
    private float kg;
    private float cm;
    private float scores;
    private String diag;
    private int userId;

    // Constructeurs
    public diagno() {
        // Constructeur par défaut
    }

    public diagno(int id, float kg, float cm, float scores, String diag, int userId) {
        this.id = id;
        this.kg = kg;
        this.cm = cm;
        this.scores = scores;
        this.diag = diag;
        this.userId = userId;
    }

    public diagno(float kg, float cm, float scores, String diag, int userId) {
        this.kg = kg;
        this.cm = cm;
        this.scores = scores;
        this.diag = diag;
        this.userId = userId;
    }
    
    // Méthodes Getter
    public int getId() {
        return id;
    }

    public float getKg() {
        return kg;
    }

    public float getCm() {
        return cm;
    }

    public float getScores() {
        return scores;
    }

    public String getDiag() {
        return diag;
    }

    public int getUserId() {
        return userId;
    }

    // Méthodes Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setKg(float kg) {
        this.kg = kg;
    }

    public void setCm(float cm) {
        this.cm = cm;
    }

    public void setScores(float scores) {
        this.scores = scores;
    }

    public void setDiag(String diag) {
        this.diag = diag;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
