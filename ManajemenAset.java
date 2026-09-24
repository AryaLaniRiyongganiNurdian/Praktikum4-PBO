/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PBO.praktikum4.tugas;

/**
 *
 * @author Lani
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
 
public class ManajemenAset {
 
    List<AsetIT> daftarAset = new LinkedList<>();
 
    public void tambahAset(AsetIT asetBaru) {
        daftarAset.add(asetBaru);
    }

    public void tampilkanSemuaAset() {
        for (AsetIT a : daftarAset) {
            a.tampilkanInfoAset();
        }
    }

    public void hapusAset(String idAset) {
        Iterator<AsetIT> it = daftarAset.iterator();
        boolean ditemukan = false;
 
        while (it.hasNext()) {
            AsetIT asetSekarang = it.next();
            if (asetSekarang.idAset.equals(idAset)) {
                it.remove();
                ditemukan = true;
                break;
            }
        }
 
        if (!ditemukan) {
            System.out.println("Peringatan: Aset dengan ID \"" + idAset + "\" tidak ditemukan!");
        }
    }
}
 