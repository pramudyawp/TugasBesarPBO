package view;

import pbo.uas.meow.projek.BaseModel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Produk extends BaseModel {
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);

    static  void menuProduk() {
        System.out.println("\n========== MENU UTAMA ==========");
        System.out.println("[1] Lihat Produk");
        System.out.println("[2] Input Produk");
        System.out.println("[3] Edit Produk");
        System.out.println("[4] Hapus Produk");
        System.out.println("[0] Keluar\n");
        System.out.println("Masukkan pilihan anda : ");
        try {
            int pilihan = Integer.parseInt(input.readLine());

            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    //insertBuku();
                    break;
                case 2:
                    //showData();
                    break;
                case 3:
                    //updateBuku();
                    break;
                case 4:
                    //deleteBuku();
                    break;
                default:
                    System.out.println("Pilihan salah!");

            }
        } catch (Exception e) {
            e.printStackTrace();
    }


    }
    public Produk() throws SQLException {
        super();
    }
    public static void tambahProduk() throws  SQLException{
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Masukkan nama produk : ");
            String namaProduk = input.nextLine();

            System.out.println("Masukkan merk produk : ");
            String merk = input.nextLine();

            System.out.println("Masukkan kemasan : ");
            String kemasan = input.nextLine();

            System.out.println("Masukkan harga produk : ");
            String harga = input.nextLine();

            System.out.println("Masuukan stok produk : ");
            String stok = input.nextLine();

            System.out.println("Masukkan deskripsi produk : ");
            String deskripsi = input.nextLine();

        } catch (Exception terjadiError){
            System.out.println("Terjadi error : "+ terjadiError.getLocalizedMessage());
        }
    }
    public static void lihatProduk() throws SQLException{
        String query = "SELECT * FROM produk";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            System.out.println("DATA view.Produk");

            while (rs.next()){
                int idProduk = rs.getInt("idProduk");
                String merk = rs.getString("merk");
                String namaProduk = rs.getString("namaProduk");
                String kemasan = rs.getString("kemasan");
                int harga = rs.getInt("harga");
                int stok = rs.getInt("stok");
                String deskripsi = rs.getString("deskripsi");

                System.out.println(String.format("%d | %s ", idProduk, merk, namaProduk, kemasan, harga, stok, deskripsi));
            }
        } catch (SQLException terjadiError){
            System.out.println("Terjadi error : " + terjadiError.getLocalizedMessage());
        }
    }
}
