
package id.ac.uniska.pbo2.p07.tabel.dan.menu;

/**
 * Data satu kontak.
 * Perubahan dilakukan dengan mengganti objek lama
 * menggunakan objek baru.
 */
public record Kontak(
        String nama,
        String telepon,
        String email,
        Kategori kategori
) {
}

