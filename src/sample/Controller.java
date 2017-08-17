package sample;

import javafx.concurrent.Task;
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
        try {
            String taskResult = (new FetchWordDefinitionTask()).call();
            myLabel.setText(taskResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class FetchWordDefinitionTask extends Task<String> {

        @Override
        protected String call() throws Exception {

            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
            }

            System.out.println(NetworkUtils.buildUrl("super"));
            return "It works!";
        }
    }
}


