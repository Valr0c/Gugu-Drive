package praktikum.tugas_6;

import java.util.ArrayList;

public class Zip {
    private ArrayList<Files> zip = new ArrayList<>();
    private String nama;

    public Zip(String nama, ArrayList<Files> z) {
        this.nama = nama;
        this.zip = z;
    }

    public ArrayList<Files> getZip() {
        return zip;
    }

    public void setZip(ArrayList<Files> zip) {
        this.zip = zip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    
}
