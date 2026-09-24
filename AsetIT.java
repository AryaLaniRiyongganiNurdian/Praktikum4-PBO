/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PBO.praktikum4.tugas;

/**
 *
 * @author Lani
 */
public class AsetIT {
 
    String idAset;
    String namaPerangkat;
    String lokasi;
    String statusKondisi;
 
    public AsetIT(String idAset, String namaPerangkat, String lokasi, String statusKondisi) {
        this.idAset = idAset;
        this.namaPerangkat = namaPerangkat;
        this.lokasi = lokasi;
        this.statusKondisi = statusKondisi;
    }
 
    public void tampilkanInfoAset() {
        System.out.println(idAset + " | " + namaPerangkat + " | " + lokasi + " | " + statusKondisi);
    }
}
 