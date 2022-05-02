package praktikum.tugas_6;

import java.util.ArrayList;

public class User implements Tools{
    private String username, password;
    private ArrayList<Files> file = new ArrayList<>();
    private ArrayList<Zip> zip = new ArrayList<>();
    private int counter;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        counter = 1;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCounter() {
        String counter = "-1";
        if (this.counter < 10) {
            counter = "00" + this.counter;
        }else if (this.counter < 100) {
            counter = "0" + this.counter;
        }else if (this.counter < 1000) {
            counter = "" + this.counter;
        }
        this.counter++;
        return counter;
    }
    
    public ArrayList<Files> getFile() {
        return file;
    }

    public ArrayList<Zip> getZip() {
        return zip;
    }
    
    public void cetakFile(){
        for (int i = 0; i < this.file.size(); i++) {
            System.out.println(i+1 + ". " + file.get(i).getNama_p());
        }
    }
    
    @Override
    public void AddFile(String nama, String type, String color) {
        this.file.add(new Deskripsi(nama, type, color, nama+"."+type));
    }

    @Override
    public void AddFile(String nama, String type, int durasi) {
        this.file.add(new Deskripsi(nama, type, durasi, nama+"."+type));
    }

    @Override
    public void AddFile(String nama, String type, String color, int durasi) {
        this.file.add(new Deskripsi(nama, type, color, durasi, nama+"."+type));
    }

    @Override
    public void AddFile(Files f) {
        this.file.add(f);
    }
    
    @Override
    public void editFile(Files f, String ubah) {
        if (ubah.equals("RGB") || ubah.equals("grayscale")) {
            ((Deskripsi)f).setColor(ubah);
        }else{
            ((Deskripsi)f).setNama(ubah);
            f.setNama_p(ubah + "." + ((Deskripsi)f).getType());
        }
    }

    @Override
    public void editFile(Files f, int ubah) {
        ((Deskripsi)f).setDurasi(ubah);
    }
    
    @Override
    public void DeleteFile(Files f) {
        this.file.remove(f);
    }

    @Override
    public void AddZip(ArrayList<Files> f, String nama) {
        zip.add(new Zip(nama,f));
        this.file.add(new Deskripsi(nama, "zip", nama+".zip"));
    }

    @Override
    public void Extract(String nama) {
        for (int i = 0; i < zip.size(); i++) {
            if (zip.get(i).getNama().equals(nama)) {
                ArrayList<Files> tmp = zip.get(i).getZip();
                for (int j = 0; j < tmp.size(); j++) {
                    file.add(tmp.get(j));
                }
                zip.remove(i);
                break;
            }
        }
        for (int i = 0; i < file.size(); i++) {
            if (((Deskripsi)file.get(i)).getNama().equals(nama)) {
                file.remove(i);
                break;
            }
        }
    }
    
}
