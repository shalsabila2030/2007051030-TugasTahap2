
package sistemsetrika.model;

public class Setrika {
    private String id;
    private String nama;
    private String tanggalProduksi;
    private String jenis;
    private String merk;

    public Setrika(String id, String nama, String tanggalProduksi, String jenis, String merk) {
        this.id = id;
        this.nama = nama;
        this.tanggalProduksi = tanggalProduksi;
        this.jenis = jenis;
        this.merk = merk;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggalProduksi() {
        return tanggalProduksi;
    }

    public void setTanggalProduksi(String tanggalProduksi) {
        this.tanggalProduksi = tanggalProduksi;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    
}
