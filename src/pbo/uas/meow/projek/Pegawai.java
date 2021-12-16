package pbo.uas.meow.projek;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Pegawai extends BaseModel{
    public Pegawai() throws SQLException {
        super();
    }
    public void tambahPegawai(String namaPegawai, String jenisKelamin, String alamatPegawai, String kotaPegawai, String telpPegawai) throws  SQLException{
        String query = "INSERT INTO pegawai " +
                "(nama_pegawai, jenis_kelamin, alamat_pegawai, kota_pegawai, telp_pegawai) " +
                "VALUES (?,?,?,?,?)";

        PreparedStatement preparedstatement = connection.prepareStatement(query);
        preparedstatement.setString(1, namaPegawai);
        preparedstatement.setString(2, jenisKelamin);
        preparedstatement.setString(3, alamatPegawai);
        preparedstatement.setString(4, kotaPegawai);
        preparedstatement.setString(5, telpPegawai);
        preparedstatement.executeUpdate();
    }
    public ResultSet lihatPegawai() throws SQLException{
        String query = "SELECT * FROM pegawai";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }
    public void hapusPegawai(int idPegawai) throws SQLException{
        String query = "DELETE FROM pegawai WHERE idPegawai = ? ";
        Scanner input = new Scanner(System.in);
        System.out.println("\nMasukkan Id Makanan yang akan dihapus : ");
        idPegawai = input.nextInt();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idPegawai);
        preparedStatement.executeUpdate();
    }
    public void ubahPegawai(String namaPegawai, String jenisKelamin, String alamatPegawai, String kotaPegawai, String telpPegawai) throws  SQLException{
        String query = "UPDATE makanan SET " +
                "(namaPegawai, jenisKelamin, alamatPegawai, kotaPegawai, telpPegawai) " +
                "VALUES (?,?,?,?,?)";

        PreparedStatement preparedstatement = connection.prepareStatement(query);
        preparedstatement.setString(1, namaPegawai);
        preparedstatement.setString(2, jenisKelamin);
        preparedstatement.setString(3, alamatPegawai);
        preparedstatement.setString(4, kotaPegawai);
        preparedstatement.setString(5, telpPegawai);

        preparedstatement.executeUpdate();
    }
}
