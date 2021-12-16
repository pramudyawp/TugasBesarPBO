package pbo.uas.meow.projek;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Makanan extends BaseModel{
    public Makanan() throws SQLException{
        super();
    }
    public void tambahMakanan(int idMakanan, String merk, String nama, String kemasan,int berat, int stok, int harga, String deskripsi) throws  SQLException{
        String query = "INSERT INTO Makanan " +
                "(idMakanan, merk, nama, kemasan, berat, stok, harga, deskripsi) " +
                "VALUES (?,?,?,?,?,?,?,?)";

        PreparedStatement preparedstatement = connection.prepareStatement(query);
        preparedstatement.setInt(1, idMakanan);
        preparedstatement.setString(2, merk);
        preparedstatement.setString(3, nama);
        preparedstatement.setString(4, kemasan);
        preparedstatement.setInt(5, berat);
        preparedstatement.setInt(6, stok);
        preparedstatement.setInt(7, harga);
        preparedstatement.setString(8, deskripsi);
        preparedstatement.executeUpdate();
    }
    public ResultSet lihatMakanan() throws SQLException{
        String query = "SELECT * FROM Makanan";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }
    public void hapusMakanan(int idMakanan) throws SQLException{
        String query = "DELETE FROM Makanan WHERE idMakanan = ? ";
        Scanner input = new Scanner(System.in);
        System.out.println("\nMasukkan Id Makanan yang akan dihapus : ");
        idMakanan = input.nextInt();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idMakanan);
        preparedStatement.executeUpdate();
    }
    public void ubahMakanan(int idMakanan, String merk, String nama, String kemasan,int berat, int stok, int harga, String deskripsi) throws  SQLException {
        String query = "UPDATE Makanan SET " +
                "(idMakanan, merk, nama, kemasan, berat, stok, harga, deskripsi) " +
                "VALUES (?,?,?,?,?,?,?,?)";

        PreparedStatement preparedstatement = connection.prepareStatement(query);
        preparedstatement.setInt(1, idMakanan);
        preparedstatement.setString(2, merk);
        preparedstatement.setString(3, nama);
        preparedstatement.setString(4, kemasan);
        preparedstatement.setInt(5, berat);
        preparedstatement.setInt(6, stok);
        preparedstatement.setInt(7, harga);
        preparedstatement.setString(8, deskripsi);

        preparedstatement.executeUpdate();
    }
}
