/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package id.ac.uniska.pbo2.p07.mini.proyek;

public enum StatusBuku {  // enum = daftar pilihan tetap (bukan class biasa)
    
    // ===== BAGIAN 1: DAFTAR PILIHAN =====
    TERSEDIA("Tersedia"),
    DIPINJAM("Dipinjam");

    // ===== BAGIAN 2: TULISAN UNTUK DITAMPILKAN =====
    private final String label;

    StatusBuku(String label) { //constructor: dipanggil otomatis untuk tiap pilihan di atas
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
