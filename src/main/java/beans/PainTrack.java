package beans;

public class PainTrack {

    private int id;
    private String track;
    private int painLevel;
    private int userId;

    // Constructeurs
    public PainTrack() {
        // Constructeur par défaut
    }

    public PainTrack(int id, String track, int painLevel, int userId) {
        this.id = id;
        this.track = track;
        this.painLevel = painLevel;
        this.userId = userId;
    }
    
    public PainTrack( String track, int painLevel, int userId) {
       
        this.track = track;
        this.painLevel = painLevel;
        this.userId = userId;
    }

    // Méthodes Getter
    public int getId() {
        return id;
    }

    public String getTrack() {
        return track;
    }

    public int getPainLevel() {
        return painLevel;
    }

    public int getUserId() {
        return userId;
    }

    // Méthodes Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public void setPainLevel(int painLevel) {
        this.painLevel = painLevel;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
