package pbo.uas.meow.projek;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class transaksiMakanan extends BaseModel {
    public transaksiMakanan() throws SQLException {
        super();
    }

    String tanggalTransaksil;

    public int tambahTransaksiMakanan(String tanggalTransaksil, int harga, int total, int idMakanan) throws SQLException {

        String query = "INSERT INTO transaksiMakanan " +
                "(tanggalTransaksi, harga, total, idMakanan" +
                "VALUES (?,?,?,?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, tanggalTransaksil);
        preparedStatement.setInt(2, harga);
        preparedStatement.setInt(3, total);
        preparedStatement.setInt(4, idMakanan);
        return preparedStatement.executeUpdate();
    }
    public ResultSet lihatTransaksiMakanan() throws SQLException{
        String query = "SELECT * FROM transaksiMakanan";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }
    public void hapusTransaksiMakanan(int idTransaksiMakanan) throws SQLException{
        String query = "DELETE FROM transaksiMakanan WHERE idTransaksiMakanan = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idTransaksiMakanan);
        preparedStatement.executeUpdate();
    }
}

