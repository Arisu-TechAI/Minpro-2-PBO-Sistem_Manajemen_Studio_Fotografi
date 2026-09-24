/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Transaksi_Controller;
import model.Client;
import model.LayananFotografi;

import java.util.Scanner;

/**
 *
 * @author USER
 */

public class Menu {
    private Transaksi_Controller controller = new Transaksi_Controller();
    private Scanner scanner = new Scanner(System.in);

    // membuat proses loading sederhana
    private void loadingAnimasi(String pesan) {
        System.out.print(pesan);
        for (int i = 0; i < 4; i++) {
            try {
                Thread.sleep(300); // Jeda 300 milidetik
                System.out.print(".");
            } catch (InterruptedException e) { }
        }
        System.out.println();
    }

    // Menampilkan menu
    public void tampilkanMenu() {
        String pilihan;
        do {
            System.out.println("\n======================================");
            System.out.println("Studio Fotografi ");
            System.out.println("======================================");
            System.out.println("1. Tambah Pesanan Baru");
            System.out.println("2. Lihat Daftar Pesanan");
            System.out.println("3. Lunasi Pembayaran");
            System.out.println("0. Keluar Aplikasi");
            System.out.print("Pilih Menu: ");
            pilihan = scanner.nextLine().trim();

            switch (pilihan) {
                case "1": menuTambahPesanan(); break;
                case "2": 
                    loadingAnimasi("Loading...");
                    controller.lihatSemuaTransaksi(); 
                    break;
                case "3": menuLunasiPesanan(); break;
                case "0": loadingAnimasi("Menutup program"); break;
                default: System.out.println("Error: Pilihan tidak valid!");
            }
        } while (!pilihan.equals("0"));
    }

    private void menuTambahPesanan() {
        System.out.println("\n--- FORM PESANAN BARU ---");
        
        // Validasi Input Nama (Tidak boleh kosong / harus > 2 karakter)
        String nama = "";
        while (nama.length() < 3) {
            System.out.print("Masukkan Nama Klien (min 3 huruf): ");
            nama = scanner.nextLine().trim();
            if(nama.length() < 3) System.out.println("Nama terlalu pendek!");
        }

        // Validasi Input Nomor Telepon (Hanya angka dan min 10 digit)
        String noTelp = "";
        while (!noTelp.matches("\\d{10,14}")) {
            System.out.print("Masukkan No Telepon (10-14 digit angka): ");
            noTelp = scanner.nextLine().trim();
            if(!noTelp.matches("\\d{10,14}")) System.out.println("Format nomor telepon salah!");
        }

        System.out.println("\n=== KATALOG PAKET ===");
        for (LayananFotografi p : controller.getDaftarPaket()) {
            System.out.println("[" + p.getKodePaket() + "] " + p.getNamaPaket() + " - Rp" + p.getHarga());
        }

        // Validasi Input Paket
        LayananFotografi paketPilih = null;
        while (paketPilih == null) {
            System.out.print("\nMasukkan Kode Paket: ");
            String kode = scanner.nextLine().trim();
            paketPilih = controller.cariPaket(kode);
            
            if (paketPilih == null) {
                System.out.println("Kode paket tidak ditemukan. Silakan coba lagi!");
            }
        }

        System.out.print("Masukkan Tanggal Sesi (DD-MM-YYYY): ");
        String tgl = scanner.nextLine().trim();

        // Proses Pembuatan Pesanan
        loadingAnimasi("Menyimpan pesanan");
        Client clientBaru = new Client(controller.generateIdClient(), nama, noTelp);
        controller.tambahTransaksi(clientBaru, paketPilih, tgl);
        System.out.println("Pesanan Berhasil dibuat!.");
    }

    private void menuLunasiPesanan() {
        System.out.print("\nMasukkan ID Transaksi (Cth: TRX-001): ");
        String id = scanner.nextLine().trim();
        
        loadingAnimasi("Memverifikasi ID");
        if (controller.lunasiPembayaran(id)) {
            System.out.println("Pembayaran transaksi " + id + " LUNAS!");
        } else {
            System.out.println("Gagal: ID Transaksi tidak ditemukan.");
        }
    }
}