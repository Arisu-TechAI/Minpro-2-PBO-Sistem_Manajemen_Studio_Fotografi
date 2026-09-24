/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author USER
 */

// Class yang digunakan untuk mengambil (getter) data client


public class Client {
    private String idClient;
    private String namaClient;
    private String noTelp;

    public Client(String idClient, String namaClient, String noTelp) {
        this.idClient = idClient;
        this.namaClient = namaClient;
        this.noTelp = noTelp;
    }

    public String getIdClient() { return idClient; }
    public String getNamaClient() { return namaClient; }
    public String getNoTelp() { return noTelp; }
}