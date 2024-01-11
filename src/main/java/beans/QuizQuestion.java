package beans;

import java.util.List;

public class QuizQuestion {
    private String text;
    private List<String> options;

    // Constructeur
    public QuizQuestion(String text, List<String> options) {
        this.text = text;
        this.options = options;
    }

    // Getters et Setters (ou Lombok pour générer automatiquement)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
