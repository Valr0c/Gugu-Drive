package praktikum.tugas_6;

import java.util.ArrayList;

public class Deskripsi extends Files{
    private String nama, type, color;
    private int durasi;

    public Deskripsi(String nama, String type, String nama_p) {
        super(nama_p);
        this.nama = nama;
        this.type = type;
    }
    
    public Deskripsi(String nama, String type, String color, String nama_p) {
        super(nama_p);
        this.nama = nama;
        this.type = type;
        this.color = color;
    }

    public Deskripsi(String nama, String type, int durasi, String nama_p) {
        super(nama_p);
        this.nama = nama;
        this.type = type;
        this.durasi = durasi;
    }

    public Deskripsi(String nama, String type, String color, int durasi, String nama_p) {
        super(nama_p);
        this.nama = nama;
        this.type = type;
        this.color = color;
        this.durasi = durasi;
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDurasi() {
        return durasi;
    }

    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }
    
    @Override
    public void cetakDeskripsi(Deskripsi f) {
        System.out.println("Name : " + f.getNama());
        System.out.println("Type : " + f.getType());
        if (f.getType().equals("jpg")) {
            System.out.println("Color : " + f.getColor());
        }else if (f.getType().equals("mp3")) {
            System.out.println("Duration : " + f.getDurasi() + " minutes");
        }else if (f.getType().equals("mp4")) {
            System.out.println("Color : " + f.getColor());
            System.out.println("Duration : " + f.getDurasi() + " minutes");
        }
    }


}
