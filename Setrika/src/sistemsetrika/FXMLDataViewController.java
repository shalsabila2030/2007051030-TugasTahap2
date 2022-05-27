package sistemsetrika;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import sistemsetrika.db.DBHandler;
import sistemsetrika.model.SetrikaProperty;

public class FXMLDataViewController implements Initializable {

    @FXML
    private TableView<SetrikaProperty> tblSetrika;

    @FXML
    private TableColumn<SetrikaProperty, String> colTglProduksi;

    @FXML
    private TableColumn<SetrikaProperty, String> colid;

    @FXML
    private TableColumn<SetrikaProperty, String> colNama;

    @FXML
    private TableColumn<SetrikaProperty, String> colJenis;
    
    @FXML
    private TableColumn<SetrikaProperty, String> colMerk;

    @FXML
    private MenuItem menuAddData;

    @FXML
    private MenuItem menuDeleteData;

    @FXML
    void viewAddDataForm(ActionEvent event) throws IOException {
        Stage modal = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        modal.setScene(scene);
//        modal.initOwner(((Node)event.getSource()).getScene().getWindow() );
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();
    }

    @FXML
    void deleteDataMahasiswa(ActionEvent event) {
        SetrikaProperty str = tblSetrika.getSelectionModel().getSelectedItem();
        DBHandler dh = new DBHandler("MYSQL");
        dh.deleteSetrika(str);
        showDataSetrika();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showDataSetrika();

        tblSetrika.getSelectionModel().selectedIndexProperty().addListener(listener -> {
//            JOptionPane.showMessageDialog(null, "Table Diklik!");
            menuDeleteData.setDisable(false);
        });
    }

    public void showDataSetrika() {
        DBHandler dh = new DBHandler("MYSQL");
        ObservableList<SetrikaProperty> data = dh.getSetrika();
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colJenis.setCellValueFactory(new PropertyValueFactory<>("jenis"));
        colTglProduksi.setCellValueFactory(new PropertyValueFactory<>("tanggalproduksi"));
        tblSetrika.setItems(null);
        tblSetrika.setItems(data);
    }
}
