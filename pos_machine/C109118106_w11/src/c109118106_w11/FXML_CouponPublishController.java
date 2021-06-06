/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c109118106_w11;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import models.Coupon;
import models.CouponDAO;
import org.json.JSONException;
import org.json.JSONObject;
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
    private List<Coupon> coupons = new ArrayList();
    private CouponDAO coudao = new CouponDAO();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup cou_ops = new ToggleGroup();
        cou_option1.setToggleGroup(cou_ops);
        cou_option2.setToggleGroup(cou_ops);
        cou_option3.setToggleGroup(cou_ops);
        cou_option4.setToggleGroup(cou_ops);
    }

    @FXML
    private void publish(ActionEvent event) throws JSONException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String title = cou_title.getText();
        String date = cou_exp.getValue().format(formatter);
        String time = " 23:59:59";
        String expired_date = date + time;
        String detail = cou_detail.getText();
        int quantity = Integer.parseInt(cou_quantity.getText());
        for (int i=0;i<quantity;i++){
        Coupon cou = new Coupon("42087420",title,detail,expired_date,0);
        JSONObject body = new JSONObject(cou);
        //body.remove("num");
        coudao.insert(cou);
        System.out.println(body);
        }
        Stage stage = (Stage) publish.getScene().getWindow();
        stage.close();
    }

}
