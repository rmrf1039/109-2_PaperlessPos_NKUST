/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c109118106_w11;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rxiau6-PC
 */
public class FXML_CouponPublishController implements Initializable {

    @FXML
    private DatePicker cou_exp;
    @FXML
    private TextField cou_title;
    @FXML
    private TextArea cou_detail;
    @FXML
    private RadioButton cou_option1;
    @FXML
    private RadioButton cou_option2;
    @FXML
    private RadioButton cou_option3;
    @FXML
    private RadioButton cou_option4;
    @FXML
    private TextField cou_quantity;
    @FXML
    private Button publish;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void publish(ActionEvent event) {
        Stage stage = (Stage) publish.getScene().getWindow();
        stage.close();
    }

}
