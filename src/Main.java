import pbo.uas.meow.projek.*;

import pbo.uas.meow.projek.Pegawai;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {
    static Pegawai pegawai;
    static Makanan makanan;
    static Aksesoris aksesoris;
    static Mainan mainan;
    static TransaksiProduk transaksiProduk;

    public static void main(String[] args) throws SQLException {
        menuUtama();
    }
    public static void menuUtama() {
        out.println("========== TOKO KUCING - MEOW ==========");
        out.println("[1] Admin");
        out.println("[2] Pegawai (Kasir)");
        out.println("[0] Keluar");
        out.print("\nMasukkan pilihan aktor : ");
        try {
            //admim
            //admin
            int pilihan;
            Scanner input = new Scanner(in);
            pilihan = input.nextInt();
            switch (pilihan) {
                case 0:
                    exit(0);
                    break;
                case 1:
                    if (loginAdmin()) {
                        menuAdmin();
                    }
                    break;
                case 2:
                    menuPegawai();
                    break;
            }
        } catch (Exception e) {
            out.println("Gagal memproses akibat : " + e.getLocalizedMessage());
        }
        {
        }
    }

    //ADMIN
    public static void menuAdmin() {
        out.println("\n ===== MENU ADMIN =====");
        out.println("[1] Kelola Pegawai");
        out.println("[2] Kelola Produk");
        out.println("[3] Laporan Transaksi");
        out.println("[4] Logout");
        out.println("[0] Kembali ke menu utama\n");
        out.print("Pilih menu : ");

        try {
            Scanner input = new Scanner(in);
            Pegawai pegawai = new Pegawai();
            int pilihan = input.nextInt();
            switch (pilihan) {
                case 0 -> menuUtama();
                case 1 -> {
                    fungsiMuterAdminPegawai();
                    try {
                        pilihan = input.nextInt();
                        switch (pilihan) {
                            case 0 -> menuAdmin();
                            case 1 -> lihatdataPegawai();
                            case 2 -> {
                                tambahdataPegawai();
                                menuAdmin();
                            }
                            case 3 -> {
                                ubahdataPegawai();
                                menuAdmin();
                            }
                            case 4 -> {
                                hapusdataPegawai();
                                menuAdmin();
                            }
                            default -> out.println("Pilihan salah!");
                        }
                    } catch (SQLException e) {
                        out.println("Gagal memproses akibat : " + e.getLocalizedMessage());
                    }
                }
                case 2 -> subMenuAdminProdukfungsi();
                case 3 -> {
                    lihatDataTransaksi();
                    menuAdmin();
                    }
                case 4 -> {
                    System.out.println("Program berhenti...");
                    System.exit(4);
                }
            }
        } catch (java.lang.Exception e) {
            out.println("Gagal memproses akibat : " + e.getLocalizedMessage());
        }
    }
    public static void subMenuAdminProdukfungsi(){
        subMenuAdminproduk();
        try {
            Scanner input = new Scanner(in);
            int pilihan = input.nextInt();
            switch (pilihan) {
                case 0 -> menuAdmin();
                case 1 -> fungsiMuterMakanan();
                case 2 -> fungsiMuterAksesoris();
                case 3 -> fungsiMuterMainan();
                default -> out.println("Pilihan salah!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void subMenuAdminpegawai() {
        out.println("\n===== SUB MENU ADMIN =====");
        out.println("===== KELOLA PEGAWAI =====");
        out.println("[1] Lihat Data Pegawai");
        out.println("[2] Tambah Data Pegawai");
        out.println("[3] Ubah Data Pegawai");
        out.println("[4] Hapus Data Pegawai");
        out.println("[0] Kembali\n");
        out.print("Pilih menu : ");
    }
    public static void fungsiMuterAdminPegawai(){
        subMenuAdminpegawai();
        try {
            Scanner input = new Scanner(in);
            int pilihan = input.nextInt();
            switch (pilihan) {
                case 0 -> subMenuAdminpegawai();
                case 1 -> {
                    lihatdataPegawai();
                    fungsiMuterAdminPegawai();
                    subMenuAdminpegawai();
                }
                case 2 -> {
                    lihatdataPegawai();
                    tambahdataPegawai();
                    fungsiMuterAdminPegawai();
                }
                case 3 -> {
                    lihatdataPegawai();
                    ubahdataPegawai();
                    fungsiMuterAdminPegawai();
                }
                case 4 -> {
                    lihatdataPegawai();
                    hapusdataPegawai();
                    fungsiMuterAdminPegawai();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean loginAdmin() {
        Scanner input = new Scanner(in);
        out.print("Username : ");
        String username = input.nextLine();
        out.print("Password : ");
        String password = input.nextLine();

        return username.equals("admin") && password.equals("admin");
    }

    //PEGAWAI
    public static void menuPegawai() {
        out.println("\n ===== MENU PEGAWAI ===== ");
        out.println("[1] Lihat Data Produk");
        out.println("[2] Transaksi");
        out.println("[3] Logout");
        out.println("[0] Kembali ke menu utama\n");
        out.print("Pilih menu : ");

        try {
            Scanner input = new Scanner(in);
            int pilihan = input.nextInt();
            switch (pilihan) {
                case 0 -> menuUtama();
                case 1 -> fungsiMuterPegawaiLihatProduk();
                case 2 -> fungsiMuterPegawaiTransaksi();
                case 3 -> {
                    out.println("Program keluar...");
                    System.exit(3);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void subMenuPegawaiLihatProduk(){
        out.println("\n===== SUB MENU PEGAWAI =====");
        out.println("========= DATA PRODUK ========");
        out.println("[1] Lihat Data Makanan");
        out.println("[2] Lihat Data Aksesoris");
        out.println("[3] Lihat Data Mainan");
        out.println("[0] Kembali\n");
        out.print("Pilih menu : ");
    }
    public static void subMenuPegawaiTransaksi(){
        out.println("\n===== SUB MENU PEGAWAI =====");
        out.println("===== DATA PRODUK =====");
        out.println("[1] Lihat Laporan Transaksi");
        out.println("[2] Tambah Data Transaksi");
        out.println("[3] Ubah Data Transaksi");
        out.println("[4] Hapus Data Transaksi");
        out.println("\nMENU HITUNG TRANSAKSI");
        out.println("[5] Hitung Pembelian Makanan Pelanggan");
        out.println("[6] Hitung Pembelian Aksesoris Pelanggan");
        out.println("[7] Hitung Pembelian Mainan Pelanggan");
        out.println("[8] Hitung Total Pembayaran");
        out.println("[0] Kembali\n");
        out.print("Pilih menu : ");
    }
    public static void fungsiMuterPegawaiTransaksi(){
        subMenuPegawaiTransaksi();
        try {
            TransaksiProduk transaksiProduk = new TransaksiProduk();
            Scanner input = new Scanner(in);
            int pilihan = input.nextInt();
            switch (pilihan) {
                case 0 -> menuPegawai();
                case 1 -> {
                    lihatDataTransaksi();
                    menuPegawai();
                }
                case 2 -> {
                    tambahDataTransaksi();
                    menuPegawai();
                }
                case 3 -> {
                    lihatDataTransaksi();
                    ubahDataTransaksi();
                    menuPegawai();
                }
                case 4 -> {
                    lihatDataTransaksi();
                    hapusDataTransaksi();
                    menuPegawai();
                }
                case 5 -> {
                    lihatdataMakanan();
                    transaksiMakananPelanggan();
                    fungsiMuterPegawaiTransaksi();
                }
                case 6 -> {
                    lihatdataAksesoris();
                    transaksiAksesorisPelanggan();
                    fungsiMuterPegawaiTransaksi();
                }
                case 7 -> {
                    lihatDataMainan();
                    transaksiMainanPelanggan();
                    fungsiMuterPegawaiTransaksi();
                }
                case 8 -> {
                    lihatDataTransaksi();
                    totalbeli();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void fungsiMuterPegawaiLihatProduk() throws SQLException {
        subMenuPegawaiLihatProduk();
        try{
            Makanan makanan = new Makanan();
            Aksesoris aksesoris = new Aksesoris();
            Mainan mainan = new Mainan();
            Scanner input = new Scanner(in);
            int pilihan = input.nextInt();
            switch (pilihan) {
                case 0 -> menuUtama();
                case 1 -> {
                    lihatdataMakanan();
                    fungsiMuterPegawaiLihatProduk();
                }
                case 2 -> {
                    lihatdataAksesoris();
                    fungsiMuterPegawaiLihatProduk();
                }
                case 3 -> {
                    lihatDataMainan();
                    fungsiMuterPegawaiLihatProduk();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //PRODUK
    public static void fungsiMuterMakanan() throws SQLException {
        submenuAdminprodukMakanan();
        try {
            Scanner input = new Scanner(in);
            int pilihan = input.nextInt();
            switch (pilihan) {
                case 0 -> subMenuAdminProdukfungsi();
                case 1 -> {
                    lihatdataMakanan();
                    fungsiMuterMakanan();
                }
                case 2 -> {
                    lihatdataMakanan();
                    tambahdataMakanan();
                    fungsiMuterMakanan();
                }
                case 3 -> {
                    lihatdataMakanan();
                    ubahdataMakanan();
                    fungsiMuterMakanan();
                }
                case 4 -> {
                    lihatdataMakanan();
                    hapusdataMakanan();
                    fungsiMuterMakanan();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void fungsiMuterAksesoris() throws SQLException {
        submenuAdminprodukAksesoris();
        try {
            Scanner input = new Scanner(in);
            int pilihan = input.nextInt();
            switch (pilihan) {
                case 0 -> subMenuAdminProdukfungsi();
                case 1 -> {
                    lihatdataAksesoris();
                    fungsiMuterAksesoris();
                }
                case 2 -> {
                    lihatdataAksesoris();
                    tambahdataAksesoris();
                    fungsiMuterAksesoris();
                }
                case 3 -> {
                    lihatdataAksesoris();
                    ubahdataAksesoris();
                    fungsiMuterAksesoris();
                }
                case 4 -> {
                    lihatdataAksesoris();
                    hapusdataAksesoris();
                    fungsiMuterAksesoris();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void fungsiMuterMainan() {
        submenuAdminprodukMainan();
        try {
            Scanner input = new Scanner(in);
            int pilihan = input.nextInt();
            switch (pilihan) {
                case 0 -> subMenuAdminProdukfungsi();
                case 1 -> {
                    lihatDataMainan();
                    fungsiMuterMainan();
                }
                case 2 -> {
                    lihatDataMainan();
                    tambahDataMainan();
                    fungsiMuterMainan();
                }
                case 3 -> {
                    lihatDataMainan();
                    ubahDataMainan();
                    fungsiMuterMainan();
                }
                case 4 -> {
                    lihatDataMainan();
                    hapusDataMainan();
                    fungsiMuterMainan();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void subMenuAdminproduk() {
        out.println("\n===== SUB MENU ADMIN =====");
        out.println("===== KELOLA PRODUK KUCING =====");
        out.println("[1] Data Makanan");
        out.println("[2] Data Aksesoris");
        out.println("[3] Data Mainan");
        out.println("[0] Kembali\n");
        out.print("Pilih menu : ");
    }
    public static void submenuAdminprodukMakanan(){
        out.println("\n===== KELOLA PRODUK =====");
        out.println("===== DATA MAKANAN =====");
        out.println("[1] Lihat Data Makanan");
        out.println("[2] Tambah Data Makanan");
        out.println("[3] Ubah Data Makanan");
        out.println("[4] Hapus Data Makanan");
        out.println("[0] Kembali\n");
        out.print("Pilih menu : ");
    }
    public static void submenuAdminprodukAksesoris(){
        out.println("\n===== KELOLA PRODUK =====");
        out.println("===== DATA AKSESORIS =====");
        out.println("[1] Lihat Data Aksesoris");
        out.println("[2] Tambah Data Aksesoris");
        out.println("[3] Ubah Data Aksesoris");
        out.println("[4] Hapus Data Aksesoris");
        out.println("[0] Kembali\n");
        out.print("Pilih menu : ");
    }
    public static void submenuAdminprodukMainan(){
        out.println("\n===== KELOLA PRODUK =====");
        out.println("===== DATA MAINAN =====");
        out.println("[1] Lihat Data Mainan");
        out.println("[2] Tambah Data Mainan");
        out.println("[3] Ubah Data Mainan");
        out.println("[4] Hapus Data Mainan");
        out.println("[0] Kembali\n");
        out.print("Pilih menu : ");
    }

    //FUNGSI CRUD
    private static void lihatdataPegawai() throws SQLException {
        ResultSet statement = Pegawai.lihatPegawai();
        out.println("+-------------------------------------------- DATA PEGAWAI -----------------------------------------------+");
        out.println("===========================================================================================================");
        out.printf("%-4s%-20s%-20s%-30s%-20s%-20s\n", "ID", "NAMA PEGAWAI", "JENIS KELAMIN","ALAMAT","KOTA","NO.TELP");
        out.println("===========================================================================================================");

        while (statement.next()) {
            out.printf("%-4d%-20s%-20s%-30s%-20s%-20s\n", statement.getInt("id_pegawai"),statement.getString("nama_pegawai"),statement.getString("jenis_kelamin"),statement.getString("alamat_pegawai"),statement.getString("kota_pegawai"), statement.getString("telp_pegawai"));
        }
        out.println("===========================================================================================================");
    }
    private static void tambahdataPegawai() throws Exception {
        try {
            Scanner input = new Scanner(in);
            Pegawai Pegawai = new Pegawai();
            out.println("Nama pegawai : ");
            String nama = input.nextLine();
            out.println("Jenis kelamin : ");
            String jenisKelamin = input.nextLine();
            out.println("Alamat : ");
            String alamat = input.nextLine();
            out.println("Kota/Kabupaten : ");
            String kota = input.nextLine();
            out.println("No. Telp : ");
            String noTelp = input.nextLine();

            //CLS
            lihatdataPegawai();

            if (nama.isEmpty()) {
                throw new Exception("ERROR - Nama wajib diisi");
            } else if (jenisKelamin.isEmpty()) {
                throw new Exception("ERROR - Jenis kelamin wajid diisi");
            } else if (alamat.isEmpty()) {
                throw new Exception("ERROR - Alamat wajib diisi");
            } else if (kota.isEmpty()) {
                throw new Exception("ERROR - Kota/Kabupaten wajib diisi");
            } else if (noTelp.isEmpty()) {
                throw new Exception("ERROR - No.Telp wajib diisi");
            }

            int hasil = Pegawai.tambahPegawai(nama, jenisKelamin, alamat, kota, noTelp);
            if (hasil > 0) {
                out.println("Data berhasil ditambahkan!" + hasil);
            }
        } catch (SQLException e) {
            out.println("Gagal akibat : " + e.getLocalizedMessage());
        }
    }
    public static void ubahdataPegawai() throws SQLException {
        Scanner input = new Scanner(in);
        out.print("Masukkan ID Pegawai yang akan diubah : \n");
        int id_pegawai = Integer.parseInt(input.nextLine());

        Pegawai pegawai = new Pegawai();
        out.println("Nama pegawai : ");
        String nama = input.nextLine();

        out.println("Jenis kelamin : ");
        String jenisKelamin = input.nextLine();

        out.println("Alamat : ");
        String alamat = input.nextLine();

        out.println("Kota/Kabupaten : ");
        String kota = input.nextLine();
        out.println("No. Telp : ");
        String noTelp = input.nextLine();

        pegawai.ubahPegawai(id_pegawai, nama, jenisKelamin, alamat, kota, noTelp);
        out.println("Data pegawai berhasil diubah!");
        lihatdataPegawai();

    }
    public static void hapusdataPegawai() throws SQLException {
        Pegawai pegawai = new Pegawai();
        pegawai.hapusPegawai();
    }

    //MAKANAN
    private static void lihatdataMakanan() throws SQLException {
        try {
            ResultSet statement = Makanan.lihatMakanan();
            out.println("+--------------------------------------------- DATA MAKANAN KUCING --------------------------------------------------------+");
            out.println("============================================================================================================================");
            out.printf("%-4s%-20s%-30s%-15s%-10s%-10s%-15s%-20s\n", "ID", "MERK", "KATEGORI UMUR","KEMASAN","BERAT","STOK","HARGA","DESKRIPSI");
            out.println("============================================================================================================================");

            while (statement.next()) {
                out.printf("%-4d%-20s%-30s%-15s%-10s%-10sRp%-15d%-20s\n", statement.getInt("id_makanan"),statement.getString("merk"),statement.getString("nama"),statement.getString("kemasan"),Integer.toString(statement.getInt("berat")) + " KG",Integer.toString(statement.getInt("stok")) + " Pcs",statement.getInt("harga"),statement.getString("deskripsi"));
            }
            out.println("============================================================================================================================");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void tambahdataMakanan() throws Exception {
        try {
            Scanner input = new Scanner(in);
            Makanan makanan = new Makanan();

            out.print("Merk : ");
            String merk = input.nextLine();
            out.print("Kategori umur : ");
            String nama = input.nextLine();
            out.print("Kemasan : ");
            String kemasan = input.nextLine();
            out.print("Berat : ");
            int berat = Integer.parseInt(input.nextLine());
            out.print("Stok : ");
            int stok = Integer.parseInt(input.nextLine());
            out.print("Harga : ");
            int harga = Integer.parseInt(input.nextLine());
            out.print("Deskripsi : ");
            String deskripsi = input.nextLine();

            int hasil = makanan.tambahMakanan(merk, nama, kemasan, berat, stok, harga, deskripsi);
            if (hasil > 0) {
                out.println("Data berhasil ditambahkan!" + hasil);
                }
            } catch(SQLException e){
                out.println("Gagal akibat : " + e.getLocalizedMessage());
            }
    }
    public static void hapusdataMakanan() throws SQLException{
        Makanan makanan = new Makanan();
        makanan.hapusMakanan();
    }
    public static void ubahdataMakanan() throws SQLException{
        Scanner input = new Scanner(in);
        out.print("Masukkan ID makanan yang akan diubah : ");
        int id_makanan = Integer.parseInt(input.nextLine());

        Makanan makanan = new Makanan();
        out.print("Merk : ");
        String merk = input.nextLine();
        out.print("Kategori umur: ");
        String nama = input.nextLine();
        out.print("Kemasan : ");
        String kemasan = input.nextLine();
        out.print("Berat [Kg] : ");
        int berat = Integer.parseInt(input.nextLine());
        out.print("Stok : ");
        int stok = Integer.parseInt(input.nextLine());
        out.print("Harga : ");
        int harga = Integer.parseInt(input.nextLine());
        out.print("Deskripsi : ");
        String deskripsi = input.nextLine();

        makanan.ubahMakanan(id_makanan, merk, nama, kemasan, berat, stok, harga, deskripsi);
        out.println("Data makanan berhasil diubah!");
        lihatdataMakanan();
    }
    public static void transaksiMakananPelanggan() throws SQLException{
        int totalharga = 0;
        int totalstok = 0;
        String nama_makanan = "";
        Makanan makanan = new Makanan();
        Scanner input = new Scanner(System.in);
        out.print("Masukkan id makanan : ");
        int id_makanan = Integer.parseInt(input.nextLine());
        out.print("Masukkan jumlah makanan yang akan dibeli : ");
        int jumlah_beli_makanan = Integer.parseInt(input.nextLine());

        ResultSet statement = makanan.transaksiMakanan(id_makanan);
        while (statement.next()) {
            totalharga = statement.getInt("harga");
            totalstok = statement.getInt("stok");
            nama_makanan = statement.getString("nama");
        }
        int sisa_stok_makanan = totalstok - jumlah_beli_makanan;
        int total_harga_makanan = jumlah_beli_makanan * totalharga;
        makanan.ubahstokMakanan(id_makanan, sisa_stok_makanan);

        out.print("Masukkan tanggal DD/MM/YYYY : ");
        String tanggal = input.nextLine();
        TransaksiProduk transaksiProduk = new TransaksiProduk();
        transaksiProduk.tambahTransaksi(tanggal,nama_makanan,jumlah_beli_makanan,totalharga, total_harga_makanan);
        out.println("Tambah transaksi makanan berhasil!");
    }

    //AKSESORIS
    private static void lihatdataAksesoris() throws SQLException {
        try {
            ResultSet statement = Aksesoris.lihatAksesoris();
            out.println("+-------------------------------------------- DATA AKSESORIS KUCING -------------------------------------------------------+");
            out.println("============================================================================================================================");
            out.printf("%-4s%-20s%-30s%-15s%-10s%-10s%-15s%-20s\n", "ID", "MERK", "NAMA","KEMASAN","BERAT","STOK","HARGA","DESKRIPSI");
            out.println("============================================================================================================================");

            while (statement.next()) {
                out.printf("%-4d%-20s%-30s%-15s%-10s%-10sRp%-15d%-20s\n", statement.getInt("id_aksesoris"),statement.getString("merk"),statement.getString("nama"),statement.getString("kemasan"),Integer.toString(statement.getInt("berat")) + " KG",Integer.toString(statement.getInt("stok")) + " Pcs",statement.getInt("harga"),statement.getString("deskripsi"));
            }
            out.println("============================================================================================================================");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void tambahdataAksesoris() throws Exception {
        try {
            Scanner input = new Scanner(in);
            Aksesoris aksesoris = new Aksesoris();

            out.print("Merk : ");
            String merk = input.nextLine();
            out.print("Nama aksesoris : ");
            String nama = input.nextLine();
            out.print("Kemasan : ");
            String kemasan = input.nextLine();
            out.print("Berat : ");
            int berat = Integer.parseInt(input.nextLine());
            out.print("Stok : ");
            int stok = Integer.parseInt(input.nextLine());
            out.print("Harga : ");
            int harga = Integer.parseInt(input.nextLine());
            out.print("Deskripsi : ");
            String deskripsi = input.nextLine();

            int hasil = aksesoris.tambahAksesoris(merk, nama, kemasan, berat, stok, harga, deskripsi);
            if (hasil > 0) {
                out.println("Data berhasil ditambahkan!" + hasil);
            }
        } catch(SQLException e){
            out.println("Gagal akibat : " + e.getLocalizedMessage());
        }
    }
    public static void hapusdataAksesoris() throws SQLException{
        Aksesoris aksesoris = new Aksesoris();
        aksesoris.hapusAksesoris();
    }
    public static void ubahdataAksesoris() throws SQLException{
        Scanner input = new Scanner(in);
        lihatdataAksesoris();
        out.print("Masukkan ID makanan yang akan diubah : ");
        int id_Aksesoris = Integer.parseInt(input.nextLine());

        Aksesoris aksesoris = new Aksesoris();
        out.print("Merk : ");
        String merk = input.nextLine();

        out.print("Nama aksesoris baru : ");
        String nama = input.nextLine();

        out.print("Kemasan : ");
        String kemasan = input.nextLine();

        out.print("Berat [Kg] : ");
        int berat = Integer.parseInt(input.nextLine());

        out.print("Stok : ");
        int stok = Integer.parseInt(input.nextLine());

        out.print("Harga : ");
        int harga = Integer.parseInt(input.nextLine());

        out.print("Deskripsi : ");
        String deskripsi = input.nextLine();

        aksesoris.ubahAksesoris(id_Aksesoris, merk, nama, kemasan, berat, stok, harga, deskripsi);
        out.println("Data aksesoris berhasil diubah!");
    }
    public static void transaksiAksesorisPelanggan() throws SQLException{
        int totalharga = 0;
        int totalstok = 0;
        String nama_aksesoris = "";
        Aksesoris aksesoris = new Aksesoris();
        Scanner input = new Scanner(System.in);
        out.print("Masukkan id aksesoris : ");
        int id_aksesoris = Integer.parseInt(input.nextLine());
        out.print("Masukkan jumlah aksesoris yang akan dibeli : ");
        int jumlah_beli_aksesoris = Integer.parseInt(input.nextLine());

        ResultSet statement = aksesoris.transaksiAksesoris(id_aksesoris);
        while (statement.next()) {
            totalharga = statement.getInt("harga");
            totalstok = statement.getInt("stok");
            nama_aksesoris = statement.getString("nama");
        }
        int sisa_stok_aksesoris = totalstok - jumlah_beli_aksesoris;
        int total_harga_aksesoris = jumlah_beli_aksesoris * totalharga;
        aksesoris.ubahstokAksesoris(id_aksesoris, sisa_stok_aksesoris);

        out.print("Masukkan tanggal DD/MM/YYYY : ");
        String tanggal = input.nextLine();
        TransaksiProduk transaksiProduk = new TransaksiProduk();
        transaksiProduk.tambahTransaksi(tanggal,nama_aksesoris,jumlah_beli_aksesoris,totalharga, total_harga_aksesoris);
        out.println("Tambah transaksi aksesoris berhasil!");
    }


    //MAINAN
    private static void lihatDataMainan() throws SQLException {
        try {
            ResultSet statement = Mainan.lihatMainan();
            out.println("+-------------------------------------------- DATA MAINAN KUCING -------------------------------------------------------+");
            out.println("============================================================================================================================");
            out.printf("%-4s%-20s%-30s%-15s%-10s%-10s%-15s%-20s\n", "ID", "MERK", "NAMA","KEMASAN","BERAT","STOK","HARGA","DESKRIPSI");
            out.println("============================================================================================================================");

            while (statement.next()) {
                out.printf("%-4d%-20s%-30s%-15s%-10s%-10sRp%-15d%-20s\n", statement.getInt("id_mainan"),statement.getString("merk"),statement.getString("nama"),statement.getString("kemasan"),Integer.toString(statement.getInt("berat")) + " KG", Integer.toString(statement.getInt("stok")) + " Pcs",statement.getInt("harga"),statement.getString("deskripsi"));
            }
            out.println("============================================================================================================================");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void tambahDataMainan() throws Exception {
        try {
            Scanner input = new Scanner(in);
            Mainan mainan = new Mainan();

            out.print("Merk : ");
            String merk = input.nextLine();
            out.print("Nama mainan : ");
            String nama = input.nextLine();
            out.print("Kemasan : ");
            String kemasan = input.nextLine();

            out.print("Berat [KG] : ");
            int berat = Integer.parseInt(input.nextLine());
            out.print("Stok : ");
            int stok = Integer.parseInt(input.nextLine());
            out.print("Harga : ");
            int harga = Integer.parseInt(input.nextLine());
            out.print("Deskripsi : ");
            String deskripsi = input.nextLine();

            int hasil = mainan.tambahMainan(merk, nama, kemasan, berat, stok, harga, deskripsi);
            if (hasil > 0) {
                out.println("Data mainan berhasil ditambahkan!" + hasil);
            }
        } catch(SQLException e){
            out.println("Gagal akibat : " + e.getLocalizedMessage());
        }
    }
    public static void hapusDataMainan() throws SQLException{
        Mainan mainan = new Mainan();
        mainan.hapusMainan();
    }
    public static void ubahDataMainan() throws SQLException{
        Scanner input = new Scanner(in);
        lihatDataMainan();
        out.print("Masukkan ID mainan lain yang akan diubah : ");
        int id_mainan = Integer.parseInt(input.nextLine());
        Mainan mainan = new Mainan();
        out.print("Merk : ");
        String merk = input.nextLine();
        out.print("Nama mainan lain baru : ");
        String nama = input.nextLine();
        out.print("Kemasan: ");
        String kemasan = input.nextLine();
        out.print("Berat: ");
        int berat = Integer.parseInt(input.nextLine());
        out.print("Stok : ");
        int stok = Integer.parseInt(input.nextLine());
        out.print("Harga : ");
        int harga = Integer.parseInt(input.nextLine());
        out.print("Deskripsi : ");
        String deskripsi = input.nextLine();

        mainan.ubahMainan(id_mainan, merk, nama, kemasan, berat, stok, harga, deskripsi);
        out.println("Data aksesoris berhasil diubah!");
    }
    public static void transaksiMainanPelanggan() throws SQLException{
        int totalharga = 0;
        int totalstok = 0;
        String nama_mainan = "";
        Mainan mainan = new Mainan();
        Scanner input = new Scanner(System.in);
        out.print("Masukkan id mainan : ");
        int id_mainan = Integer.parseInt(input.nextLine());
        out.print("Masukkan jumlah mainan yang akan dibeli : ");
        int jumlah_beli_mainan = Integer.parseInt(input.nextLine());

        ResultSet statement = mainan.transaksiMainan(id_mainan);
        while (statement.next()) {
            totalharga = statement.getInt("harga");
            totalstok = statement.getInt("stok");
            nama_mainan = statement.getString("nama");
        }
        int sisa_stok_mainan = totalstok - jumlah_beli_mainan;
        int total_harga_mainan = jumlah_beli_mainan * totalharga;
        mainan.ubahstokMakanan(id_mainan, sisa_stok_mainan);

        out.print("Masukkan tanggal DD/MM/YYYY : ");
        String tanggal = input.nextLine();
        TransaksiProduk transaksiProduk = new TransaksiProduk();
        transaksiProduk.tambahTransaksi(tanggal,nama_mainan,jumlah_beli_mainan,totalharga, total_harga_mainan);
        out.print("Tambah transaksi mainan berhasil!");
    }

    //TRANSAKSI
    private static void lihatDataTransaksi() throws SQLException {
        try {
            ResultSet statement = TransaksiProduk.lihatTransaksi();
            out.println("======================================= DATA TRANSAKSI =============================================");
            out.println("====================================================================================================");
            out.printf("%-4s%-20s%-20s%-20s%-20s%-20s\n", "ID", "TANGGAL", "NAMA PRODUK","JUMLAH PRODUK","HARGA","TOTAL HARGA");
            out.println("====================================================================================================");

            while (statement.next()) {
                out.printf("%-4d%-20s%-20s%-20d%-20d%-20d\n", statement.getInt("id_transaksi"),statement.getString("tanggal"),statement.getString("nama_produk"),statement.getInt("jumlah_produk"),statement.getInt("harga"),statement.getInt("total_harga"));
            }
            out.println("====================================================================================================");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void tambahDataTransaksi() {
        try {
            Scanner input = new Scanner(in);
            TransaksiProduk transaksiProduk = new TransaksiProduk();

            out.print("Tanggal DD-MM-YYYY : ");
            String tanggal = input.nextLine();
            out.print("Nama Produk : ");
            String nama = input.nextLine();
            out.print("Jumlah Produk : ");
            int jumlah = Integer.parseInt(input.nextLine());
            out.print("Harga : ");
            int harga = Integer.parseInt(input.nextLine());
            out.print("Total Harga : ");
            int total_harga = Integer.parseInt(input.nextLine());

            int hasil = transaksiProduk.tambahTransaksi(tanggal, nama, jumlah, harga, total_harga);
            if (hasil > 0) {
                out.println("Data transaksi berhasil ditambahkan!" + hasil);
            }
        } catch(SQLException e){
            out.println("Gagal akibat : " + e.getLocalizedMessage());
        }
    }
    public static void hapusDataTransaksi() throws SQLException{
        TransaksiProduk transaksiProduk = new TransaksiProduk();
        transaksiProduk.hapusTransaksi();
    }
    public static void ubahDataTransaksi() throws SQLException{
        Scanner input = new Scanner(in);
        lihatDataTransaksi();
        out.print("Masukkan ID transaksi lain yang akan diubah : ");
        int id_transaksi = Integer.parseInt(input.nextLine());

        TransaksiProduk transaksiProduk = new TransaksiProduk();
        out.print("Tanggal DD-MM-YYYY : ");
        String tanggal = input.nextLine();
        out.print("Nama Produk : ");
        String nama = input.nextLine();
        out.print("Jumlah Produk : ");
        int jumlah = Integer.parseInt(input.nextLine());
        out.print("Harga : ");
        int harga = Integer.parseInt(input.nextLine());
        out.print("Total Harga : ");
        int total_harga = Integer.parseInt(input.nextLine());

        transaksiProduk.ubahTransaksi(id_transaksi, tanggal, nama, jumlah, harga, total_harga);
        out.println("Data transaksi berhasil diubah!");
    }
    public static void totalbeli() throws SQLException{
        TransaksiProduk transaksiProduk = new TransaksiProduk();
        ResultSet statement = transaksiProduk.totalTransaksiPelanggan();
        int totalsemuanya = 0;
        while (statement.next()){
            totalsemuanya = statement.getInt("total_transaksi");
        }
        Scanner input = new Scanner(System.in);
        out.print("Total harga pembelian anda : Rp");
        out.println(totalsemuanya);
        out.print("Masukkan uang anda : ");
        int uang_anda = Integer.parseInt(input.nextLine());
        if (uang_anda < totalsemuanya){
            out.println("Uang anda tidak cukup!");
            totalbeli();
        } else {
            out.print("Uang anda bayar : Rp");
            out.println(uang_anda);
            out.print("Kembalian anda sebesar : Rp");
            out.println(uang_anda - totalsemuanya);
            out.println("Terima kasih, selamat datang kembali~");
            menuPegawai();
        }
    }
}