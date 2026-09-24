/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author USER
 */

// Class yang berfungsi untuk menangani proses Transaksi (Pembayaran) di program Jasa Fotografi

public class Transaksi {
    private String idTransaksi;
    private Client client; 
    private LayananFotografi paket; 
    private String tanggalSesi;
    private String statusPembayaran; 

    public Transaksi(String idTransaksi, Client client, LayananFotografi paket, String tanggalSesi) {
        this.idTransaksi = idTransaksi;
        this.client = client;
        this.paket = paket;
        this.tanggalSesi = tanggalSesi;
        this.statusPembayaran = "Belum Lunas"; 
    }

    
    // Setter & Getter
    public String getIdTransaksi() { return idTransaksi; }
    public Client getClient() { return client; }
    public LayananFotografi getPaket() { return paket; }
    public String getTanggalSesi() { return tanggalSesi; }
    public String getStatusPembayaran() { return statusPembayaran; }
    public void setStatusPembayaran(String status) { this.statusPembayaran = status; }

    
    // Membuat Method Overloading
    public void cetakStruk() {
        cetakStruk(false); // Panggil method Overloading
    }

    
    public void cetakStruk(boolean tampilkanDetailPenuh) {
        System.out.println("\n--- STRUK TRANSAKSI [" + idTransaksi + "] ---");
        System.out.println("Klien        : " + client.getNamaClient() + " (" + client.getNoTelp() + ")");
        System.out.println("Paket        : " + paket.getNamaPaket() + " (Rp" + paket.getHarga() + ")");
        System.out.println("Tanggal Sesi : " + tanggalSesi);
        System.out.println("Status Bayar : " + statusPembayaran);
        
        if (tampilkanDetailPenuh) {
            System.out.println("- Spesifikasi Paket:");
            paket.detailLayanan(); // panggil method overriding dari subclass
        }
        System.out.println("------------------------------------");
    }
}