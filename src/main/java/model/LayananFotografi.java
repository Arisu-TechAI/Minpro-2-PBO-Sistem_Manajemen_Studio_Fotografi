/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author USER
 */

// SUPER-CLASS

// Class yang digunakan untuk menyimpan Jenis dan tipe layanan jasa Fotografi
// Class ini dibuat sebagai Super-Class, sehingga method-method yang ada disini dapat diwariskan ke Sub-Class lainnya


public abstract class LayananFotografi {
    // Access Modifier agar atribut dibawah bisa diakses di class lain
    protected String kodePaket;
    protected String namaPaket;
    protected double harga;

    public LayananFotografi(String kodePaket, String namaPaket, double harga) {
        this.kodePaket = kodePaket;
        this.namaPaket = namaPaket;
        this.harga = harga;
    }

    // Method Overriding 
    public abstract void detailLayanan();

    // Setter & Getter
    public String getKodePaket() { return kodePaket; }
    public String getNamaPaket() { return namaPaket; }
    public double getHarga() { return harga; }
}