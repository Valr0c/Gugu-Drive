package praktikum.tugas_6;

import java.util.ArrayList;

public interface Tools {
    public void AddFile(String nama, String type, String color);
    public void AddFile(String nama, String type, int durasi);
    public void AddFile(String nama, String type, String color, int durasi);
    public void AddFile(Files f);
    public void editFile(Files f, String ubah);
    public void editFile(Files f, int ubah);
    public void DeleteFile(Files f);
    public void AddZip(ArrayList<Files> f, String nama);
    public void Extract(String nama);
}
