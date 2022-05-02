package praktikum.tugas_6;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<User> user = new ArrayList<> ();
        int inp;
        do {
            System.out.println("***Gugu Drive***");
            System.out.println("1. Login");
            System.out.println("0. Exit");
            System.out.println(">> ");
            inp = Integer.parseInt(sc.nextLine());
            
            if (inp == 1) {
                User curr = null;
                System.out.println("Username : ");
                String username = sc.nextLine();
                System.out.println("Password : ");
                String password = sc.nextLine();

                boolean ketemu = false;
                int idx = -1;
                for (int i = 0; i < user.size(); i++) {
                    if (username.equals(user.get(i).getUsername())) {
                        ketemu = true;
                        idx = i;
                        break;
                    }
                }
                if (!ketemu) {
                    user.add(new User(username,password));
                    System.out.println("Account Registered!");
                }else{
                    curr = user.get(idx);
                    if (password.equals(curr.getPassword())) {
                        System.out.println("Login Succes!");
                    }else{
                        System.out.println("Username atau Password Salah!");
                        curr = null;
                    }
                }
                
                if (curr != null) {
                    int inp2;
                    do {
                        System.out.println("Welcome " + curr.getUsername() + "!");
                        System.out.println("1. My Files");
                        System.out.println("2. Other Files");
                        System.out.println("0. Logout");
                        System.out.println(">> ");
                        inp2 = Integer.parseInt(sc.nextLine());
                        
                        if (inp2 == 1) {
                            int inp3 = -1;
                            String tmp;
                            do {
                                System.out.println("***My Files***");
                                curr.cetakFile();
                                System.out.println("0. Back");
                                System.out.println(">> ");
                                tmp = sc.nextLine();
                                String temp[] = tmp.split(" ");
                                if (temp[0].equals("add")) {
                                    System.out.println("Tipe Data : ");
                                    String tipe_data = sc.nextLine();
                                    if (tipe_data.equals("jpg")) {
                                        System.out.println("Color : ");
                                        String color = sc.nextLine();
                                        curr.AddFile(temp[1], tipe_data, color);
                                    }else if (tipe_data.equals("mp3")) {
                                        System.out.println("Duration : ");
                                        int durasi = Integer.parseInt(sc.nextLine());
                                        curr.AddFile(temp[1], tipe_data, durasi);
                                    }else if (tipe_data.equals("mp4")) {
                                        System.out.println("Color : ");
                                        String color = sc.nextLine();
                                        System.out.println("Duration : ");
                                        int durasi = Integer.parseInt(sc.nextLine());
                                        curr.AddFile(temp[1], tipe_data, color, durasi);
                                    }
                                    System.out.println("Item Added!");
                                }else if (temp[0].equals("send")) {
                                    ArrayList<Integer> to = new ArrayList<>();
                                    if (temp[1].indexOf(",") != -1) {
                                        String tempp[] = temp[1].split(",");
                                        for (int i = 0; i < tempp.length; i++) {
                                            for (int j = 0; j < user.size(); j++) {
                                                if (tempp[i].equals(user.get(j).getUsername())) {
                                                    to.add(j);
                                                    break;
                                                }
                                            }
                                        }
                                    }else{
                                        for (int i = 0; i < user.size(); i++) {
                                            if (temp[1].equals(user.get(i).getUsername())) {
                                                to.add(i);
                                                break;
                                            }
                                        }
                                    }
                                    System.out.println("Files : ");
                                    String input = sc.nextLine();
                                    if (input.indexOf(",") != -1) {
                                        String inpt[] = input.split(",");
                                        ArrayList<Files> zip = new ArrayList<>();
                                        for (int i = 0; i < inpt.length; i++) {
                                            zip.add(curr.getFile().get(Integer.parseInt(inpt[i])-1));
                                        }
                                        for (int i = 0; i < to.size(); i++) {
                                            user.get(to.get(i)).AddZip(zip, curr.getUsername()+user.get(to.get(i)).getCounter());
                                        }
                                    }else{
                                        for (int i = 0; i < to.size(); i++) {
                                            user.get(to.get(i)).AddFile(curr.getFile().get(Integer.parseInt(input)-1));
                                        }
                                    }
                                    for (int i = 0; i < to.size(); i++) {
                                        System.out.println("Files sent to " + user.get(to.get(i)).getUsername());
                                    }
                                }else if (temp[0].equals("extract")) {
                                    curr.Extract(temp[1]);
                                    System.out.println("Extract Success!");
                                }else{
                                    inp3 = Integer.parseInt(tmp);
                                }
                                
                                if (inp3 > 0 && inp3 <= curr.getFile().size()) {
                                    if (!((Deskripsi)curr.getFile().get(inp3-1)).getType().equals("zip")) {
                                        int inp4;
                                        Files now = curr.getFile().get(inp3-1);
                                        do {
                                            System.out.println(now.getNama_p() + "'s description");
                                            now.cetakDeskripsi((Deskripsi)now);
                                            System.out.println("1. Edit File");
                                            System.out.println("2. Delete File");
                                            System.out.println("0. Back");
                                            System.out.println(">> ");
                                            inp4 = Integer.parseInt(sc.nextLine());

                                            if (inp4 == 1) {
                                                int inp5;
                                                do {
                                                    System.out.println("edit " + now.getNama_p());
                                                    System.out.println("1. Edit Nama");
                                                    if (((Deskripsi)now).getType().equals("jpg")) {
                                                        System.out.println("2. Edit Color");
                                                    }else if (((Deskripsi)now).getType().equals("mp3")) {
                                                        System.out.println("2. Edit Duration");
                                                    }else if (((Deskripsi)now).getType().equals("mp4")) {
                                                        System.out.println("2. Edit Color");
                                                        System.out.println("3. Edit Duration");
                                                    }
                                                    System.out.println("0. Back");
                                                    inp5 = Integer.parseInt(sc.nextLine());

                                                    if (inp5 == 1) {
                                                        System.out.println("Input new Name : ");
                                                        String new_name = sc.nextLine();
                                                        curr.editFile(now, new_name);
                                                    }else{
                                                        if (((Deskripsi)now).getType().equals("jpg")) {
                                                            if (inp5 == 2) {
                                                                System.out.println("Input new Color : ");
                                                                String new_color = sc.nextLine();
                                                                curr.editFile(now, new_color);
                                                            }
                                                        }else if (((Deskripsi)now).getType().equals("mp3")) {
                                                            if (inp5 == 2) {
                                                                System.out.println("Input new Duration : ");
                                                                int new_duration = Integer.parseInt(sc.nextLine());
                                                                curr.editFile(now, new_duration);
                                                            }
                                                        }else if (((Deskripsi)now).getType().equals("mp4")) {
                                                            if (inp5 == 2) {
                                                                System.out.println("Input new Color : ");
                                                                String new_color = sc.nextLine();
                                                                curr.editFile(now, new_color);
                                                            }else if (inp5 == 3) {
                                                                System.out.println("Input new Duration : ");
                                                                int new_duration = Integer.parseInt(sc.nextLine());
                                                                curr.editFile(now, new_duration);
                                                            }
                                                        }
                                                    }
                                                } while (inp5 != 0);
                                            }else if (inp4 == 2) {
                                                curr.DeleteFile(now);
                                                break;
                                            }
                                        } while (inp4 != 0);
                                    }
                                }
                            } while (inp3 != 0);
                        }else if (inp2 == 2) {
                            int inp3, indx = -1;
                            do {
                                System.out.println("***Other Files***");
                                int c = 1;
                                for (int i = 0; i < user.size(); i++) {
                                    if (user.get(i) != curr) {
                                        System.out.println(c++ + ". " + user.get(i).getUsername());
                                    }else{
                                        indx = i;
                                    }
                                }
                                System.out.println("0. Back");
                                System.out.println(">> ");
                                inp3 = Integer.parseInt(sc.nextLine());
                                
                                User other = null;
                                if (inp3 > 0 && inp3 <= indx) {
                                    other = user.get(inp3-1);
                                }else if (inp3 > indx && inp3 < user.size()) {
                                    other = user.get(inp3);
                                }
                                
                                if (inp3 != 0) {
                                    int inp4 = -1;
                                    String tmp;
                                    do {
                                        System.out.println(other.getUsername() + "'s Files");
                                        other.cetakFile();
                                        System.out.println("0. Back");
                                        System.out.println(">> ");
                                        tmp = sc.nextLine();
                                        if (tmp.equals("download")) {
                                            System.out.println("Files : ");
                                            String input = sc.nextLine();
                                            if (input.indexOf(",") != -1) {
                                                String temp[] = input.split(",");
                                                ArrayList<Files> zip = new ArrayList<>();
                                                for (int i = 0; i < temp.length; i++) {
                                                    if (!((Deskripsi)other.getFile().get(Integer.parseInt(temp[i])-1)).getType().equals("zip")) {
                                                        zip.add(other.getFile().get(Integer.parseInt(temp[i])-1));
                                                    }
                                                }
                                                curr.AddZip(zip, other.getUsername()+curr.getCounter());
                                            }else{
                                                curr.AddFile(other.getFile().get(Integer.parseInt(input)));
                                            }
                                            System.out.println("Download Success!");
                                        }else{
                                            inp4 = Integer.parseInt(tmp);
                                            if (inp4 > 0 && inp4 <= other.getFile().size()) {
                                                int inp5;
                                                do {
                                                    Files now = other.getFile().get(inp4-1);
                                                    System.out.println(now.getNama_p() + "'s description");
                                                    now.cetakDeskripsi((Deskripsi)now);
                                                    System.out.println("1. Download");
                                                    System.out.println("0. Back");
                                                    inp5 = Integer.parseInt(sc.nextLine());

                                                    if (inp5 == 1) {
                                                        curr.AddFile(now);
                                                        System.out.println("Download Success!");
                                                    }
                                                } while (inp5 != 0);
                                            }
                                        }
                                    } while (inp4 != 0);
                                }
                            } while (inp3 != 0);
                        }
                    } while (inp2 != 0);
                }
            }
        } while (inp != 0);
    }
    
}
