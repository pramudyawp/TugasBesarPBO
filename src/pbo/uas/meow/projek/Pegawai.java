package pbo.uas.meow.projek;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Pegawai extends BaseModel{
    public Pegawai() throws SQLException {
        super();
    }
    public int tambahPegawai(String namaPegawai, String jenisKelamin, String alamatPegawai, String kotaPegawai, String telpPegawai) throws  SQLException{
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
        return 0;
    }
    public static ResultSet lihatPegawai() throws SQLException{
        String query = "SELECT * FROM pegawai";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }
    public void hapusPegawai() throws SQLException{
        String query = "DELETE FROM pegawai WHERE id_pegawai = ?";
        int hasil = 0;
        int id_pegawai;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            Scanner input = new Scanner(System.in);
            System.out.println("\nMasukkan Id pegawai yang akan dihapus : ");
            id_pegawai = input.nextInt();
            preparedStatement.setInt(1, id_pegawai);
            hasil = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR - Gagal menghapus data pegawai");
        }
    }
    public void ubahPegawai(int id_pegawai, String namaPegawai, String jenisKelamin, String alamatPegawai, String kotaPegawai, String telpPegawai) throws  SQLException{
        String query = "UPDATE pegawai SET nama_pegawai = ?, jenis_kelamin = ?, alamat_pegawai = ?, kota_pegawai = ?, telp_pegawai = ? WHERE id_pegawai = ?";

        PreparedStatement preparedstatement = connection.prepareStatement(query);
        preparedstatement.setString(1, namaPegawai);
        preparedstatement.setString(2, jenisKelamin);
        preparedstatement.setString(3, alamatPegawai);
        preparedstatement.setString(4, kotaPegawai);
        preparedstatement.setString(5, telpPegawai);
        preparedstatement.setInt(6, id_pegawai);

        preparedstatement.executeUpdate();
    }
}
