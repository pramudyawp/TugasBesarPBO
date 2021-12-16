import pbo.uas.meow.projek.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Pegawai pegawai;
    static Makanan makanan;

    public static void main(String[] args) { menuUtama(); }
    public static void menuUtama(){
        System.out.println("========== TOKO KUCING - MEOW ==========");
        System.out.println("[1] Admin");
        System.out.println("[2] Pegawai (Kasir)");
        System.out.println("[0] Keluar");
            try {
                BaseModel model = new BaseModel();
                int pilihan;
                Scanner input = new Scanner(System.in);
                System.out.print("Masukkan pilihan : ");
                pilihan = input.nextInt();
                switch (pilihan){
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        if (loginAdmin()) {
                            menuAdmin();
                        }
                        System.out.println("Username/Password salah!");
                        break;
                    case 2:
                        break;
                }
            } catch (SQLException e)
            {
                System.out.println("gagal " + e.getLocalizedMessage());
                }
	    try {
            BaseModel model = new BaseModel();
            System.out.println("Koneksi berhasil!");
        } catch (SQLException terjadiError){
            System.out.println("Terjadi kesalahan : " + terjadiError.getLocalizedMessage());
        }
    }
    public static void menuAdmin(){
        System.out.println("\n ===== MENU ADMIN =====");
        System.out.println("[1] Kelola Pegawai");
        System.out.println("[2] Kelola Produk");
        System.out.println("[0] Kembali\n");

        try{
            Scanner input = new Scanner(System.in);
            Pegawai pegawai= new Pegawai();
            System.out.print("Pilih menu : ");
            int pilihan = input.nextInt();
            switch (pilihan){
                case 0:
                    menuUtama();
                    break;
                case 1:
                    System.out.println("[1] Lihat Data Pegawai");
                    System.out.println("[2] Tambah Data Pegawai");
                    System.out.println("[3] Ubah Data Pegawai");
                    System.out.println("[4] Hapus Data Pegawai");
                    System.out.println("[0] Keluar");
                    System.out.println("");

                    try{
                        Scanner input1 = new Scanner(System.in);
                        System.out.print("Pilih menu : ");
                        int pilihan1 = input1.nextInt();
                        switch (pilihan){
                            case 0:
                                menuAdmin();
                                break;
                            case 1:
                                //lihatpegawai
                            case 2:
                                System.out.println("Nama Pegawai : ");
                                String namaPegawai = input.nextLine();
                                System.out.println("Jenis Kelamin : ");
                                String jenisKelamin = input.nextLine();
                                System.out.println("Alamat : ");
                                String alamat = input.nextLine();
                                System.out.println("Kota : ");
                                String kota = input.nextLine();
                                System.out.println("Nomor Telp : ");
                                String noTelp = input.nextLine();
                                pegawai.tambahPegawai(namaPegawai, jenisKelamin, alamat, kota, noTelp);
                                break;

                                case 3:
                        }
                    } catch (Exception e){
                        System.out.println("Gagal " + e.getLocalizedMessage());
                    }


            }
        } catch (Exception e){
            System.out.println("Gagal " + e.getLocalizedMessage());
        }
    }
    public static boolean loginAdmin(){
        Scanner input = new Scanner(System.in);
        System.out.print("Username : ");
        String username = input.nextLine();
        System.out.print("Password : ");
        String password = input.nextLine();

        if (username.equals("admin") && password.equals("admin")){
            return true;
        }
        return false;
    }
}
