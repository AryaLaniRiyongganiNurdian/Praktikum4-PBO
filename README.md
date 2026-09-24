# Tugas Praktikum 4 - Pemrograman Berorientasi Objek

## Array, List, Iterator

<p align="center">
  <img width="286" height="286" alt="image" src="https://github.com/user-attachments/assets/c2271d06-376d-46e9-ac2f-8856b022f5ec" /><br>
  <b>Nama: Arya Lani Riyonggani Nurdian<br>
  NIM: L0325002</b>
</p>   

## Penjelasan Kode

### AsetIT.java

```java
package PBO.praktikum4.tugas;

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
```

Class ini berfungsi sebagai model data aset IT. Terdapat empat atribut, yaitu `idAset`, `namaPerangkat`, `lokasi`, dan `statusKondisi`. Atribut ini tidak diberi kata kunci `private` sehingga masih bisa diakses langsung oleh `class` lain selama berada dalam `package` yang sama.

Constructor pada class ini adalah parameterized constructor yang digunakan untuk mengisi nilai keempat atribut ketika objek `AsetIT` dibuat. Kata kunci `this` digunakan untuk membedakan atribut milik objek dengan parameter yang memiliki nama sama.

Method `tampilkanInfoAset` digunakan untuk mencetak data aset dalam satu baris dengan format id, nama, lokasi, dan status yang dipisahkan tanda garis vertikal.

### ManajemenAset.java

```java
package PBO.praktikum4.tugas;

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
```

Class ini digunakan untuk mengelola kumpulan objek `AsetIT`. Variabel `daftarAset` dideklarasikan dengan tipe antarmuka `List` dan diimplementasikan menggunakan `LinkedList`. `LinkedList` dipilih karena lebih efisien untuk operasi tambah dan hapus data dibanding `ArrayList`.

Method `tambahAset` digunakan untuk menambahkan objek baru ke dalam list menggunakan method `add`. Ini termasuk operasi Create.

Method `tampilkanSemuaAset` digunakan untuk menampilkan seluruh data aset dengan cara melakukan perulangan `for each` pada `daftarAset`, kemudian memanggil method `tampilkanInfoAset` pada setiap objek. Ini termasuk operasi Read.

Method `hapusAset` digunakan untuk menghapus aset berdasarkan `idAset` yang dicari. Proses pencarian dan penghapusan dilakukan menggunakan `Iterator` agar aman, karena jika penghapusan dilakukan langsung pada list saat sedang melakukan perulangan `for each`, akan terjadi error `ConcurrentModificationException`.

Cara kerja method ini adalah sebagai berikut. Pertama, dibuat objek `Iterator` dari `daftarAset`. Selama masih terdapat elemen berikutnya, elemen diambil menggunakan method `next`. Kemudian `idAset` pada elemen tersebut dibandingkan dengan `idAset` yang dicari menggunakan method `equals`, karena yang dibandingkan adalah isi dari `String`. Jika ditemukan kecocokan, elemen dihapus menggunakan method `remove` milik iterator, variabel `ditemukan` diubah menjadi `true`, kemudian perulangan dihentikan menggunakan `break`. Jika setelah perulangan selesai variabel `ditemukan` masih bernilai `false`, maka akan ditampilkan pesan peringatan bahwa aset dengan id tersebut tidak ditemukan.

### MainAset.java

```java
package PBO.praktikum4.tugas;

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
```

Class ini merupakan class utama yang dijalankan pertama kali. Pertama, dibuat objek `ManajemenAset`. Kemudian ditambahkan empat data aset, yaitu Server, Router, Switch, dan PC menggunakan method `tambahAset`.

Setelah itu, seluruh data ditampilkan menggunakan `tampilkanSemuaAset` untuk melihat kondisi awal data. Selanjutnya dilakukan percobaan menghapus aset dengan id `A03` yang valid, dan dilanjutkan dengan percobaan menghapus aset dengan id `A99` yang tidak ada dalam data, untuk membuktikan bahwa pesan peringatan pada method `hapusAset` berfungsi dengan benar. Terakhir, data ditampilkan kembali untuk membuktikan bahwa proses penghapusan berhasil dilakukan.

## Output Program

```
--- Data Aset IT ---
A01 | Server | Ruang Server | Baik
A02 | Router | Ruang Jaringan | Baik
A03 | Switch | Ruang Jaringan | Rusak
A04 | PC | Lab Komputer | Baik

Menghapus aset dengan ID A03
Mencoba menghapus aset dengan ID A99...
Peringatan: Aset dengan ID "A99" tidak ditemukan!

--- Data Aset IT ---
A01 | Server | Ruang Server | Baik
A02 | Router | Ruang Jaringan | Baik
A04 | PC | Lab Komputer | Baik
```

## Penjelasan Output

Pada blok data pertama, ditampilkan seluruh empat aset sesuai urutan saat dimasukkan ke dalam list. Hal ini menunjukkan bahwa `List` menyimpan data sesuai urutan penambahan, dan perulangan `for each` pada method `tampilkanSemuaAset` berjalan dengan benar.

Baris "Menghapus aset dengan ID A03" dicetak oleh method `main` sebelum method `hapusAset` dipanggil. Karena id `A03` ditemukan dalam data, proses penghapusan berhasil tanpa menampilkan pesan peringatan.

Baris "Mencoba menghapus aset dengan ID A99..." juga dicetak oleh method `main`. Setelah itu muncul baris "Peringatan: Aset dengan ID A99 tidak ditemukan!" yang dicetak dari dalam method `hapusAset`. Hal ini terjadi karena iterator sudah menelusuri seluruh data yang tersisa, yaitu `A01`, `A02`, dan `A04`, namun tidak ada satu pun yang memiliki id `A99`, sehingga variabel `ditemukan` tetap bernilai `false` dan pesan peringatan ditampilkan.

Pada blok data terakhir, hanya tersisa tiga aset, yaitu `A01`, `A02`, dan `A04`. Aset dengan id `A03` sudah tidak muncul lagi karena telah berhasil dihapus, sedangkan data lain tidak terpengaruh dan urutannya tetap sama. Hal ini membuktikan bahwa proses penghapusan menggunakan `Iterator` berjalan dengan tepat.
