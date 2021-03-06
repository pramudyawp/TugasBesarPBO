package pbo.uas.meow.projek;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Makanan extends BaseModel{
    public Makanan() throws SQLException{
        super();
    }
    public int tambahMakanan(String merk, String nama, String kemasan, int berat, int stok, int harga, String deskripsi) throws  SQLException{
        String query = "INSERT INTO makanan " +
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
    public static ResultSet lihatMakanan() throws SQLException{
        String query = "SELECT * FROM makanan";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }
    public void hapusMakanan() throws SQLException{
        String query = "DELETE FROM makanan WHERE id_makanan = ? ";
        int hasil = 0;
        int id_makanan;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            Scanner input = new Scanner(System.in);
            System.out.println("\nMasukkan Id makanan yang akan dihapus : ");
            id_makanan = input.nextInt();
            preparedStatement.setInt(1, id_makanan);
            hasil = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void ubahMakanan(int id_makanan, String merk, String nama, String kemasan,int berat, int stok, int harga, String deskripsi) throws  SQLException {
        String query = "UPDATE makanan SET merk = ?, nama = ?, kemasan = ?, berat = ?, stok = ?, harga = ?, deskripsi = ? WHERE id_makanan = ?";

        PreparedStatement preparedstatement = connection.prepareStatement(query);
        preparedstatement.setString(1, merk);
        preparedstatement.setString(2, nama);
        preparedstatement.setString(3, kemasan);
        preparedstatement.setInt(4, berat);
        preparedstatement.setInt(5, stok);
        preparedstatement.setInt(6, harga);
        preparedstatement.setString(7, deskripsi);
        preparedstatement.setInt(8, id_makanan);

        preparedstatement.executeUpdate();
    }
    public ResultSet transaksiMakanan(int id_makanan) throws SQLException{
        String query = "SELECT * from makanan WHERE id_makanan = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id_makanan);
        return preparedStatement.executeQuery();

    }
    public void ubahstokMakanan(int id_makanan, int stok) throws  SQLException {
        String query = "UPDATE makanan SET stok = ? WHERE id_makanan = ?";

        PreparedStatement preparedstatement = connection.prepareStatement(query);
        preparedstatement.setInt(1, stok);
        preparedstatement.setInt(2, id_makanan);

        preparedstatement.executeUpdate();
    }
}
