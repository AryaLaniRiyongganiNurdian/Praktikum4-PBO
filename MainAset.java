/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PBO.praktikum4.tugas;

/**
 *
 * @author Lani
 */
public class MainAset {
 
    public static void main(String[] args) {
        ManajemenAset manajemenAset = new ManajemenAset();

        manajemenAset.tambahAset(new AsetIT("A01", "Server", "Ruang Server", "Baik"));
        manajemenAset.tambahAset(new AsetIT("A02", "Router", "Ruang Jaringan", "Baik"));
        manajemenAset.tambahAset(new AsetIT("A03", "Switch", "Ruang Jaringan", "Rusak"));
        manajemenAset.tambahAset(new AsetIT("A04", "PC", "Lab Komputer", "Baik"));

        System.out.println("--- Data Aset IT ---");
        manajemenAset.tampilkanSemuaAset();

        System.out.println("\nMenghapus aset dengan ID A03");
        manajemenAset.hapusAset("A03");
 
        System.out.println("Mencoba menghapus aset dengan ID A99...");
        manajemenAset.hapusAset("A99");

        System.out.println("\n--- Data Aset IT ---");
        manajemenAset.tampilkanSemuaAset();
    }
}
 