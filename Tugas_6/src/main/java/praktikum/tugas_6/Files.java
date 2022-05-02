package praktikum.tugas_6;

import java.util.ArrayList;

public abstract class Files {
    private String nama_p;

    public Files(String nama_p) {
        this.nama_p = nama_p;
    }

    public String getNama_p() {
        return nama_p;
    }

    public void setNama_p(String nama_p) {
        this.nama_p = nama_p;
    }
    
    public abstract void cetakDeskripsi(Deskripsi f);

}
