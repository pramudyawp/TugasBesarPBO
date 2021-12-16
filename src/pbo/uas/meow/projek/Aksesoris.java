package pbo.uas.meow.projek;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Aksesoris extends BaseModel{
    public Aksesoris() throws SQLException {
        super();
    }
    public void tambahAksesoris(int idAksesoris, String merk, String nama, String kemasan,int berat, int stok, int harga, String deskripsi) throws  SQLException{
        String query = "INSERT INTO Aksesoris " +
                "(idAksesoris, merk, nama, kemasan, berat, stok, harga, deskripsi) " +
                "VALUES (?,?,?,?,?,?,?,?)";

        PreparedStatement preparedstatement = connection.prepareStatement(query);
        preparedstatement.setString(1, merk);
        preparedstatement.setString(2, nama);
        preparedstatement.setString(3, kemasan);
        preparedstatement.setInt(4, berat);
        preparedstatement.setInt(5, stok);
        preparedstatement.setInt(6, harga);
        preparedstatement.setString(7, deskripsi);
        preparedstatement.executeUpdate();
    }
    public ResultSet lihatAksesoris() throws SQLException{
        String query = "SELECT * FROM aksesoris";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }
    public void hapusAksesoris(int idAksesoris) throws SQLException{
        String query = "DELETE FROM aksesoris WHERE idAksesoris = ? ";
        Scanner input = new Scanner(System.in);
        System.out.println("\nMasukkan Id Aksesoris yang akan dihapus : ");
        idAksesoris = input.nextInt();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idAksesoris);
        preparedStatement.executeUpdate();
    }
    public void ubahAksesoris(String merk, String nama, String kemasan,int berat, int stok, int harga, String deskripsi) throws  SQLException {
        String query = "UPDATE aksesoris SET " +
                "(merk, nama, kemasan, berat, stok, harga, deskripsi) " +
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
    }
}
