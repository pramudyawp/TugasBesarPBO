package pbo.uas.meow.projek;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Mainan extends BaseModel{
    public Mainan() throws SQLException {
        super();
    }
    public int tambahMainan(String merk, String nama, String kemasan, int berat, int stok, int harga, String deskripsi) throws  SQLException{
        String query = "INSERT INTO mainan " +
                "(merk, nama, kemasan, berat, stok, harga, deskripsi)" +
                "VALUES (?,?,?,?,?,?,?)";

        PreparedStatement preparedstatement = connection.prepareStatement(query);
        preparedstatement.setString(1, merk);
        preparedstatement.setString(2, nama);
        preparedstatement.setString(3, kemasan);
        preparedstatement.setInt(4, berat);
        preparedstatement.setInt(5, stok);
        preparedstatement.setInt(6, harga);
        preparedstatement.setString(7, deskripsi);
        preparedstatement.executeUpdate();
        return 0;
    }
    public static ResultSet lihatMainan() throws SQLException{
        String query = "SELECT * FROM mainan";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }
    public void hapusMainan() throws SQLException{
        String query = "DELETE FROM mainan WHERE id_mainan = ? ";
        int hasil = 0;
        int id_mainan;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            Scanner input = new Scanner(System.in);
            System.out.println("\nMasukkan Id mainan yang akan dihapus : ");
            id_mainan = input.nextInt();

            preparedStatement.setInt(1, id_mainan);
            hasil = preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
    public void ubahMainan(int id_mainan, String merk, String nama, String kemasan,int berat, int stok, int harga, String deskripsi) throws  SQLException {
        String query = "UPDATE mainan SET merk = ?, nama = ?, kemasan = ?, berat = ?, stok = ?, harga = ?, deskripsi = ? WHERE id_mainan = ? ";

        PreparedStatement preparedstatement = connection.prepareStatement(query);
        preparedstatement.setString(1, merk);
        preparedstatement.setString(2, nama);
        preparedstatement.setString(3, kemasan);
        preparedstatement.setInt(4, berat);
        preparedstatement.setInt(5, stok);
        preparedstatement.setInt(6, harga);
        preparedstatement.setString(7, deskripsi);
        preparedstatement.setInt(8, id_mainan);

        preparedstatement.executeUpdate();
    }
    public ResultSet transaksiMainan(int id_mainan) throws SQLException{
        String query = "SELECT * from mainan WHERE id_mainan = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id_mainan);
        return preparedStatement.executeQuery();

    }
    public void ubahstokMakanan(int id_mainan, int stok) throws  SQLException {
        String query = "UPDATE mainan SET stok = ? WHERE id_mainan = ?";

        PreparedStatement preparedstatement = connection.prepareStatement(query);
        preparedstatement.setInt(1, stok);
        preparedstatement.setInt(2, id_mainan);

        preparedstatement.executeUpdate();
    }
}