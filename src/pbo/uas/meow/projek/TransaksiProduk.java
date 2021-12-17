package pbo.uas.meow.projek;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TransaksiProduk extends BaseModel{
    public TransaksiProduk() throws SQLException{
        super();
    }
    public int tambahTransaksi(String tanggal, String nama_produk, int jumlah_produk, int harga, int total_harga) throws  SQLException{
        String query = "INSERT INTO transaksi_produk" +
                "(tanggal, nama_produk, jumlah_produk, harga, total_harga) " +
                "VALUES (?,?,?,?,?)";

        PreparedStatement preparedstatement = connection.prepareStatement(query);
        preparedstatement.setString(1, tanggal);
        preparedstatement.setString(2, nama_produk);
        preparedstatement.setInt(3, jumlah_produk);
        preparedstatement.setInt(4, harga);
        preparedstatement.setInt(5, total_harga);
        preparedstatement.executeUpdate();
        return 0;
    }
    public static ResultSet lihatTransaksi() throws SQLException{
        String query = "SELECT * FROM transaksi_produk";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }
    public void hapusTransaksi() throws SQLException{
        String query = "DELETE FROM transaksi_produk WHERE id_transaksi = ? ";
        int hasil = 0;
        int id_transaksi;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            Scanner input = new Scanner(System.in);
            System.out.println("\nMasukkan Id transaksi yang akan dihapus : ");
            id_transaksi = input.nextInt();
            preparedStatement.setInt(1, id_transaksi);
            hasil = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void ubahTransaksi(int id_transaksi, String tanggal, String nama_produk, int jumlah_produk, int harga, int total_harga) throws  SQLException {
        String query = "UPDATE transaksi_produk SET tanggal = ?, nama_produk = ?, jumlah_produk = ?, harga = ?, total_harga = ? WHERE id_transaksi = ? ";

        PreparedStatement preparedstatement = connection.prepareStatement(query);
        preparedstatement.setString(1, tanggal);
        preparedstatement.setString(2, nama_produk);
        preparedstatement.setInt(3, jumlah_produk);
        preparedstatement.setInt(4, harga);
        preparedstatement.setInt(5, total_harga);
        preparedstatement.setInt(6, id_transaksi);

        preparedstatement.executeUpdate();
    }
    public ResultSet totalTransaksiPelanggan() throws SQLException{
        String query = "SELECT SUM(total_harga) as total_transaksi from transaksi_produk";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        return preparedStatement.executeQuery();

    }
}
