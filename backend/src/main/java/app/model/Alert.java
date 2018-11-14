package app.model;

import lombok.Data;

@Data
public class Alert {

    private String description;

    public Alert(String description) {
        this.description = description;
    }

}
