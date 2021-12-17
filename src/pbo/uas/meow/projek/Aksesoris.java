package pbo.uas.meow.projek;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Aksesoris extends BaseModel{
    public Aksesoris() throws SQLException {
        super();
    }
    public int tambahAksesoris(String merk, String nama, String kemasan, int berat, int stok, int harga, String deskripsi) throws  SQLException{
        String query = "INSERT INTO aksesoris " +
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
        return 0;
    }
    public static ResultSet lihatAksesoris() throws SQLException{
        String query = "SELECT * FROM aksesoris";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }
    public void hapusAksesoris() throws SQLException{
        String query = "DELETE FROM aksesoris WHERE id_aksesoris = ? ";
        int hasil = 0;
        int id_aksesoris;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            Scanner input = new Scanner(System.in);
            System.out.println("\nMasukkan Id aksesoris yang akan dihapus : ");
            id_aksesoris = input.nextInt();

            preparedStatement.setInt(1, id_aksesoris);
            hasil = preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
    public void ubahAksesoris(int id_aksesoris, String merk, String nama, String kemasan,int berat, int stok, int harga, String deskripsi) throws  SQLException {
        String query = "UPDATE aksesoris SET merk = ?, nama = ?, kemasan = ?, berat = ?, stok = ?, harga = ?, deskripsi = ? WHERE id_aksesoris = ? ";

        PreparedStatement preparedstatement = connection.prepareStatement(query);
        preparedstatement.setString(1, merk);
        preparedstatement.setString(2, nama);
        preparedstatement.setString(3, kemasan);
        preparedstatement.setInt(4, berat);
        preparedstatement.setInt(5, stok);
        preparedstatement.setInt(6, harga);
        preparedstatement.setString(7, deskripsi);
        preparedstatement.setInt(8, id_aksesoris);

        preparedstatement.executeUpdate();
    }
    public ResultSet transaksiAksesoris(int id_aksesoris) throws SQLException{
        String query = "SELECT * from aksesoris WHERE id_aksesoris = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id_aksesoris);
        return preparedStatement.executeQuery();

    }
    public void ubahstokAksesoris(int id_aksesoris, int stok) throws  SQLException {
        String query = "UPDATE aksesoris SET stok = ? WHERE id_aksesoris = ?";

        PreparedStatement preparedstatement = connection.prepareStatement(query);
        preparedstatement.setInt(1, stok);
        preparedstatement.setInt(2, id_aksesoris);

        preparedstatement.executeUpdate();
    }
}
