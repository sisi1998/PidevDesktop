package GUI;

import Entities.User;
import Utils.Constants;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.scene.text.Text;

public class MainWindowFrontController implements Initializable {

    static AnchorPane staticContent;
    private static MainWindowFrontController instance;

    @FXML
    private AnchorPane topBar;
    @FXML
    private AnchorPane content;

    public static MainWindowFrontController getInstance() {
        if (instance == null) {
            instance = new MainWindowFrontController();
        }
        return instance;
    }
    @FXML
    private Text sess;
    private User userc;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            staticContent = content;

            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Constants.FXML_FRONT_TOP_BAR)));
            AnchorPane.setTopAnchor(parent, 0.0);
            AnchorPane.setBottomAnchor(parent, 0.0);
            AnchorPane.setRightAnchor(parent, 0.0);
            AnchorPane.setLeftAnchor(parent, 0.0);
            topBar.getChildren().add(parent);

        } catch (IOException e) {
            System.out.println("Error loading " + e.getMessage());
            e.printStackTrace();
        }

        loadInterface(Constants.FXML_FRONT_HOME);
    }

    public void loadInterface(String location) {
        staticContent.getChildren().clear();
        if (getClass().getResource(location) == null) {
            System.out.println("Could not load FXML check the path");
        } else {
            try {
                Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(location)));
                AnchorPane.setTopAnchor(parent, 0.0);
                AnchorPane.setBottomAnchor(parent, 0.0);
                AnchorPane.setRightAnchor(parent, 0.0);
                AnchorPane.setLeftAnchor(parent, 0.0);
                staticContent.getChildren().add(parent);
            } catch (IOException e) {
                System.out.println("Could not load FXML : " + e.getMessage() + " check your controller");
                e.printStackTrace();
            }
        }
    }
    public void getSession(User userc){
         this.userc=userc;
    this.sess.setText(userc.getEmail());
}
    
    
}
