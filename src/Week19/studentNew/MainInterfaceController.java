package Week19.studentNew;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.EventObject;
import java.util.ResourceBundle;
import javafx.stage.Window;
public class MainInterfaceController {
@FXML
Button btnscene1,btnscene2;

    public Button changeSceneButton;
    public Button showPopUpStageButton;
    public void ChangeScene(ActionEvent actionEvent)throws IOException {
        Window mainWindow = changeSceneButton.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("StudentView.fxml"));
        mainWindow.getScene().setRoot(newRoot);
    }



    }


