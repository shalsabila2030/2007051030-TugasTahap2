
package sistemsetrika.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sistemsetrika.model.Setrika;
import sistemsetrika.model.SetrikaProperty;

public class DBHandler {
    public final Connection conn;

    public DBHandler(String driver) {
        this.conn = DBHelper.getConnection(driver);
    }
    public void addSetrika(Setrika str){
        String insertStr = "INSERT INTO `setrika`(`id`, `nama`, `tgl_produksi`,`jenis`,`merk`)"
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement stmtInsert = conn.prepareStatement(insertStr);
            stmtInsert.setString(1, str.getID());
            stmtInsert.setString(2, str.getNama());
            stmtInsert.setString(3, str.getTanggalProduksi());
            stmtInsert.setString(4, str.getJenis());
            stmtInsert.setString(5, str.getMerk());
            stmtInsert.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ObservableList<SetrikaProperty> getSetrika(){
        ObservableList<SetrikaProperty> data = FXCollections.observableArrayList();
        
        String sql = "SELECT id, nama, tgl_lahir, jenis, merek FROM `setrika` ORDER BY id";
        
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
                SetrikaProperty str = new SetrikaProperty(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                data.add(str);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }
    
    public void deleteSetrika(SetrikaProperty str){
        String deleteStr = "DELETE FROM setrika WHERE `setrika`.`id` = ?";
        try {
            PreparedStatement stmtDelete = conn.prepareStatement(deleteStr);
            stmtDelete.setString(1, str.getID());
            stmtDelete.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
