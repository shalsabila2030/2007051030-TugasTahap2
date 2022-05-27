
package sistemsetrika;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import sistemsetrika.db.DBHandler;
import sistemsetrika.model.Setrika;

public class FXMLDocumentController implements Initializable {
    
     @FXML
    private Button btnSave;

    @FXML
    private ComboBox<?> cbMerk;

    @FXML
    private DatePicker dpTanggalProduksi;

    @FXML
    private ToggleGroup jenis;

    @FXML
    private Label label;

    @FXML
    private RadioButton rdListrik;

    @FXML
    private RadioButton rdUAP;

    @FXML
    private TextField tfID;

    @FXML
    private TextField tfNama;

    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
//        label.setText("Hello "+tfNama.getText());
        System.out.println(tfID.getText());
        System.out.println(tfNama.getText());
        System.out.println(dpTanggalProduksi.getValue().toString());
        String jenis="";
        if (rdListrik.isSelected())
           jenis=rdListrik.getText();
        if (rdUAP.isSelected())
           jenis=rdUAP.getText();
        
        System.out.println(jenis);
        System.out.println(cbMerk.getValue().toString());
//        Setrika(String npm, String nama, String tanggalLahir, String gender, String prodi)
        Setrika str = new Setrika(tfID.getText(),tfNama.getText(),dpTanggalProduksi.getValue().toString(),
            jenis,cbMerk.getValue().toString());
        DBHandler dh = new DBHandler("MYSQL");
        dh.addSetrika(str);
        FXMLDataViewController view = new FXMLDataViewController();
        view.showDataSetrika();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        ArrayList <String> list = new ArrayList<String>();
        list.add("Maspion");
        list.add("Samsung");
        ObservableList items = FXCollections.observableArrayList(list);
        cbMerk.setItems(items);
    }    
    
}
