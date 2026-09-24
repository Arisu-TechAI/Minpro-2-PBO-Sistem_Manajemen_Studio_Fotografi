/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.*;
import java.util.ArrayList;

/**
 *
 * @author USER
 */

public class Transaksi_Controller {
    private ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();
    private ArrayList<LayananFotografi> daftarPaket = new ArrayList<>();
    private int counterTransaksi = 1; // Untuk auto ID
    private int counterClient = 1;

    public Transaksi_Controller() {
        // Membuat Dummy data awal/bawaan
        daftarPaket.add(new PaketReguler("REG-01", "Paket Wisuda Single", 400000, 2));
        daftarPaket.add(new PaketReguler("REG-02", "Paket Family Portrait", 750000, 3));
        daftarPaket.add(new PaketEvent("EVT-01", "Paket Wedding Basic", 3500000, 2));
        daftarPaket.add(new PaketEvent("EVT-02", "Paket Wedding Premium", 7500000, 4));

        // Dummy Transaksi Awal agar fitur Read langsung ada isinya
        Client dummyClient = new Client(generateIdClient(), "Arizky Saputra", "081234567890");
        Transaksi dummyTrans = new Transaksi(generateIdTransaksi(), dummyClient, daftarPaket.get(0), "10-10-2026");
        daftarTransaksi.add(dummyTrans);
    }

    // Membuat Atribut Generate ID otomatis 
    public String generateIdTransaksi() {
        return String.format("TRX-%03d", counterTransaksi++);
    }

    public String generateIdClient() {
        return String.format("CLN-%03d", counterClient++);
    }

    public ArrayList<LayananFotografi> getDaftarPaket() {
        return daftarPaket;
    }

    // Method untuk mencari paket fotografi dari daftar "daftarPaket"
    public LayananFotografi cariPaket(String kode) {
        for (LayananFotografi p : daftarPaket) {
            if (p.getKodePaket().equalsIgnoreCase(kode)) {
                return p;
            }
        }
        return null; // Return null jika tidak ketemu
    }

    
    // Method untuk membuat/menambah Transaksi baru
    public void tambahTransaksi(Client client, LayananFotografi paket, String tanggal) {
        Transaksi t = new Transaksi(generateIdTransaksi(), client, paket, tanggal);
        daftarTransaksi.add(t);
    }
    // Menampilkan list Transaksi
    public void lihatSemuaTransaksi() {
        if (daftarTransaksi.isEmpty()) {
            System.out.println(">> Belum ada data transaksi <<");
        } else {
            for (Transaksi t : daftarTransaksi) {
                t.cetakStruk(true); // Memanggil method overload
            }
        }
    }

    // Verifikasi status pembayaran
    public boolean lunasiPembayaran(String id) {
        for (Transaksi t : daftarTransaksi) {
            if (t.getIdTransaksi().equalsIgnoreCase(id)) {
                t.setStatusPembayaran("Lunas");
                return true;
            }
        }
        return false;
    }
}