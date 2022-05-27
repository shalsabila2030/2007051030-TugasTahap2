
package sistemsetrika.model;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SetrikaProperty {
    private StringProperty ID;
    private StringProperty nama;
    private StringProperty tanggalProduksi;
    private StringProperty jenis;
    private StringProperty merk;

    public SetrikaProperty(String ID, String nama, String tanggalProduksi, String jenis, String merk) {
        this.ID = new SimpleStringProperty(ID);
        this.nama = new SimpleStringProperty(nama);
        this.tanggalProduksi = new SimpleStringProperty(tanggalProduksi);
        this.jenis = new SimpleStringProperty(jenis);
        this.merk = new SimpleStringProperty(merk);
    }
    public SetrikaProperty(Setrika str){
        this.ID = new SimpleStringProperty(str.getID());
        this.nama = new SimpleStringProperty(str.getNama());
        this.tanggalProduksi = new SimpleStringProperty(str.getTanggalProduksi());
        this.jenis = new SimpleStringProperty(str.getJenis());
        this.merk = new SimpleStringProperty(str.getMerk());
    }
    public StringProperty getProdiProperty() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = new SimpleStringProperty(merk);
    }

    public StringProperty getIDProperty() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = new SimpleStringProperty(ID);
    }

    public StringProperty getNamaProperty() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = new SimpleStringProperty(nama);
    }

    public StringProperty getTanggalProduksiProperty() {
        return tanggalProduksi;
    }

    public void setTanggalProduksi(String tanggalProduksi) {
        this.tanggalProduksi = new SimpleStringProperty(tanggalProduksi);
    }

    public StringProperty getJenisProperty() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = new SimpleStringProperty(jenis);
    }

    public String getID() {
        return ID.get();
    }

    public String getNama() {
        return nama.get();
    }

    public String getTanggalProduksi() {
        return tanggalProduksi.get();
    }

    public String getJenis() {
        return jenis.get();
    }

    public String getMerk() {
        return merk.get();
    }
    
}
