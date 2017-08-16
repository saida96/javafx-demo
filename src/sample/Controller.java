package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {

    @FXML
    private TextField myTextField;

    @FXML
    private Label myLabel;

    public void handleKeyEvent(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            fetchWordDefinition();
        }
    }

    private void fetchWordDefinition() {
        // start fetch word definition task
    }
}


